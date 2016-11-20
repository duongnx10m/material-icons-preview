package com.duongnx.materialicons.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duongnx.materialicons.Defines;
import com.duongnx.materialicons.DetailActivity;
import com.duongnx.materialicons.GApplication;
import com.duongnx.materialicons.R;
import com.duongnx.materialicons.models.ItemIcon;

import java.util.ArrayList;

/**
 * Created by duongnx on 11/18/16.
 */

public class AdapterIconPreview extends RecyclerView.Adapter<AdapterIconPreview.VhIconPreview> implements View.OnClickListener {

    private Context mContext;
    private ArrayList<ItemIcon> resIds;

    public AdapterIconPreview(Context context, ArrayList<ItemIcon> resIds) {
        this.mContext = context;
        this.resIds = resIds;
    }

    @Override
    public VhIconPreview onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_lv_icon_preview, parent, false);
        view.setOnClickListener(this);
        return new VhIconPreview(view);
    }

    @Override
    public void onBindViewHolder(VhIconPreview holder, int position) {
        holder.setContent(getItem(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return resIds.size();
    }

    public ItemIcon getItem(int position) {
        if (resIds != null && position < resIds.size()) {
            return resIds.get(position);
        } else return null;
    }

    public class VhIconPreview extends RecyclerView.ViewHolder {
        private ImageView ivContent;
        private TextView tvTitle;

        public VhIconPreview(View itemView) {
            super(itemView);
            ivContent = (ImageView) itemView.findViewById(R.id.ivContent);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }

        public void setContent(ItemIcon itemIcon) {
            ivContent.setImageResource(itemIcon.getResId());
            tvTitle.setText(itemIcon.getName());
            ivContent.setColorFilter(GApplication.getInstance().getColorTint());
        }


    }

    @Override
    public void onClick(View view) {
        int position = (Integer) view.getTag();
        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra(Defines.KEY_DATA, getItem(position));
        mContext.startActivity(intent);
    }
}
