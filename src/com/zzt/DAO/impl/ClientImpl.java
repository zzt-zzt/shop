package com.zzt.DAO.impl;

import com.zzt.DAO.BaseDAo;
import com.zzt.DAO.Interface1.ClientDAO;
import com.zzt.pro.Client;

public class ClientImpl extends BaseDAo implements ClientDAO {
    @Override
    public void saveClient(Client client) {
         String sql="insert into client values(?,?,?,?,?,?,?)";
         upDateOne(sql,client.getId(),client.getClientName(),client.getClientPassword(),client.getClientPhone(),client.getClientSignature(),client.getClientPhoto(),10000);
    }

    @Override
    public Client queryClientByNameAndPassword(String name, String password) {
        String sql="select Client_id id,Client_name clientName,Client_password clientPassword,Client_phone clientPhone,Client_signature clientSignature,Client_photo clientPhoto ,Client_money clientMoney from client where Client_name=?and Client_password=?";
        Client client = queryOneList(Client.class, sql, name, password);
        return  client;
    }

    @Override
    public Client updateClient(Client client) {
        String sql="update client set  Client_name=?,Client_password=?,Client_phone=?,Client_signature=?,Client_photo=? where Client_id=?";
        upDateOne(sql,client.getClientName(),client.getClientPassword(),client.getClientPhone(),client.getClientSignature(),client.getClientPhoto(),client.getId());
         return  client;
    }

    @Override
    public Client queryClientByName(String name) {
        String  sql="select Client_id id,Client_name clientName,Client_password clientPassword,Client_phone clientPhone,Client_signature clientSignature,Client_photo clientPhoto from client where Client_name=?";
        Client client = queryObject(Client.class, sql, name);
        return  client;
    }

    @Override
    public double queryMoney(Integer id) {
      String sql="select  Client_money clientMoney from client where Client_id=?";
       double  o =(double) queryForOne(sql, id);
       return  o;
    }

    @Override
    public void updateClientMoney(Integer id, double money) {
        String sql="update client set Client_money=? where Client_id=?";
        double preMoney = queryMoney(id);
        System.out.println(preMoney);
        System.out.println(money);
        double NowMoney=preMoney-money;
        System.out.println(NowMoney);
        upDateOne(sql,NowMoney,id);
    }
}
