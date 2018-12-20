package com.rw.zx.androidocr.global;


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
}
