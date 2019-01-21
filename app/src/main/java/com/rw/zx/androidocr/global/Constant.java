package com.rw.zx.androidocr.global;


import android.os.Environment;

import com.rw.zx.androidocr.utils.FileUtils;

import java.io.File;

/**
 * Author       wildma
 * Github       https://github.com/wildma
 * Date         2018/6/10
 * Desc	        ${常量}
 */
public class Constant {
    public static final String APP_NAME = "ocr";//app名称
    public static final String BASE_DIR = APP_NAME + File.separator;//WildmaIDCardCamera/
    public static final String DIR_ROOT = FileUtils.getRootPath() + File.separator + Constant.BASE_DIR;//文件夹根目录 /storage/emulated/0/WildmaIDCardCamera/
    public final static int REQUEST_CODE = 0x11;//请求码
    public final static int RESULT_CODE = 0x12;//结果码
    public final static int PERMISSION_CODE_FIRST = 0x13;//权限请求码
    public final static String IMAGE_PATH = "image_path";//图片路径标记
    public final static String BAIDU_API_KEY = "aQonmdNlGRkMymMhYSKUOoaA";
    public final static String BAIDU_SECRET_KEY = "6LwuOQh4EzLgdSGHlf5qU8EZHHtSSDg9 ";

    public final static int OCR_TYPE_BAIDU = 1;
    public final static int OCR_TYPE_TESSERACT = 2;

    public final static String TesseractDataPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tessdata/";

}
