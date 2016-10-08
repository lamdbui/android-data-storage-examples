package com.lamdbui.resulttest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by lamdb_000 on 10/7/2016.
 */
public class ItemManager {

    private static ItemManager sItemManager;

    private ArrayList<String> mItems;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static ItemManager get(Context context) {
        if(sItemManager == null) {
            sItemManager = new ItemManager(context);
        }
        return sItemManager;
    }

    private ItemManager(Context context) {
        mItems = new ArrayList<>();
        mContext = context.getApplicationContext();
        mDatabase = new ItemBaseHelper(mContext)
                .getWritableDatabase();
    }

    public ArrayList<String> getItems() {
        return mItems;
    }

    public void addItem(String item) {
        mItems.add(item);
    }
}
