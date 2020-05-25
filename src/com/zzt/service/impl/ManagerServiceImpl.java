package com.zzt.service.impl;

import com.zzt.DAO.Interface1.ManagerDAO;
import com.zzt.DAO.impl.ManagerImpl;
import com.zzt.service.interface2.ManagerService;
import com.zzt.pro.Manager;

public class ManagerServiceImpl implements ManagerService {
    ManagerDAO managerDAO=new ManagerImpl();
    @Override
    public void saveManager(Manager manager) {
        managerDAO.saveManager(manager);
    }

    @Override
    public Manager queryManagerByNameAndPassword(String name, String password) {
        return managerDAO.queryManagerByNameAndPassword(name,password);
    }

    @Override
    public Manager queryManagerByName(String name) {
        return managerDAO.queryManagerByName(name);
    }

    @Override
    public Manager queryManger(int shop) {
        return managerDAO.queryManger(shop);
    }

    @Override
    public Manager updateMangaer(Manager manager) {
        return  managerDAO.updateManager(manager);
    }
}
