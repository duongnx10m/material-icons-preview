package com.duongnx.materialicons;

import android.app.Application;
import android.support.v4.content.ContextCompat;

import com.duongnx.materialicons.models.ItemIcon;
import com.duongnx.materialicons.utils.GenerateHelper;

import java.util.ArrayList;

/**
 * Created by duongnx on 11/19/16.
 */

public class GApplication extends Application {

    static GApplication instance;
    private int colorTint = R.color.grey_600;

    private ArrayList<ItemIcon> iconActions = null;
    private ArrayList<ItemIcon> iconAlerts = null;
    private ArrayList<ItemIcon> iconAVs = null;
    private ArrayList<ItemIcon> iconCommunications = null;
    private ArrayList<ItemIcon> iconContents = null;
    private ArrayList<ItemIcon> iconsDevices = null;
    private ArrayList<ItemIcon> iconEditors = null;
    private ArrayList<ItemIcon> iconFiles = null;


    public static GApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setColorTint(ContextCompat.getColor(getApplicationContext(), R.color.grey_600));
    }

    public int getColorTint() {
        return colorTint;
    }

    public void setColorTint(int colorTint) {
        this.colorTint = colorTint;
    }

    public ArrayList<ItemIcon> getIconActions() {
        if (iconActions == null) {
            iconActions = GenerateHelper.getActionIcons();
        }
        return iconActions;
    }

    public ArrayList<ItemIcon> getIconAlerts() {
        if (iconAlerts == null) {
            iconAlerts = GenerateHelper.getAlertIcons();
        }
        return iconAlerts;
    }

    public ArrayList<ItemIcon> getIconAVs() {
        if (iconAVs == null) {
            iconAVs = GenerateHelper.getAVIcons();
        }
        return iconAVs;
    }

    public ArrayList<ItemIcon> getIconCommunications() {
        if (iconCommunications == null) {
            iconCommunications = GenerateHelper.getCommunicationIcons();
        }
        return iconCommunications;
    }


    public ArrayList<ItemIcon> getIconContents() {
        if (iconContents == null) {
            iconContents = GenerateHelper.getIconContents();
        }
        return iconContents;
    }

    public ArrayList<ItemIcon> getIconsDevices() {
        if (iconsDevices == null) {
            iconsDevices = GenerateHelper.getIconsDevices();
        }
        return iconsDevices;
    }

    public ArrayList<ItemIcon> getIconEditors() {
        if (iconEditors == null) {
            iconEditors = GenerateHelper.getIconEditors();
        }
        return iconEditors;
    }

    public ArrayList<ItemIcon> getIconFiles() {
        if (iconFiles == null) {
            iconFiles = GenerateHelper.getIconFiles();
        }
        return iconFiles;
    }
}
