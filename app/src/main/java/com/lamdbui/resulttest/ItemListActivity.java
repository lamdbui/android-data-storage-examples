package com.lamdbui.resulttest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {

    private static final String EXTRA_ITEM_LIST =
            "com.lamdbui.resulttest.extra_item_list";

    private TextView mItemCountTextView;

    // used as a local list that will be passed back later
    ArrayList<String> mItems;

    public static Intent newIntent(Context packageContext, ArrayList<String> items) {
        Intent intent = new Intent(packageContext, ItemListActivity.class);
        intent.putStringArrayListExtra(EXTRA_ITEM_LIST, items);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        mItems = getIntent().getStringArrayListExtra(EXTRA_ITEM_LIST);

        mItemCountTextView = (TextView) findViewById(R.id.num_of_passed_in_items_text_view);
        mItemCountTextView.setText(mItems.size() + " items where passed in by the parent Activity");
    }
}
