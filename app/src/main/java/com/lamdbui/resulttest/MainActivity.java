package com.lamdbui.resulttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView mItemCountTextView;
    Button mStartTestButton;

    ArrayList<String> mItems;

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
                startActivity(intent);
            }
        });
    }
}
