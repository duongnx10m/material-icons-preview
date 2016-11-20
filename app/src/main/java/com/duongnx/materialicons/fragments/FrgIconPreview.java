package com.duongnx.materialicons.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duongnx.materialicons.GApplication;
import com.duongnx.materialicons.R;
import com.duongnx.materialicons.adapter.AdapterIconPreview;
import com.duongnx.materialicons.models.ItemIcon;

import java.util.ArrayList;

/**
 * Created by duongnx on 11/18/16.
 */

public class FrgIconPreview extends FrgBase {
    private RecyclerView recyclerView;
    private AdapterIconPreview mAdapter;
    private ArrayList<ItemIcon> itemIcons;


    public void setItemIcons(ArrayList<ItemIcon> itemIcons) {
        this.itemIcons = itemIcons;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.frg_icon_preview, container, false);
        recyclerView = (RecyclerView) mRootView.findViewById(R.id.recyclerView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mAdapter == null && itemIcons != null) {
            mAdapter = new AdapterIconPreview(mActivity, itemIcons);
        }
        recyclerView.setAdapter(mAdapter);
    }

    public void notifyChanged() {
        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }
}
