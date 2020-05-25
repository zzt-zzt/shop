package com.zzt.pro;

public class Manager {
    private  Integer id;
    private  String managerName;
    private  String managerPassword;
    private  String managerPhone;
    private  String managerSignature;
    private  String managerPhoto;
    private  double managerMoney;

    public Manager() {
    }

    public Manager(Integer id, String managerName, String managerPassword, String managerPhone, String managerSignature, String managerPhoto, double managerMoney) {
        this.id = id;
        this.managerName = managerName;
        this.managerPassword = managerPassword;
        this.managerPhone = managerPhone;
        this.managerSignature = managerSignature;
        this.managerPhoto = managerPhoto;
        this.managerMoney = managerMoney;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", managerName='" + managerName + '\'' +
                ", managerPassword='" + managerPassword + '\'' +
                ", managerPhone='" + managerPhone + '\'' +
                ", managerSignature='" + managerSignature + '\'' +
                ", managerPhoto='" + managerPhoto + '\'' +
                ", managerMoney=" + managerMoney +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getManagerSignature() {
        return managerSignature;
    }

    public void setManagerSignature(String managerSignature) {
        this.managerSignature = managerSignature;
    }

    public String getManagerPhoto() {
        return managerPhoto;
    }

    public void setManagerPhoto(String managerPhoto) {
        this.managerPhoto = managerPhoto;
    }

    public double getManagerMoney() {
        return managerMoney;
    }

    public void setManagerMoney(double managerMoney) {
        this.managerMoney = managerMoney;
    }
}
