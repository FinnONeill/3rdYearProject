package com.example.ian.applayout.floor.contentLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ian on 08/03/2017.
 */

public class OrderReceived {
    /**
     * An array of sample (dummy) items.
     */
    public static ArrayList<ItemMenu> ITEMS_RECEIVED = new ArrayList<ItemMenu>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, ItemMenu> ITEM_MAP_RECEIVED = new HashMap<String, ItemMenu>();

    private static final int COUNT = 10;

    // ADD ITEMS TO LIST HERE SOMEWHERE I DUNNO

    private static void addItemReceived(ItemMenu item) {
        ITEMS_RECEIVED.add(item);
        ITEM_MAP_RECEIVED.put(item.id, item);
    }

    private static ItemMenu createOrderReceivedItem(int position, String name) {
        return new ItemMenu(String.valueOf(position), name , makeReceivedDetails(position));
    }

    private static String makeReceivedDetails(int position) {
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

