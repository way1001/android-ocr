package com.rw.zx.androidocr.handler.opencvHandler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import com.rw.zx.androidocr.global.Constant;
import com.rw.zx.androidocr.utils.ImageUtils;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.opencv.core.CvType.CV_8U;


public class OpencvHandler {

    static {
        boolean load = OpenCVLoader.initDebug();
        if(load) {
            Log.i("CV", "Open CV Libraries loaded...");
        }
    }

    public static String handleImage(Uri uri) throws IOException {
        String imagePath = null;

        StringBuffer buffer = new StringBuffer();
        imagePath = buffer.append(Constant.DIR_ROOT).append(System.currentTimeMillis()).append(".").append("resultCrop.jpg").toString();

        Mat src = Imgcodecs.imread(uri.toString());
        //        List<Mat> rgbPlanes = new ArrayList<>();
//        Core.split(src, rgbPlanes);

        int num=0;
        int width = src.width();
        int height = src.height();
        Mat dst = new Mat(height, width, CV_8U);

        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                double[] clone = src.get(i, j).clone();
                if (clone[0]<110 && clone[1]<110 && clone[2]<110) {
                    dst.put(i, j, 0);
                } else {
                    dst.put(i, j, 255);
                }
                num++;
            }
        }

        Imgcodecs.imwrite(imagePath, dst);

        return imagePath;
    }

}
