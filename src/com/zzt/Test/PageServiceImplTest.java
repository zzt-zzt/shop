package com.zzt.Test;

import com.zzt.pro.Page;
import com.zzt.service.impl.PageServiceImpl;
import com.zzt.service.interface2.PageService;
import org.junit.Test;

import static org.junit.Assert.*;

public class PageServiceImplTest {
    PageService pageService=new PageServiceImpl();

    @Test
    public void getPage() {
    }

    @Test
    public void pageBySearch() {
        Page page = pageService.PageBySearch(1, 5, "安踏");
        System.out.println(page.getPageItem());
    }
}