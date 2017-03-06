package com.example.ian.applayout.floor.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item Name" , "Starter" +position, makeDetails(position),12.45);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }/*
        builder.append("\nItem Name: "+ITEMS.get(position).getName());
        builder.append("\nItem Catagory: "+ITEMS.get(position).getCatagory());
        builder.append("\nItem Description: "+ITEMS.get(position).getDescription());
        builder.append("\nItem Price: "+ITEMS.get(position).getPrice());*/
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        private  String id;
        private String name;
        private String catagory;
        private String description;
        private double price;

        public DummyItem(String id, String name ,String catagory , String description, double price) {
            this.id = id;
            this.name = name;
            this.catagory = catagory;
            this.description = description;
            this.price = price;
        }

        public String getId(){return id;}

        @Override
        public String toString() {
            return name;
        }

        public String getName(){
            return name;
        }

        public double getPrice(){
            return price;
        }

        public String getCatagory(){
            return catagory;
        }

        public String getDescription(){return description;}
    }
}
