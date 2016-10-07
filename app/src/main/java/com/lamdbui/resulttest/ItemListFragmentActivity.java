package com.lamdbui.resulttest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ItemListFragmentActivity extends AppCompatActivity {

    public static final String EXTRA_FRAGMENT_ITEM_LIST =
            "com.lamdbui.resulttest.extra_fragment_item_list";

    //private ArrayList<String> mItems;

    public static Intent newIntent(Context context, ArrayList<String> items) {
        Intent intent = new Intent(context, ItemListFragmentActivity.class);
        intent.putStringArrayListExtra(EXTRA_FRAGMENT_ITEM_LIST, items);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list_fragment);

        //mItems = getIntent().getStringArrayListExtra(EXTRA_FRAGMENT_ITEM_LIST);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.activity_item_list_fragment_container);

        if(fragment == null) {
            //fragment = ItemListFragment.newFragment(mItems);
            fragment = new ItemListFragment();

            fm.beginTransaction()
                    .add(R.id.activity_item_list_fragment_container, fragment)
                    .commit();
        }
    }
}
