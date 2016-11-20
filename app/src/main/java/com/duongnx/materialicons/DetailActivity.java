package com.duongnx.materialicons;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.duongnx.materialicons.models.ItemIcon;

/**
 * Created by duongnx on 11/19/16.
 */

public class DetailActivity extends AppCompatActivity {
    private AppCompatImageView ivContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ivContent = (AppCompatImageView) findViewById(R.id.ivContent);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ItemIcon itemIcon = (ItemIcon) bundle.getSerializable(Defines.KEY_DATA);
            ivContent.setImageResource(itemIcon.getResId());
            ivContent.setColorFilter(GApplication.getInstance().getColorTint());
            setTitle(itemIcon.getName());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
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
