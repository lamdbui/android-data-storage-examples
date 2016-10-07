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
    public static final int REQUEST_FRAGMENT_CODE_LIST = 2;

    private TextView mItemCountTextView;
    private Button mStartTestButton;
    private Button mStartTestFragmentButton;

    private ArrayList<String> mItems;

    public MainActivity() {
        //mItems = new ArrayList<>();
        mItems = ItemManager.get().getItems();
    }

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
                // pass in the current Item list to the child Activity
                Intent intent = ItemListActivity.newIntent(MainActivity.this, mItems);
                //startActivityForResult(intent, REQUEST_CODE_LIST);
                startActivity(intent);
            }
        });

        // use this button to try the Fragment-based Activity solution
        mStartTestFragmentButton = (Button) findViewById(R.id.start_test_fragment_button);
        mStartTestFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pass in the current Item list to the Fragment-based child Activity
                Intent intent = ItemListFragmentActivity.newIntent(MainActivity.this, mItems);
                startActivityForResult(intent, REQUEST_FRAGMENT_CODE_LIST);
                //startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK)
            return;

        /*
        if(requestCode == REQUEST_CODE_LIST) {
            // get our updated list here
            mItems = data.getStringArrayListExtra(ItemListActivity.EXTRA_ITEM_LIST);
        }*/


        if(requestCode == REQUEST_FRAGMENT_CODE_LIST) {
            // get out updated list(from the fragment) here
            mItems = data.getStringArrayListExtra(ItemListFragmentActivity.EXTRA_FRAGMENT_ITEM_LIST);
        }
    }

    private void updateUI() {
        //mItemCountTextView.setText(mItems.size() + " " + getString(R.string.num_of_items));
        mItemCountTextView.setText(ItemManager.get().getItems().size() + " " + getString(R.string.num_of_items));
    }
}
