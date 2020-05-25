package com.zzt.Test;

import com.zzt.service.impl.ManagerServiceImpl;
import com.zzt.service.interface2.ManagerService;
import org.junit.Test;
import com.zzt.pro.Manager;

public class ManagerServiceImplTest  {
       ManagerService managerService=new ManagerServiceImpl();
    @Test
    public void saveManager() {
      /*  managerService.saveManager(new Manager(null,"bzzt","873689","13531235108","奥利给","/images/ManagerTouxiang/5.jpg"));
        System.out.println("添加成功");*/
    }

    @Test
    public void queryManagerByNameAndPassword() {
        Manager bzzt = managerService.queryManagerByNameAndPassword("bzzt", "873689");
        System.out.println(bzzt);
        if(bzzt==null){
            System.out.println(111);
        }
        else{
            System.out.println(1231);
        }
        System.out.println(bzzt.getId());
    }

    @Test
    public void queryManagerByName() {
        Manager bzzt = managerService.queryManagerByName("bzzt" );
        System.out.println(bzzt);

    }


    @Test
    public void testSaveManager() {
        Manager manager = managerService.queryManger(1);
        System.out.println(manager);
    }

    @Test
    public void testQueryManagerByNameAndPassword() {
    }

    @Test
    public void testQueryManagerByName() {
    }
}