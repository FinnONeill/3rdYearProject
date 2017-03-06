package com.example.ian.applayout;

/**
 * Created by Finn on 06/03/2017.
 */

public class Account {
    private String name;
    private String pps;
    private int tel;
    private String email;
    private int accountType;

    public Account(String name, String pps, int tel, String email, int accountType){
        this.name = name;
        this.pps = pps;
        this.tel = tel;
        this.email = email;
        this.accountType = accountType;
    }

    public int getAccountType(){
        return accountType;
    }
}
