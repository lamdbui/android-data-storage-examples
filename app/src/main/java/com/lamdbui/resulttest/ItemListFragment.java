package com.lamdbui.resulttest;

import android.app.Activity;
import android.content.Context;
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

    private OnItemListListener mCallback;

    private ArrayList<String> mItems;

    public interface OnItemListListener {
        public void onItemListFinish(ArrayList<String> finalItems);
    }

    public static ItemListFragment newFragment(ArrayList<String> items) {
        Bundle args = new Bundle();
        args.putStringArrayList(ARGS_ITEM_LIST, items);
        ItemListFragment fragment = new ItemListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnItemListListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    " must implement OnItemListListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateVi   ew(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.activity_item_list, container, false);

        mItems = getArguments().getStringArrayList(ARGS_ITEM_LIST);

        mItemCountTextView = (TextView) view.findViewById(R.id.num_of_passed_in_items_text_view);
        mItemCountTextView.setText(mItems.size() + " items were passed in to this Fragment");

        mFinishButton = (Button) view.findViewById(R.id.finish_button);
        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                mItems.add("cheezburger");
                data.putStringArrayListExtra(EXTRA_FRAGMENT_ITEM_LIST, mItems);
                getActivity().setResult(Activity.RESULT_OK, data);
                //mCallback.onItemListFinish(mItems);
                getActivity().finish();
                //getActivity().setResult();
            }
        });

        return view;
    }

    public ArrayList<String> getItems() {
        return mItems;
    }
}
