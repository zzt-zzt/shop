package com.zzt.DAO.Interface1;

import com.zzt.pro.Manager;

public interface ManagerDAO {
    //保存用户信息
    public void saveManager(Manager manager);
    //根据商家名称和密码获取manager
    public Manager queryManagerByNameAndPassword(String name, String password);
    //根据用户名查询该用户名是否可用
    public Manager queryManagerByName(String name);
    //根据商家id查询商家
    Manager queryManger(int shop);
    //修改商家信息
    public Manager updateManager(Manager manager);
    //查询商家的金钱
    public double queryMoney(Integer id);
    //增加商家的金钱
    public void addMoney(double money,int id);

}
