package com.rw.zx.androidocr.viewmodel;

import android.app.Activity;
import android.content.Intent;

import com.rw.zx.androidocr.activity.camera.CameraActivity;
import com.rw.zx.androidocr.databinding.ActivityMainBinding;
import com.rw.zx.androidocr.handler.ocrHandler.Impl.BaiduAiOcrImpl;
import com.rw.zx.androidocr.handler.ocrHandler.OcrHandlerInterface;
import com.rw.zx.androidocr.model.OcrModel;

public class ImageViewModel {
    public final Activity activity;
    private final ActivityMainBinding binding;
    private final OcrModel ocrModel;

    public String ocrWord = "";


    public ImageViewModel(Activity activity, ActivityMainBinding binding) {
        this.activity = activity;
        this.binding = binding;
        ocrModel = new OcrModel(this);
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
