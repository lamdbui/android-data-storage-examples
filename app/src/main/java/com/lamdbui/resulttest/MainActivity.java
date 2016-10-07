package com.lamdbui.resulttest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_LIST = 1;

    private TextView mItemCountTextView;
    private Button mStartTestButton;

    private ArrayList<String> mItems;

    public MainActivity() {
        mItems = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItemCountTextView = (TextView) findViewById(R.id.item_count_text_view);
        mItemCountTextView.setText(mItems.size() + " number of items");

        mStartTestButton = (Button) findViewById(R.id.start_test_button);
        mStartTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, ItemListActivity.class);
                // pass in the current Item list to the child Activity
                Intent intent = ItemListActivity.newIntent(MainActivity.this, mItems);
                startActivityForResult(intent, REQUEST_CODE_LIST);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mItemCountTextView.setText(mItems.size() + " number of items");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != Activity.RESULT_OK)
            return;

        if(requestCode == REQUEST_CODE_LIST) {
            // get our updated list nere
            mItems = data.getStringArrayListExtra(ItemListActivity.EXTRA_ITEM_LIST);
        }
    }
}
