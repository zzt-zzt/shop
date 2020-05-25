package com.zzt.DAO.Interface1;

import com.zzt.pro.Client;

public interface ClientDAO {
    //保存用户信息对数据库实现删增改操作(注册用户信息）
          public void saveClient(Client client);
          //根据用户用户名和id查询用户
     public  Client queryClientByNameAndPassword(String name, String password);
     //根据用户名查询该用户名是否可用
    public Client queryClientByName(String name);
    //修改用户信息
    public Client updateClient(Client client);
    //查找用户账户的金钱
    public  double queryMoney(Integer id);
    //修改用户的账号金钱
    public void updateClientMoney(Integer id,double money);
}
