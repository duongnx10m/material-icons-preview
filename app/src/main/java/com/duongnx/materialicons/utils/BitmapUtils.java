package com.duongnx.materialicons.utils;

import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.drawable.PictureDrawable;
import android.view.View;

public class BitmapUtils {

	public static Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
		int width = bm.getWidth();
		int height = bm.getHeight();
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// CREATE A MATRIX FOR THE MANIPULATION
		Matrix matrix = new Matrix();
		// RESIZE THE BIT MAP
		matrix.postScale(scaleWidth, scaleHeight);

		// "RECREATE" THE NEW BITMAP
		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
				matrix, false);
		return resizedBitmap;
	}

	public static Bitmap getBitmapFromAssets(Context context, String fileName) {
		AssetManager assetManager = context.getAssets();
		try {
			InputStream istr = assetManager.open(fileName);
			Bitmap bitmap = BitmapFactory.decodeStream(istr);
			return bitmap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Bitmap convertPictureToBitmap(Picture picture) {
		PictureDrawable pd = new PictureDrawable(picture);
		Bitmap bitmap = Bitmap.createBitmap(pd.getIntrinsicWidth(),
				pd.getIntrinsicHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		canvas.drawPicture(pd.getPicture());
		return bitmap;
	}

	public static Bitmap getBitmapFromView(View v) {
		Bitmap b = Bitmap.createBitmap(v.getWidth(), v.getHeight(),
				Config.ARGB_8888);
		Canvas c = new Canvas(b);
		v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
		v.draw(c);
		return b;
	}

	public static Bitmap mergeBitmaps(Bitmap c, Bitmap s) {
		Bitmap cs = null;
		int width, height = 0;
		if (c.getWidth() > s.getWidth()) {
			width = c.getWidth() + s.getWidth();
			height = c.getHeight();
		} else {
			width = s.getWidth() + s.getWidth();
			height = c.getHeight();
		}
		cs = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		Canvas comboImage = new Canvas(cs);
		comboImage.drawBitmap(c, 0f, 0f, null);
		comboImage.drawBitmap(s, c.getWidth(), 0f, null);
		return cs;
	}

	public static Bitmap mergeBitmaps(Bitmap[] bms) {
		if (bms != null && bms.length > 0) {
			Bitmap bmOverlay = Bitmap.createBitmap(bms[0].getWidth(),
					bms[0].getHeight(), bms[0].getConfig());
			Canvas canvas = new Canvas(bmOverlay);
			for (int i = 0; i < bms.length; i++) {
				if (i == 0) {
					canvas.drawBitmap(bms[i], new Matrix(), null);
				} else {
					canvas.drawBitmap(bms[i], 0, 0, null);
				}
			}
			return bmOverlay;
		}
		return null;
	}

}
