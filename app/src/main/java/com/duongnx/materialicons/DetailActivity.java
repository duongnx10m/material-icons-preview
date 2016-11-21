package com.duongnx.materialicons;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.duongnx.materialicons.models.ItemIcon;
import com.duongnx.materialicons.utils.BitmapUtils;
import com.duongnx.materialicons.utils.CaptureScreen;
import com.duongnx.materialicons.utils.FileUtils;

/**
 * Created by duongnx on 11/19/16.
 */

public class DetailActivity extends AppCompatActivity {
    private AppCompatImageView ivContent;
    private ItemIcon itemIcon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ivContent = (AppCompatImageView) findViewById(R.id.ivContent);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            itemIcon = (ItemIcon) bundle.getSerializable(Defines.KEY_DATA);
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
            case R.id.menu_download:
                int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (permission != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, Defines.PERMISSION_REQUEST_CODE);
                } else {
                    saveBitmapFromView();
                }
                break;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Defines.PERMISSION_REQUEST_CODE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            saveBitmapFromView();
        }
    }

    private void saveBitmapFromView() {
        new CaptureScreen(new CaptureScreen.OnCaptureScreenListener() {
            @Override
            public void onCaptureScreen(Bitmap bitmap) {
                if (bitmap != null && itemIcon != null) {
                    String path = FileUtils.saveBitmapToFile(bitmap, Defines.AppPath, itemIcon.getName());
                    showDialog("Saved this icon at: " + path);
                }
            }
        }).execute(ivContent);
    }


    private void showDialog(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Message").setMessage(msg).setNegativeButton("Ok", null).show();
    }
}
