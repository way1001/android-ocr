package com.rw.zx.androidocr.viewmodel;

import android.app.Activity;
import android.content.SharedPreferences;

import com.rw.zx.androidocr.activity.ConfigActivity;
import com.rw.zx.androidocr.activity.camera.CameraActivity;
import com.rw.zx.androidocr.databinding.ActivityMainBinding;
import com.rw.zx.androidocr.global.Constant;
import com.rw.zx.androidocr.model.BaiduOcrModel;
import com.rw.zx.androidocr.model.OcrModel;
import com.rw.zx.androidocr.model.TesseractOcrModel;

public class ImageViewModel {
    public final Activity activity;
    private final ActivityMainBinding binding;
    private OcrModel ocrModel;
    private boolean isImageHandle;

    private SharedPreferences shareData;

    public String ocrWord = "";


    public ImageViewModel(Activity activity, ActivityMainBinding binding) {
        this.activity = activity;
        this.binding = binding;

        getConfig();
    }

    public void onClick() {
        CameraActivity.toCameraActivity(activity);
    }

    public void onConfig() {
        ConfigActivity.toConfigActivity(activity);
    }

    public void ocr(String filePath) {
        ocrModel.ocr(filePath);
    }

    public void setResultString(String string) {
        ocrWord = string;
        binding.setImageViewModel(this);
    }

    public void getConfig() {
        shareData = activity.getSharedPreferences("Config", Activity.MODE_PRIVATE);
        boolean isLocalOcr = shareData.getBoolean(Constant.CONFIG_ISLOCALOCR, false);
        isImageHandle = shareData.getBoolean(Constant.CONFIG_ISIMAGEHANDLE, false);

        if (isLocalOcr) ocrModel = new TesseractOcrModel(this);
        else ocrModel = new BaiduOcrModel(this);
    }

    public boolean getIsImageHandle() {
        return isImageHandle;
    }
}
