package com.zzt.Test;

import com.zzt.DAO.Interface1.ClientDAO;
import com.zzt.DAO.impl.ClientImpl;
import com.zzt.pro.Client;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientImplTest {
       ClientDAO clientDAO=new ClientImpl();
    @Test
    public void updateClient() {
    }

    @Test
    public void queryMoney() {
        double v = clientDAO.queryMoney(2);
        System.out.println(v);
    }

    @Test
    public void updateClientMoney() {
    }
}