package com.example.ian.applayout;

import android.text.format.Time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Finn on 05/03/2017.
 */

public class Order extends ArrayList<Item>{
    private ArrayList<Item> order;
    private String timeStamp;
    private int orderTotal;

    public Order (){
        order = new ArrayList<Item>();
        timeStamp = new SimpleDateFormat("ddMMyyyyhhmmss").format(new Date());
    }

    public String getTimeStamp(){
        return timeStamp.toString();
    }

    public int getOrderTotal(){
        int sum = 0;
        for(Item itemToAdd : order){
            sum = sum + itemToAdd.getPrice();
        }
        return sum;
    }
}
