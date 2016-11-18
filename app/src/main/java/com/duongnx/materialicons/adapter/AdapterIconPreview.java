package com.duongnx.materialicons.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.duongnx.materialicons.R;
import com.duongnx.materialicons.models.ItemIcon;

import java.util.ArrayList;

/**
 * Created by duongnx on 11/18/16.
 */

public class AdapterIconPreview extends RecyclerView.Adapter<AdapterIconPreview.VhIconPreview> {

    private Context mContext;
    private ArrayList<ItemIcon> resIds;

    public AdapterIconPreview(Context context, ArrayList<ItemIcon> resIds) {
        this.mContext = context;
        this.resIds = resIds;
    }

    @Override
    public VhIconPreview onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VhIconPreview(LayoutInflater.from(mContext).inflate(R.layout.item_lv_icon_preview, parent, false));
    }

    @Override
    public void onBindViewHolder(VhIconPreview holder, int position) {
        holder.setContent(getItem(position));
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

        public VhIconPreview(View itemView) {
            super(itemView);
            ivContent = (ImageView) itemView.findViewById(R.id.ivContent);
        }

        public void setContent(ItemIcon itemIcon) {
            //ivContent.setImageBitmap(itemSticker.getBitmap());
        }


    }


}
