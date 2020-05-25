package com.zzt.Test;

import com.zzt.DAO.Interface1.ManagerDAO;
import com.zzt.DAO.impl.ManagerImpl;
import org.junit.Test;
import com.zzt.pro.Manager;

public class ManagerImplTest {
     ManagerDAO managerDAO=new ManagerImpl();
    @Test
    public void saveManager() {
        Manager manager = managerDAO.queryManger(1);
        System.out.println(manager);
    }

    @Test
    public void queryManagerByNameAndPassword() {
        Manager bzzt = managerDAO.queryManagerByNameAndPassword("bzzt","873689");
        System.out.println(bzzt);

    }

    @Test

    public void queryManagerByName() {
        Manager manager = managerDAO.queryManagerByName("bzzt");
        System.out.println(manager);
    }

    @Test
    public void queryManger() {
        Manager manager = managerDAO.queryManger(1);
        System.out.println(manager);
    }
}