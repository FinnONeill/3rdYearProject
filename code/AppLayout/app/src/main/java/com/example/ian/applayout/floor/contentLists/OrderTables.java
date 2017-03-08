package com.example.ian.applayout.floor.contentLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A helper class to update the UI with table numbers
 */
public class OrderTables {
    /**
     * An array of tables.
     */
    public static final List<DummyItemTables> ITEMS_TABLES = new ArrayList<DummyItemTables>();

    /**
     * A map of tables, by ID.
     */
    public static final Map<String, DummyItemTables> ITEM_MAP_TABLES = new HashMap<String, DummyItemTables>();

    private static final int COUNT = 25;

    static {
        // Add some items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItemTables(i));
        }
    }

    private static void addItem(DummyItemTables item) {
        ITEMS_TABLES.add(item);
        ITEM_MAP_TABLES.put(item.id, item);
    }

    private static DummyItemTables createDummyItemTables(int position) {
        return new DummyItemTables(String.valueOf(position), "Table Number " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
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
    public static class DummyItemTables {
        public final String id;
        public final String content;
        public final String details;

        public DummyItemTables(String id, String content, String details) {
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
