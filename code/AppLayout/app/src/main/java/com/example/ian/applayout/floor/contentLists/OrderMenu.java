package com.example.ian.applayout.floor.contentLists;

import com.example.ian.applayout.MenuGetter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OrderMenu is the class a helper class to be able to add Menu Items to the UI.
 */
public class OrderMenu {

    /**
     * An array of items.
     */
    public static final List<MenuItem> ITEMS = new ArrayList<MenuItem>();

    /**
     * A map of items, by ID.
     */
    public static final Map<String, MenuItem> ITEM_MAP = new HashMap<String, MenuItem>();

    private static final int COUNT = MenuGetter.menu.size();

    static {
        // Add some sample items.
        for (int i = 0; i <COUNT; i++) {
            addItem(createMenuItem(i));
        }
    }

    private static void addItem(MenuItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static MenuItem createMenuItem(int position) {
        String desc = "Catagory: \t"+MenuGetter.menu.get(position).getCatagory();
        desc = desc + "\nDescription: \t"+ MenuGetter.menu.get(position).getDescription();
        desc = desc + "\nPrice: \t€" + MenuGetter.menu.get(position).getPrice();
        return new MenuItem(String.valueOf(position+1), MenuGetter.menu.get(position).getName(), desc);
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
    public static class MenuItem {
        public final String id;
        public final String content;    //name of menu Item
        public final String details;    //description of menu item

        public MenuItem(String id, String content, String details) {
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
