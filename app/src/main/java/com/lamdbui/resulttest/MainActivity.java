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

    private TextView mItemCountTextView;
    private Button mStartTestButton;
    private Button mStartTestFragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItemCountTextView = (TextView) findViewById(R.id.item_count_text_view);
        updateUI();

        mStartTestButton = (Button) findViewById(R.id.start_test_button);
        mStartTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });

        // use this button to try the Fragment-based Activity solution
        mStartTestFragmentButton = (Button) findViewById(R.id.start_test_fragment_button);
        mStartTestFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ItemListFragmentActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        mItemCountTextView.setText(ItemManager.get(getApplicationContext()).getItems().size() + " " + getString(R.string.num_of_items));
    }
}
