package com.zzt.pro;

public class Client {
    private  Integer id;
    private  String clientName;
    private  String clientPassword;
    private  String clientPhone;
    private  String clientSignature;
    private  String  clientPhoto;
    private  double clientMoney;

    public Client() {
    }

    public Client(Integer id, String clientName, String clientPassword, String clientPhone, String clientSignature, String clientPhoto, double clientMoney) {
        this.id = id;
        this.clientName = clientName;
        this.clientPassword = clientPassword;
        this.clientPhone = clientPhone;
        this.clientSignature = clientSignature;
        this.clientPhoto = clientPhoto;
        this.clientMoney = clientMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientSignature() {
        return clientSignature;
    }

    public void setClientSignature(String clientSignature) {
        this.clientSignature = clientSignature;
    }

    public String getClientPhoto() {
        return clientPhoto;
    }

    public void setClientPhoto(String clientPhoto) {
        this.clientPhoto = clientPhoto;
    }

    public double getClientMoney() {
        return clientMoney;
    }

    public void setClientMoney(double clientMoney) {
        this.clientMoney = clientMoney;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientPassword='" + clientPassword + '\'' +
                ", clientPhone='" + clientPhone + '\'' +
                ", clientSignature='" + clientSignature + '\'' +
                ", clientPhoto='" + clientPhoto + '\'' +
                ", clientMoney=" + clientMoney +
                '}';
    }
}
