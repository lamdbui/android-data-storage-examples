package com.lamdbui.resulttest;

import java.util.ArrayList;

/**
 * Created by lamdb_000 on 10/7/2016.
 */
public class ItemManager {

    private static ItemManager sItemManager;

    private ArrayList<String> mItems;

    public static ItemManager get() {
        if(sItemManager == null) {
            sItemManager = new ItemManager();
        }
        return sItemManager;
    }

    private ItemManager() {
        mItems = new ArrayList<>();
    }

    public ArrayList<String> getItems() {
        return mItems;
    }

    public void addItem(String item) {
        mItems.add(item);
    }
}
