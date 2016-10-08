package com.lamdbui.resulttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by lamdb_000 on 10/6/2016.
 */

public class ItemListFragment extends Fragment {

    public static final String EXTRA_FRAGMENT_ITEM_LIST =
            "com.lamdbui.resulttest.extra_fragment_item_list";

    private static final String ARGS_ITEM_LIST = "item_list";

    private TextView mItemCountTextView;
    private Button mFinishButton;

    public static ItemListFragment newFragment(ArrayList<String> items) {
        Bundle args = new Bundle();
        args.putStringArrayList(ARGS_ITEM_LIST, items);
        ItemListFragment fragment = new ItemListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_item_list, container, false);

        mItemCountTextView = (TextView) view.findViewById(R.id.num_of_passed_in_items_text_view);
        mItemCountTextView.setText(ItemManager.get(getContext()).getItems().size() + " " +
                getString(R.string.num_of_items_passed_in));

        mFinishButton = (Button) view.findViewById(R.id.finish_button);
        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemManager.get(getContext()).addItem("cheezburger");
                getActivity().finish();
            }
        });

        return view;
    }
}
