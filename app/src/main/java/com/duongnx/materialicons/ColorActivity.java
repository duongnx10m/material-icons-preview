package com.duongnx.materialicons;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.duongnx.materialicons.adapter.AdapterColors;

/**
 * Created by duongnx on 11/19/16.
 */

public class ColorActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterColors mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        setTitle("Select Icon's Color");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (mAdapter == null) {
            TypedArray typedArray = getResources().obtainTypedArray(R.array.colors);
            int[] colors = new int[typedArray.length()];
            for (int i = 0; i < typedArray.length(); i++) {
                colors[i] = typedArray.getColor(i, Color.BLACK);
            }
            typedArray.recycle();
            mAdapter = new AdapterColors(this, colors);
        }
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

}
