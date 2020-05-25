package com.zzt.service.impl;

import com.zzt.DAO.BaseDAo;
import com.zzt.DAO.Interface1.PageDAO;
import com.zzt.DAO.impl.PageImpl;
import com.zzt.pro.Page;
import com.zzt.pro.product;
import com.zzt.service.interface2.PageService;

import java.util.List;

public class PageServiceImpl extends BaseDAo implements PageService {
    PageDAO pageDAO=new PageImpl();
    @Override
    public Page getPage(int pageNo, int pageSize) {
        //获取总记录数
        int pageCount = pageDAO.getPageCount();
        //获取每页的数据
        int pageBegin=(pageNo-1)*pageSize;
        List<product> products = pageDAO.returnProduct(pageBegin, pageSize);
        //获取总页数
        int pageToatl=pageCount/pageSize;
        if(pageCount%pageSize!=0){
            pageToatl+=1;}
        //获取page对象
        Page page=new Page();
        page.setPageNo(pageNo);
      page.setPageTotal(pageToatl);
        page.setPageCount(pageCount);
        page.setPageItem(products);
return  page;
    }

    @Override
    public Page getPageHoutai(int shop, int pageNo, int pageSize) {
        //获取总记录数
        int pageCount = pageDAO.countHoutai(shop);
        //获取每页的数据
        int pageBegin=(pageNo-1)*pageSize;
        List<product> products = pageDAO.shopProduct(shop,pageBegin,pageSize);
        //获取总页数
        int pageToatl=pageCount/pageSize;
        if(pageCount%pageSize!=0){
            pageToatl+=1;
        }
        Page page=new Page();
        page.setPageNo(pageNo);
        page.setPageTotal(pageToatl);
        page.setPageCount(pageCount);
        page.setPageItem(products);
        return  page;
    }

    @Override
    public Page selectDeleteProduct(int shop, int pageNo, int pageSize) {
        //获取总记录数
        int pagecount = pageDAO.countXiajia(shop);
        //每页的数据
        int pageBegin=(pageNo-1)*pageSize;
        List<product> products = pageDAO.selectProduct(shop, pageBegin, pageSize);
        //获取总页数
        int pageToatl=pagecount/pageSize;
        if(pagecount%pageSize!=0){
            pageToatl+=1;
        }
        Page page=new Page();
        page.setPageNo(pageNo);
        page.setPageTotal(pageToatl);
        page.setPageCount(pagecount);
        page.setPageItem(products);
        return  page;



    }

    @Override
    public Page PageBySearch(int pageNo, int pageSize, String key) {

            //获取总记录数
            int pageCount = pageDAO.getPageCountBysearch(key);
            //获取每页的数据
            int pageBegin=(pageNo-1)*pageSize;
            List<product> products = pageDAO.returnProductBysearch(key,pageBegin,pageSize);
            //获取总页数
            int pageToatl=pageCount/pageSize;
            if(pageCount%pageSize!=0){
                pageToatl+=1;
            }
            Page page=new Page();
            page.setPageNo(pageNo);
            page.setPageTotal(pageToatl);
            page.setPageCount(pageCount);
            page.setPageItem(products);
            return  page;

    }

    @Override
    public Page PageByCatagory(double catagory, int pageNo, int pageSize) {
        //获取总记录时
        int pageCount = pageDAO.getPageCountByCatagory(catagory);
        //获取起始位置
        int pagebegin=(pageNo-1)*pageSize;
        //获取总页码
        int pageTotal=pageCount/pageSize;
        if(pageCount%pageSize!=0){
            pageTotal+=1;
        }
        //获取记录数据
        List<product> products = pageDAO.returnProductByCatagory(catagory, pagebegin, pageSize);
        Page page=new Page();
        page.setPageNo(pageNo);
        page.setPageTotal(pageTotal);
        page.setPageCount(pageCount);
        page.setPageItem(products);
        return  page;

    }

    @Override
    public void deteProduct(int id) {
        pageDAO.deleteProduct(id);
    }
}
