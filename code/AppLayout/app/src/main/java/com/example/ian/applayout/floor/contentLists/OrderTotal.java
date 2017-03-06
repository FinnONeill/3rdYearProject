package com.example.ian.applayout.floor.contentLists;

/**
 * Created by Ian on 06/03/2017.
 */

import com.example.ian.applayout.floor.TotalListActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ian on 05/03/2017.
 */

public class OrderTotal {
    /**
     * An array of sample (dummy) items.
     */
    public static final List<ItemTotal> ITEMS_TOTAL = new ArrayList<ItemTotal>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, ItemTotal> ITEM_MAP_TOTAL = new HashMap<String, ItemTotal>();

    private static int COUNT = new TotalListActivity().totalNum;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItemTotal(createOrderTotalItem(i));
        }
    }

    public static void addItemTotal(ItemTotal item) {
        ITEMS_TOTAL.add(item);
        ITEM_MAP_TOTAL.put(item.id, item);
        COUNT++;
    }

    public static ItemTotal createOrderTotalItem(int position) {
        return new ItemTotal(String.valueOf(position), "Table Number " + position, makeTotalDetails(position));
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
    public static class ItemTotal {
        public final String id;
        public final String content;
        public final String details;

        public ItemTotal(String id, String content, String details) {
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
