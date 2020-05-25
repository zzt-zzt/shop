package com.zzt.web;

import com.zzt.Utils.UploadUtils;
import com.zzt.Utils.WebUtils;
import com.zzt.pro.Manager;
import com.zzt.pro.product;
import com.zzt.service.impl.ProductServiceImpl;
import com.zzt.service.interface2.ProductService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class productServlet extends  BaseServlet {
    ProductService productService=new ProductServiceImpl();
    protected void retuenProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品id值
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //根据id查询商品
        product product = productService.getProductById(id);
        //获取页码值
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        //将商品放在request域中
        request.setAttribute("product",product);
        request.setAttribute("pageNo",pageNo);
        //转发到
        request.getRequestDispatcher("/pages/manager/manager-update.jsp").forward(request,response);

    }
    //修改商品信息
    protected void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取页码值
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        //获取商品id值
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //获取当前商家 编号
       Manager manager =(Manager) request.getSession().getAttribute("manager");
       int shop=manager.getId();
        //根据id查找商品 获取图片
        product productById = productService.getProductById(id);
        String images = productById.getImages();
        //获取商品名字
        String name = request.getParameter("name");
        String summary = request.getParameter("summary");
        double price = WebUtils.parseDouble(request.getParameter("price"), 0);
        int sales = WebUtils.parseInt(request.getParameter("sales"),0);
        String location = request.getParameter("location");
        double catagory = WebUtils.parseDouble(request.getParameter("catagory"), 0);
        product product=new product();
        product.setId(id);
        product.setName(name);
        product.setSummary(summary);
        product.setCatagory(catagory);
        product.setSales(sales);
        product.setLocation(location);
        product.setPrice(price);
        product.setImages(images);
        product.setShop(shop);
        productService.updateProduct(product);
        //重定向回商品页面
        response.sendRedirect(request.getContextPath()+"/pageServlet?action=pageHoutai&pageNo="+pageNo);



    }
    protected void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> map=new HashMap<String, String>();
        //获取当前商家 编号
        Manager manager =(Manager) request.getSession().getAttribute("manager");
        int shop=manager.getId();
        product product=new product();
        int total = WebUtils.parseInt(request.getParameter("total"), 1);
        if(ServletFileUpload.isMultipartContent(request)){
           FileItemFactory fileItemFactory=new DiskFileItemFactory();
           ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
           try {
               List<FileItem> list = servletFileUpload.parseRequest(request);
               for (FileItem fileItem:list){
                   if(fileItem.isFormField()){
                       System.out.println(fileItem.getFieldName());
                       System.out.println(fileItem.getString("utf-8"));
                       map.put(fileItem.getFieldName(),fileItem.getString("utf-8"));
                       System.out.println(map);


                   }
                   else{

                       String oldname = fileItem.getName();
                       String newFilename = UploadUtils.newFilename(oldname);
                       String dir = UploadUtils.getDir(oldname);
                       //获取tomcat服务器下的路径
                       String realPath = request.getSession().getServletContext().getRealPath("/product");
                       String path=realPath+dir;
                       File newDir=new File(path);
                       if(!newDir.exists()){
                           newDir.mkdirs();
                       }
                       File file=new File(path,newFilename);
                       if(!file.exists()){
                           file.createNewFile();
                       }
                       InputStream inputStream=fileItem.getInputStream();
                       OutputStream outputStream=new FileOutputStream(file);
                       IOUtils.copy(inputStream,outputStream);
                       //释放资源
                       IOUtils.closeQuietly(inputStream);
                       IOUtils.closeQuietly(outputStream);
                       map.put("images","product"+dir+newFilename);
                       BeanUtils.populate(product,map);
                       System.out.println(product);
                       product.setShop(shop);
                       System.out.println(product);
                       productService.addProduct(product);
                       response.sendRedirect(request.getContextPath()+"/pageServlet?action=pageHoutai&pageNo="+total);
                       System.out.println("添加成功");

                   }


               }
           } catch (Exception e) {
               e.printStackTrace();
           }
       }

    }
    protected void change(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int total = WebUtils.parseInt(request.getParameter("total"), 1);
        request.setAttribute("total",total);
        request.getRequestDispatcher("/pages/manager/manager-add.jsp").forward(request,response);

    }
    protected void addAndDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //获取下架商品的编号
        int id = WebUtils.parseInt(request.getParameter("id"), 1);
        //查询下架商品
        product deleteProduct= productService.getDeleteProductByID(id);
        //将下架商品重新添加到货区
        productService.addProduct(deleteProduct);
        //下架区删除商品
        productService.delete(id);
        response.sendRedirect(request.getContextPath()+"/pageServlet?action=pageHoutai");
    }

    protected void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品的编号
        int id = WebUtils.parseInt(request.getParameter("productId"), 1);
      //查询商品
        product product = productService.getProductById(id);
        System.out.println(product);
        request.setAttribute("product1",product);
        request.getRequestDispatcher("/pages/client/details.jsp").forward(request,response);
    }


}
