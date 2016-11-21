package com.duongnx.materialicons.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

    public static String saveBitmapToFile(Bitmap bm, String path, String name) {
        String realPath = Environment.getExternalStorageDirectory() + path;
        // create folder if not exist
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        // save file
        realPath += "/" + name + ".png";

        FileOutputStream out = null;
        try {
            File f = new File(realPath);
            out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.PNG, 100, out);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return realPath;
    }


}
