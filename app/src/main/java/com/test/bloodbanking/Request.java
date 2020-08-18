package com.test.bloodbanking;

public class Request {
    public String phonenum;
    public String num;
    public String reason;
    public String Location;
    public String bloodgroup;
    public String email;
    public String reqId;
    public String name;


    public Request(){}
    public Request(String phonenum, String num, String reason, String location, String bloodgroup, String email, String reqId, String name) {
        this.phonenum = phonenum;
        this.num = num;
        this.reason = reason;
        Location = location;
        this.bloodgroup = bloodgroup;
        this.email = email;
        this.reqId = reqId;
        this.name = name;
    }

    public String getReqId() {
        return reqId;
    }

    public String getName() {
        return name;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public String getNum() {
        return num;
    }

    public String getReason() {
        return reason;
    }

    public String getLocation() {
        return Location;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", num='" + num + '\'' +
                ", reason='" + reason + '\'' +
                ", Location='" + Location + '\'' +
                ", bloodgroup='" + bloodgroup + '\'' +
                '}';
    }
}
