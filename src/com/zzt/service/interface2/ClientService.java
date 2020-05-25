package com.zzt.service.interface2;

import com.zzt.pro.Client;

public interface ClientService {
    //保存顾客信息
    public void saveClient(Client client);
    //查询顾客数据，用于登录界面
    public Client queryClientByNameAndPassword(String name, String password);
    //查询顾客数据，看看用户名是否可用
    public Client queryClientByName(String name);
    //修改用户信息
    public Client updateClient(Client client);
}
