package com.example.ian.applayout;

/**
 * Created by Finn on 05/03/2017.
 */

public class Item {

    private String name;
    private String catagory;
    private String description;
    private int price;

    public Item(String name,String catagory,int price){
        this.name = name;
        if(catagoryChoice(catagory))this.catagory = catagory; //If it is Starter||Main||Dessert||Side else NULL
        this.price = price;
    }

    public Item(String name,String catagory,String description ,int price){
        this.name = name;
        if(catagoryChoice(catagory))this.catagory = catagory; //If it is Starter||Main||Dessert||Side else NULL
        this.description = description;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public String getCatagory(){
        return catagory;
    }

    private boolean catagoryChoice(String catagory){
        return catagory.equalsIgnoreCase("STARTER") || catagory.equalsIgnoreCase("MAIN") || catagory.equalsIgnoreCase("DESSERT") || catagory.equalsIgnoreCase("SIDE");
    }
}
