package com.lamdbui.resulttest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM_LIST =
            "com.lamdbui.resulttest.extra_item_list";

    private TextView mItemCountTextView;
    private Button mFinishButton;

    public static Intent newIntent(Context packageContext, ArrayList<String> items) {
        Intent intent = new Intent(packageContext, ItemListActivity.class);
        intent.putStringArrayListExtra(EXTRA_ITEM_LIST, items);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        mItemCountTextView = (TextView) findViewById(R.id.num_of_passed_in_items_text_view);
        mItemCountTextView.setText(ItemManager.get(getApplicationContext()).getItems().size() + " " +
                getString(R.string.num_of_items_passed_in));

        mFinishButton = (Button) findViewById(R.id.finish_button);
        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemManager.get(getApplicationContext()).addItem("lol");
                ItemManager.get(getApplicationContext()).addItem("wut");
                finish();
            }
        });
    }
}
