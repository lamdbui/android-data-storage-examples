package com.lamdbui.resulttest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lamdbui.resulttest.ItemDbSchema.ItemTable;

import java.util.ArrayList;

/**
 * Created by lamdb_000 on 10/7/2016.
 */
public class ItemManager {

    private static ItemManager sItemManager;

    //private ArrayList<String> mItems;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static ItemManager get(Context context) {
        if(sItemManager == null) {
            sItemManager = new ItemManager(context);
        }
        return sItemManager;
    }

    private ItemManager(Context context) {
        //mItems = new ArrayList<>();
        mContext = context.getApplicationContext();
        mDatabase = new ItemBaseHelper(mContext)
                .getWritableDatabase();
    }

    // maybe change to use an actual object instead of direct string in the future
    private static ContentValues getContentValues(String item) {
        ContentValues values = new ContentValues();
        values.put(ItemTable.Cols.NAME, item);
        return values;
    }

    private Cursor queryItems(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                ItemTable.NAME,
                null,       // Columns, null - all columns
                whereClause,
                whereArgs,
                null,       // groupBy
                null,       // having
                null        // orderBy
        );

        return cursor;
    }

    public ArrayList<String> getItems() {
        //return mItems;
        ArrayList<String> items = new ArrayList<>();

        Cursor cursor = queryItems(null, null);
        try {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                items.add(cursor.getString(cursor.getColumnIndex(ItemTable.Cols.NAME)));
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return items;
    }

    public void addItem(String item) {
        //mItems.add(item);
        ContentValues values = getContentValues(item);
        mDatabase.insert(ItemTable.NAME, null, values);
    }
}
