package com.duongnx.materialicons.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duongnx.materialicons.ColorActivity;
import com.duongnx.materialicons.Defines;
import com.duongnx.materialicons.DetailActivity;
import com.duongnx.materialicons.GApplication;
import com.duongnx.materialicons.R;
import com.duongnx.materialicons.models.ItemIcon;

import java.util.ArrayList;

/**
 * Created by duongnx on 11/18/16.
 */

public class AdapterColors extends RecyclerView.Adapter<AdapterColors.VhColor> implements View.OnClickListener {

    private Context mContext;
    private int[] resIds;

    public AdapterColors(Context context, int[] resIds) {
        this.mContext = context;
        this.resIds = resIds;
    }

    @Override
    public VhColor onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_lv_color, parent, false);
        view.setOnClickListener(this);
        return new VhColor(view);
    }

    @Override
    public void onBindViewHolder(VhColor holder, int position) {
        holder.setContent(getItem(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return resIds.length;
    }

    public int getItem(int position) {
        if (resIds != null && position < resIds.length) {
            return resIds[position];
        } else return 0;
    }

    public class VhColor extends RecyclerView.ViewHolder {
        private View ivContent;

        public VhColor(View itemView) {
            super(itemView);
            ivContent = itemView.findViewById(R.id.ivContent);
        }

        public void setContent(int color) {
            ivContent.setBackgroundColor(color);
        }

    }

    @Override
    public void onClick(View view) {
        int position = (Integer) view.getTag();
        GApplication.getInstance().setColorTint(getItem(position));
        if (mContext instanceof AppCompatActivity) {
            AppCompatActivity activity = ((AppCompatActivity) mContext);
            activity.setResult(Activity.RESULT_OK);
            activity.finish();
        }

    }
}
