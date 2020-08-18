package com.test.bloodbanking;

public class Req {
    public String view;
    public String reqId;


    public String getReqId() {
        return reqId;
    }

    @Override
    public String toString() {
        return "" + view ;
    }
}
