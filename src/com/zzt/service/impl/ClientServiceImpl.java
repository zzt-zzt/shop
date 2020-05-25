package com.zzt.service.impl;

import com.zzt.DAO.Interface1.ClientDAO;
import com.zzt.DAO.impl.ClientImpl;
import com.zzt.service.interface2.ClientService;
import com.zzt.pro.Client;

public class ClientServiceImpl implements ClientService{
    ClientDAO clientDAO=new ClientImpl();

    @Override
    public void saveClient(Client client) {
        clientDAO.saveClient(client);
    }

    @Override
    public Client queryClientByNameAndPassword(String name, String password) {
        return clientDAO.queryClientByNameAndPassword(name,password);
    }

    @Override
    public Client queryClientByName(String name) {
        return clientDAO.queryClientByName(name);
    }

    @Override
    public Client updateClient(Client client) {
        return  clientDAO.updateClient(client);
    }

}
