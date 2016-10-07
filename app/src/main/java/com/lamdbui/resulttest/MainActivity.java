package com.lamdbui.resulttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
}
