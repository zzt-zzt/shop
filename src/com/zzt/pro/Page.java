package com.zzt.pro;

import java.util.List;

public class Page {
    //设置每页显示的商品数量为 默认的值；
    public  static  final  Integer Page_size=8;
    private  Integer pageNo;//当前页码;
    private  Integer pageTotal;//总页码
    private  Integer pageCount;//总记录数；
    private  Integer pageSize=Page_size;//每页显示商品的数量
    private List<product> pageItem;//每页显示商品的数据

    public Page(Integer pageNo, Integer pageTotal, Integer pageCount, Integer pageSize, List<product> pageItem) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageCount = pageCount;
        this.pageSize = pageSize;
        this.pageItem = pageItem;
    }

    public Page() {
    }

    public static Integer getPage_size() {
        return Page_size;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<product> getPageItem() {
        return pageItem;
    }

    public void setPageItem(List<product> pageItem) {
        this.pageItem = pageItem;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", pageItem=" + pageItem +
                '}';
    }
}
