package com.test.bloodbanking;

public class Donation {

    public String name;
    public String phone;
    public String number;
    public String bloodgroup;
    public  String DID;
    public  String email;

    public String getDID() {
        return DID;
    }

    public Donation() {

    }


    @Override
    public String toString() {
        return "Donation{" +
                "name= '" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", number of bags =" + number +
                ", bloodgroup='" + bloodgroup + '\'' +
                '}';
    }
}
