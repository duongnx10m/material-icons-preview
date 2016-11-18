package com.duongnx.materialicons.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.duongnx.materialicons.MainActivity;

/**
 * Created by duongnx on 11/18/16.
 */

public class FrgBase extends Fragment {
    protected MainActivity mActivity;
    protected View mRootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) getActivity();
    }
}
