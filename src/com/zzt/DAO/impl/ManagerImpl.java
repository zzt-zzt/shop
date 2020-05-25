package com.zzt.DAO.impl;

import com.zzt.DAO.BaseDAo;
import com.zzt.DAO.Interface1.ManagerDAO;
import com.zzt.pro.Manager;

public class ManagerImpl extends  BaseDAo implements ManagerDAO {
    @Override
    public void saveManager(Manager manager) {
        String sql="insert into manager values(?,?,?,?,?,?,?)";
        upDateOne(sql,manager.getId(),manager.getManagerName(),manager.getManagerPassword(),manager.getManagerPhone(),manager.getManagerSignature(),manager.getManagerPhoto(),10000);
    }

    @Override
    public Manager queryManagerByNameAndPassword(String name, String password) {
        String sql="select Manager_id id,Manager_name managerName,Manager_password managerPassword,Manager_phone managerPhone,Manager_signature managerSignature,Manager_photo managerPhoto,Manager_money  managerMoney from manager where Manager_name=?and Manager_password=?";
        return  queryObject(Manager.class,sql,name,password);
    }

    @Override
    public Manager queryManagerByName(String name) {
        String sql="select Manager_id id,Manager_name managerName,Manager_password managerPassword,Manager_phone managerPhone,Manager_signature managerSignature,Manager_photo managerPhoto from manager where Manager_name=?";
        return  queryOneList(Manager.class,sql,name);
    }

    @Override
    public Manager queryManger(int  shop) {
        String sql="select Manager_id id,Manager_name managerName,Manager_password managerPassword,Manager_phone managerPhone,Manager_signature managerSignature,Manager_photo managerPhoto,Manager_money managerMoney from manager where Manager_id=?";
        return  queryOneList(Manager.class,sql,shop);
    }

    @Override
    public Manager updateManager(Manager manager) {
        String  sql="update manager set Manager_name  =?,Manager_password =?,Manager_phone=?,Manager_signature=?,Manager_photo =?where Manager_id=?";
        upDateOne(sql,manager.getManagerName(),manager.getManagerPassword(),manager.getManagerPhone(),manager.getManagerSignature(),manager.getManagerPhoto(),manager.getId());
          return  manager;
    }

    @Override
    public double queryMoney(Integer id) {
        String sql="select Manager_money from manager where Manager_id=?";
      double  o =(double) queryForOne(sql, id);
      return  o;
    }

    @Override
    public void addMoney(double money, int id) {
        String sql="update manager set Manager_money =? where Manager_id=? ";
        double v = queryMoney(id);
        double nowMoney=v+money;
        upDateOne(sql,nowMoney,id);

    }
}
