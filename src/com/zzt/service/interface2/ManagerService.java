package com.zzt.service.interface2;

import com.zzt.pro.Manager;

public interface ManagerService {
    //保存商家信息
   public void saveManager(Manager manager);
    //查询商家数据，用于登录界面
   public Manager queryManagerByNameAndPassword(String name,String  password);
    //查询商家数据，看看用户名是否可用
    public Manager queryManagerByName(String name);
    public Manager queryManger(int shop);
     public Manager updateMangaer(Manager manager);
}
