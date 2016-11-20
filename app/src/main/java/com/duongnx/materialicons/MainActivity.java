package com.duongnx.materialicons;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.duongnx.materialicons.fragments.FrgIconPreview;
import com.duongnx.materialicons.models.ItemIcon;
import com.duongnx.materialicons.utils.Utils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FrgIconPreview mFrgCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setTitle(R.string.actions);
        changeMenu(GApplication.getInstance().getIconActions());
    }

    public void changeMenu(ArrayList<ItemIcon> itemIcons) {
        FrgIconPreview frgIconPreview = new FrgIconPreview();
        frgIconPreview.setItemIcons(itemIcons);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, frgIconPreview);
        fragmentTransaction.commitAllowingStateLoss();
        mFrgCurrent = frgIconPreview;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_color:
                Intent intent = new Intent(this, ColorActivity.class);
                startActivityForResult(intent, Defines.REQUEST_CODE);
                break;
            case R.id.menu_rate:
                Utils.startActivityWithUrl(this, Defines.RATE);
                break;

            case R.id.menu_more:
                Utils.startActivityWithUrl(this, Defines.MORE_APPS);
                break;
        }


        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_action:
                setTitle(R.string.actions);
                changeMenu(GApplication.getInstance().getIconActions());
                break;
            case R.id.nav_alert:
                setTitle(R.string.alerts);
                changeMenu(GApplication.getInstance().getIconAlerts());
                break;
            case R.id.nav_av:
                setTitle(R.string.avs);
                changeMenu(GApplication.getInstance().getIconAVs());
                break;
            case R.id.nav_communication:
                setTitle(R.string.communications);
                changeMenu(GApplication.getInstance().getIconCommunications());
                break;
            case R.id.nav_content:
                setTitle(R.string.contents);
                changeMenu(GApplication.getInstance().getIconContents());
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == Defines.REQUEST_CODE) {
            if (mFrgCurrent != null) {
                mFrgCurrent.notifyChanged();
            }
        }
    }
}
