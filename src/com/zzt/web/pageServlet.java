package com.zzt.web;

import com.zzt.Utils.WebUtils;
import com.zzt.pro.Manager;
import com.zzt.pro.Page;
import com.zzt.pro.product;
import com.zzt.service.impl.PageServiceImpl;
import com.zzt.service.impl.ProductServiceImpl;
import com.zzt.service.interface2.PageService;
import com.zzt.service.interface2.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import static com.zzt.pro.Page.Page_size;

public class pageServlet  extends  BaseServlet {
    PageService pageService = new PageServiceImpl();
    ProductService productService=new ProductServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page_size);
        String search = request.getParameter("search");
       double catagory=WebUtils.parseDouble(request.getParameter("catagory"),0);


        //获取分类的参数

        //判断是否有搜索
        if(search==null||search==""){
            //判断是否有点击超链接
            if(catagory!=0){
                //点击了超链接
                Page page = pageService.PageByCatagory(catagory, pageNo, pageSize);
                request.setAttribute("page", page);
                request.setAttribute("catagory",catagory);
            }
            else if(catagory==0){
                //没点击超链接
                Page page = pageService.getPage(pageNo, pageSize);
                request.setAttribute("page", page);
            }
        }
        else if(search!=null&&search!=""){
            //实现模糊查询并分页
            Page page = pageService.PageBySearch(pageNo, pageSize,search);
            request.setAttribute("search",search);
            request.setAttribute("page", page);
        }
        //跳转回页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
    protected void pageBySearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page_size);
        //获取搜索框里面的值
        String search = request.getParameter("search");

        Page page = pageService.PageBySearch(pageNo, pageSize,search);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);

    }
    //后台分页
    protected void pageHoutai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), 4);
        Manager manager =(Manager) request.getSession().getAttribute("manager");
        int id = manager.getId();
        System.out.println(id);
        //因为是后台，所以要根据后台商家的id获取到对应它麦的商品
        Page page = pageService.getPageHoutai(id, pageNo, pageSize);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/manager/manager-deleteOrUpdate.jsp").forward(request, response);


    }
    //后台删除商品
    protected void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取该商品得id;
        int productId = WebUtils.parseInt(request.getParameter("productId"), 1);
        //获取当前页码
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        //根据id查询商品
        product product = productService.getProductById(productId);
        //将商品放到下架区
        productService.reProduct(product);
        //根据商品id删除商品
        pageService.deteProduct(productId);
        //放送到pageHoutai重新查询 用重定向
        response.sendRedirect(request.getContextPath()+"/pageServlet?action=pageHoutai&pageNo="+pageNo);
    }
    //下架区展示商品
    protected void showdeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), 4);
        //获取当前商家 编号
        Manager manager =(Manager) request.getSession().getAttribute("manager");
        int shop=manager.getId();
        Page page = pageService.selectDeleteProduct(shop, pageNo, pageSize);
        request.setAttribute("page1",page);
        request.getRequestDispatcher("/pages/manager/manager-delete.jsp").forward(request,response);
    }


}
