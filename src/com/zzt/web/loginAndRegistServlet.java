package com.zzt.web;

import com.google.gson.Gson;
import com.zzt.Utils.CookieUtils;
import com.zzt.Utils.UploadUtils;
import com.zzt.pro.Manager;
import com.zzt.service.impl.ClientServiceImpl;
import com.zzt.service.impl.ManagerServiceImpl;
import com.zzt.service.interface2.ClientService;
import com.zzt.service.interface2.ManagerService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.zzt.pro.Client;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class loginAndRegistServlet extends BaseServlet{
    ClientService clientService=new ClientServiceImpl();
    ManagerService managerService=new ManagerServiceImpl();
    protected void clientRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //因为有上传图片
        //先判断是否为多短数据
        Map<String ,String> map=new HashMap<String ,String>();
         if(ServletFileUpload.isMultipartContent(request)){
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
            //解析数据得到每一个的表单项
             try {
                 List<FileItem> list = servletFileUpload.parseRequest(request);
                 //获取到list集合中最后一个，即验证码
                 FileItem fileItem1 = list.get(list.size()-1);
                 //获取验证码图片中验证码
                 String code =(String) request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
                 //获取验证码后要把它删除
                 request.removeAttribute("KAPTCHA_SESSION_KEY");
                 //判断两个是否是否相等
                 if(fileItem1.getString("UTF-8")!=""&&code.equals(fileItem1.getString("UTF-8"))){

                     for(FileItem fileItem:list){
                         //判断是否为普通型

                         if(fileItem.isFormField()){//把表单项的名称和数据放到map集合
                             map.put(fileItem.getFieldName(),fileItem.getString("utf-8"));
                         }
                         else{
                             String name = fileItem.getName();
                             //调用uploadutils工具类来获取新的文件名和目录
                             String newFileName = UploadUtils.newFilename(name);
                             String dir = UploadUtils.getDir(name);

                             //获取当前项目再tomcat服务器下的路径
                             String  path=request.getSession().getServletContext().getRealPath("/images/ClientTouxiang");
                             String  newPath=path+dir;
                             System.out.println(newPath);
                             //判断文件夹是否存在，不存在就新建一个(多层目录要用mkdirs）
                             File mkdir=new File(newPath);
                             if(!mkdir.exists()){
                                 mkdir.mkdirs();
                             }//判断文件是否存在，不存在就新建一个

                             File file=new File(mkdir,newFileName);
                             if(!file.exists()) {
                                 file.createNewFile();
                             }
                             InputStream inputStream=fileItem.getInputStream();
                             OutputStream outputStream=new FileOutputStream(file);
                             IOUtils.copy(inputStream,outputStream);
                             //释放资源
                             IOUtils.closeQuietly(inputStream);
                             IOUtils.closeQuietly(outputStream);
                             map.remove("code");//移除不属于Bean中的元素
                             map.remove("repwd");//移除不属于Bean中的元素
                             Client client=new Client();
                             map.put("clientPhoto","images/ClientTouxiang"+dir+newFileName);
                             BeanUtils.populate(client,map);
                            clientService.saveClient(client);//保存用户数据
                             request.getSession().setAttribute("client",client);
                             request.getRequestDispatcher("/index.jsp").forward(request,response);//回到首页

                         }
                 }

                 }
                 else{
                     request.setAttribute("clientName",list.get(0).getString("utf-8"));
                     request.setAttribute("clientPhone",list.get(3).getString("utf-8"));
                     request.setAttribute("clientSignture",list.get(4).getString("utf-8"));
                      request.setAttribute("codeNot","验证码不正确");
                      request.getRequestDispatcher("/pages/user/client-regist.jsp").forward(request,response);
                 }
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
    }
    protected void managerRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先判断是否为多短数据
        Map<String ,String> map=new HashMap<String ,String>();
        if(ServletFileUpload.isMultipartContent(request)){
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
            //解析数据得到每一个的表单项
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                //获取到list集合中最后一个，即验证码
                FileItem fileItem1 = list.get(list.size()-1);
                //获取验证码图片中验证码
                String code =(String) request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
                //获取验证码后要把它删除
                request.removeAttribute("KAPTCHA_SESSION_KEY");
                //判断两个是否是否相等
                if(fileItem1.getString("UTF-8")!=""&&code.equals(fileItem1.getString("UTF-8"))){

                    for(FileItem fileItem:list){
                        //判断是否为普通型

                        if(fileItem.isFormField()){//把表单项的名称和数据放到map集合
                            map.put(fileItem.getFieldName(),fileItem.getString("utf-8"));
                        }
                        else{
                            String name = fileItem.getName();
                            //调用uploadutils工具类来获取新的文件名和目录
                            String newFileName = UploadUtils.newFilename(name);
                            String dir = UploadUtils.getDir(name);

                            //获取当前项目再tomcat服务器下的路径
                            String  path=request.getSession().getServletContext().getRealPath("/images/ManagerTouxiang");
                            String  newPath=path+dir;
                            System.out.println(newPath);
                            //判断文件夹是否存在，不存在就新建一个(多层目录要用mkdirs）
                            File mkdir=new File(newPath);
                            if(!mkdir.exists()){
                                mkdir.mkdirs();
                            }//判断文件是否存在，不存在就新建一个

                            File file=new File(mkdir,newFileName);
                            if(!file.exists()) {
                                file.createNewFile();
                            }
                            InputStream inputStream=fileItem.getInputStream();
                            OutputStream outputStream=new FileOutputStream(file);
                            IOUtils.copy(inputStream,outputStream);
                            //释放资源
                            IOUtils.closeQuietly(inputStream);
                            IOUtils.closeQuietly(outputStream);
                            map.remove("code");//移除不属于Bean中的元素
                            map.remove("repwd");//移除不属于Bean中的元素

                            map.put("managerPhoto","images/ManagerTouxiang"+dir+newFileName);


                        }
                    }
                    Manager manager=new Manager();
                    BeanUtils.populate(manager,map);
                    managerService.saveManager(manager);//保存用户数据
                    request.getSession().setAttribute("manager",manager);
                    request.getRequestDispatcher("/index.jsp").forward(request,response);//回到首页
                }
                else{
                    request.setAttribute("managerName",list.get(0).getString("utf-8"));
                    request.setAttribute("managerPhone",list.get(3).getString("utf-8"));
                    request.setAttribute("managerSignture",list.get(4).getString("utf-8"));
                    request.setAttribute("codeNot","验证码不正确");
                    request.getRequestDispatcher("/pages/user/shopper-regist.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("client");
        request.getSession().removeAttribute("manager");
        request.getSession().removeAttribute("cart1");
        //删除掉cookie
        Cookie cookie=CookieUtils.returnCookie(request,"name-password");
        if(cookie!=null){
            //设置cooki的存活时间
            cookie.setMaxAge(0);
            //设置cookie的作用路径
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
        }
        //返回首页
       response.sendRedirect("http://localhost:8080/lce/index.jsp");
    }
    protected void usernameExit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //获取请求的参数(名字)
        String name = request.getParameter("name");
        //调用方法看看用户名是否存在
        Client client = clientService.queryClientByName(name);
        Map<String,Integer> map=new HashMap<>();
        if(client!=null){
            //用户名存在
            map.put("result",0);
        }else {
            //用户名不存在，可用
            map.put("result",1);
        }
        //将map对象转化为json对象
        Gson gson=new Gson();
        String s = gson.toJson(map);
        //响应除去
        response.getWriter().print(s);
    }
    protected void managerExit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数(名字)
        String name = request.getParameter("name");
        //调用方法看看用户名是否存在
        Manager manager = managerService.queryManagerByName(name);
        Map<String,Integer> map=new HashMap<>();
        if(manager!=null){
            //用户名存在
            map.put("result",0);
        }else {
            //用户名不存在，可用
            map.put("result",1);
        }
        //将map对象转化为json对象
        Gson gson=new Gson();
        String s = gson.toJson(map);
        //响应除去
        response.getWriter().write(s);
    }
    protected void clientLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数(名字)
        String remember = request.getParameter("remember");
        String name = request.getParameter("name");
       String  password=request.getParameter("password");
        //就是商家登录后在购物车里挑选商品，然后购买时要登陆顾客的账号，就要先把商家的信息在session中删除掉
       Manager  manager =(Manager) request.getSession().getAttribute("manager");
       if(manager!=null){
           request.getSession().removeAttribute("manager");
       }
        //根据名字和密码查询
        Client client = clientService.queryClientByNameAndPassword(name, password);
        if(client!=null){
            //判断是否记住密码
            request.getSession().setAttribute("client", client);//将用户信息保存在session
            //判断是否记住密码
            if(remember==null){
                System.out.println("不记住");
            }
            else if(remember.equals("remember")){
                CookieUtils.addCookie("name-password",name,password,7*24*60*60,response,request);
            }
            request.getRequestDispatcher("/cartServlet?action=judgeCooike").forward(request, response);

        }
        else{
            request.setAttribute("login-tip", "用户名或密码错误");
            request.setAttribute("name", name);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }
    protected void managerLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数(名字)
        String remember = request.getParameter("remember");
        String name = request.getParameter("name");
        String  password=request.getParameter("password");
        Client client = (Client)request.getSession().getAttribute("client");
        if(client!=null){
            request.getSession().removeAttribute("client");
        }
        //根据名字和密码查询
        Manager manager = managerService.queryManagerByNameAndPassword(name, password);
        if(manager!=null){
            //判断是否记住密码
            request.getSession().setAttribute("manager", manager);//将用户信息保存在session
            //判断是否记住密码
            if(remember==null){
                System.out.println("不记住");
            }
            else if(remember.equals("remember")){
                CookieUtils.addCookie("name-password",name,password,7*24*60*60,response,request);
            }
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else{
            request.setAttribute("login-tip", "用户名或密码错误");
            request.setAttribute("name", name);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }
    protected void clientUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //获取session中的用户信息
        Map<String ,String> map=new HashMap<String ,String>();
      Client client =(Client) request.getSession().getAttribute("client");
        //先判断是否为多段数据
        if(ServletFileUpload.isMultipartContent(request)){
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for(FileItem fileItem:list){
                    if(fileItem.isFormField()){
                        //普通形式
                        map.put(fileItem.getFieldName(),fileItem.getString("utf-8"));

                    }
                    else{

                            String name = fileItem.getName();
                            if(name!=null&&name!=""){
                            //调用uploadutils工具类来获取新的文件名和目录
                            String newFileName = UploadUtils.newFilename(name);
                            String dir = UploadUtils.getDir(name);
                            //获取当前项目再tomcat服务器下的路径
                            String  path=request.getSession().getServletContext().getRealPath("/images/ClientTouxiang");
                            String  newPath=path+dir;
                            System.out.println(newPath);
                            //判断文件夹是否存在，不存在就新建一个(多层目录要用mkdirs）
                            File mkdir=new File(newPath);
                            if(!mkdir.exists()){
                                mkdir.mkdirs();
                            }//判断文件是否存在，不存在就新建一个
                            File file=new File(mkdir,newFileName);
                            if(!file.exists()) {
                                file.createNewFile();
                            }
                            InputStream inputStream=fileItem.getInputStream();
                            OutputStream outputStream=new FileOutputStream(file);
                            IOUtils.copy(inputStream,outputStream);
                            //释放资源
                            IOUtils.closeQuietly(inputStream);
                            IOUtils.closeQuietly(outputStream);
                            map.put("clientPhoto","images/ClientTouxiang"+dir+newFileName);
                        }




                    }
                }
                map.remove("repwd");
                Client client1=new Client();
                BeanUtils.populate(client1,map);
                String clientPhoto = client1.getClientPhoto();
                //没有修改照片
                if(clientPhoto==null||clientPhoto==""){
                   Client client2= clientService.updateClient(new Client(client.getId(),client1.getClientName(),client1.getClientPassword(),client1.getClientPhone(),client1.getClientSignature(),client.getClientPhoto(),client.getClientMoney()));
                    System.out.println(client2);
                    request.getSession().setAttribute("client",client2);
                    request.getRequestDispatcher("/index.jsp").forward(request,response);//回到首页
                }else{
                    //修改了照片
                  Client client2=  clientService.updateClient(new Client(client.getId(),client1.getClientName(),client1.getClientPassword(),client1.getClientPhone(),client1.getClientSignature(),client1.getClientPhoto(),client.getClientMoney()));
                    System.out.println(client2);
                    request.getSession().setAttribute("client",client2);
                    request.getRequestDispatcher("/index.jsp").forward(request,response);//回到首页

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    protected void managerUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session中的用户信息
        Map<String, String> map = new HashMap<String, String>();
        Manager manager = (Manager) request.getSession().getAttribute("manager");
        //先判断是否为多段数据
        if (ServletFileUpload.isMultipartContent(request)) {
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        //普通形式
                        map.put(fileItem.getFieldName(), fileItem.getString("utf-8"));

                    } else {

                        String name = fileItem.getName();
                        if (name != null && name != "") {
                            //调用uploadutils工具类来获取新的文件名和目录
                            String newFileName = UploadUtils.newFilename(name);
                            String dir = UploadUtils.getDir(name);
                            //获取当前项目再tomcat服务器下的路径
                            String path = request.getSession().getServletContext().getRealPath("/images/ManagerTouxiang");
                            String newPath = path + dir;
                            System.out.println(newPath);
                            //判断文件夹是否存在，不存在就新建一个(多层目录要用mkdirs）
                            File mkdir = new File(newPath);
                            if (!mkdir.exists()) {
                                mkdir.mkdirs();
                            }//判断文件是否存在，不存在就新建一个
                            File file = new File(mkdir, newFileName);
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            InputStream inputStream = fileItem.getInputStream();
                            OutputStream outputStream = new FileOutputStream(file);
                            IOUtils.copy(inputStream, outputStream);
                            //释放资源
                            IOUtils.closeQuietly(inputStream);
                            IOUtils.closeQuietly(outputStream);
                            map.put("managerPhoto", "images/ManagerTouxiang" + dir + newFileName);
                        }


                    }
                }
                map.remove("repwd");
                Manager manager1 = new Manager();
                BeanUtils.populate(manager1, map);
                String managerPhoto = manager1.getManagerPhoto();
                //没有修改照片
                if (managerPhoto == null || managerPhoto == "") {
                    Manager manager2 = managerService.updateMangaer(new Manager(manager.getId(), manager1.getManagerName(), manager1.getManagerPassword(), manager1.getManagerPhone(), manager1.getManagerSignature(), manager.getManagerPhoto(),manager.getManagerMoney()));
                    System.out.println(manager2);
                    request.getSession().setAttribute("manager", manager2);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);//回到首页
                } else {
                    //修改了照片
                    Manager manager2 = managerService.updateMangaer(new Manager(manager.getId(), manager1.getManagerName(), manager1.getManagerPassword(), manager1.getManagerPhone(), manager1.getManagerSignature(), manager1.getManagerPhoto(),manager.getManagerMoney()));
                    System.out.println(manager2);
                    request.getSession().setAttribute("manager", manager2);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);//回到首页

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
