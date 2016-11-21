package com.duongnx.materialicons.utils;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;

/**
 * Created by duongnx on 11/21/16.
 */

public class CaptureScreen extends AsyncTask<View, Void, Bitmap> {

    public interface OnCaptureScreenListener {
        void onCaptureScreen(Bitmap bitmap);
    }

    private OnCaptureScreenListener listener = null;

    public CaptureScreen(OnCaptureScreenListener listener) {
        super();
        this.listener = listener;
    }

    @Override
    protected Bitmap doInBackground(View... views) {
        if (views.length > 0)
            return BitmapUtils.getBitmapFromView(views[0]);
        else return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (listener != null) {
            listener.onCaptureScreen(bitmap);
        }
    }
}
