package com.example.ian.applayout.floor.contentLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A helper class to add Items to an Order
 */

public class OrderTotal {
    /**
     * An array of items in an Order.
     */
    public static ArrayList<ItemMenu> ITEMS_MENU = new ArrayList<ItemMenu>();

    /**
     * A map of sample items in an Order, by ID.
     */
    public static final Map<String, ItemMenu> ITEM_MAP_MENU = new HashMap<String, ItemMenu>();

    public static void addItemTotal(ItemMenu item) {
        ITEMS_MENU.add(item);
        ITEM_MAP_MENU.put(item.id, item);
    }

    public static ItemMenu createOrderTotalItem(int position, String name) {
        return new ItemMenu(String.valueOf(position), name , makeTotalDetails(position));
    }

    public static String makeTotalDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ItemMenu {
        public final String id;
        public String content;
        public final String details;

        public ItemMenu(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
