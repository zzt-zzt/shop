package com.zzt.web;

import com.zzt.Utils.CookieUtils;
import com.zzt.pro.Client;
import com.zzt.pro.Manager;
import com.zzt.service.impl.ClientServiceImpl;
import com.zzt.service.impl.ManagerServiceImpl;
import com.zzt.service.interface2.ClientService;
import com.zzt.service.interface2.ManagerService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebFilter(filterName = "loginFilter")
public class loginFilter implements Filter {
    ClientService clientService=new ClientServiceImpl();
    ManagerService managerService=new ManagerServiceImpl();
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转化 ，将req转化为Httpservlet request
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse)resp;
        //设置请求的编码为UTF-8；
        request.setCharacterEncoding("UTF-8");
        //设置响应的编码为UTF-8；
        response.setContentType("text/html; charset=UTF-8");
             //判断cook中有没有所对应的值
        Cookie cookie = CookieUtils.returnCookie(request, "name-password");
        if(cookie !=null){
            //获取cook的属性值 (属性值由密码和用户名组成 ，所以需要分割）
            String value = URLDecoder.decode(cookie.getValue(),"UTF-8");
            String[] split = value.split("#");
            System.out.println(split[0]);
            System.out.println(split[1]);
            //查询client与manager
            Client client = clientService.queryClientByNameAndPassword(split[0], split[1]);
            Manager manager = managerService.queryManagerByNameAndPassword(split[0],split[1]);
            if(client==null&&manager==null){
                request.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
                return;
            }else if(client!=null&&manager==null){
                request.getSession().setAttribute("client",client);
                request.getSession().removeAttribute("manager");
                chain.doFilter(req,resp);

            }else if(client==null&&manager!=null){
                request.getSession().setAttribute("manager",manager);
                request.getSession().removeAttribute("client");
                chain.doFilter(req,resp);

            }

        }else {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
