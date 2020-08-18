package com.test.bloodbanking;

public class DonationHelp {

    public String show;
    public String DonId;


    public String getDonId() {
        return DonId;
    }


    @Override
    public String toString() {
        return "Donation :\n" + show;
    }
}
