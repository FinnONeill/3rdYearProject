package com.example.ian.applayout.floor.contentLists;

/**
 * Created by Ian on 06/03/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ian on 05/03/2017.
 */

public class OrderTotal {
    /**
     * An array of sample (dummy) items.
     */
    public static ArrayList<ItemMenu> ITEMS_MENU = new ArrayList<ItemMenu>();

    /**
     * A map of sample (dummy) items, by ID.
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
