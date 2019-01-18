package com.rw.zx.androidocr.viewmodel;

import android.app.Activity;

import com.rw.zx.androidocr.activity.camera.CameraActivity;
import com.rw.zx.androidocr.databinding.ActivityMainBinding;
import com.rw.zx.androidocr.model.BaiduOcrModel;
import com.rw.zx.androidocr.model.OcrModel;
import com.rw.zx.androidocr.model.TesseractOcrModel;

public class ImageViewModel {
    public final Activity activity;
    private final ActivityMainBinding binding;
    //private final BaiduOcrModel baiduOcrModel;
    //private final TesseractOcrModel tesseractOcrModel;
    private OcrModel ocrModel;

    public String ocrWord = "";


    public ImageViewModel(Activity activity, ActivityMainBinding binding) {
        this.activity = activity;
        this.binding = binding;
        //baiduOcrModel = new BaiduOcrModel(this);
        ocrModel = new TesseractOcrModel(this);
    }

    public void onClick() {
        CameraActivity.toCameraActivity(activity);
    }

    public void ocr(String filePath) {
        ocrModel.ocr(filePath);
    }

    public void setResultString(String string) {
        ocrWord = string;
        binding.setImageViewModel(this);
    }
}
