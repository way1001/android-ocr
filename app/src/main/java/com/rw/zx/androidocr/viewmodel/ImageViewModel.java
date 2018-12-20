package com.rw.zx.androidocr.viewmodel;

import android.app.Activity;
import android.content.Intent;

import com.rw.zx.androidocr.activity.camera.CameraActivity;
import com.rw.zx.androidocr.databinding.ActivityMainBinding;

public class ImageViewModel {
    private final Activity activity;
    private final ActivityMainBinding binding;


    public ImageViewModel(Activity activity, ActivityMainBinding binding) {
        this.activity = activity;
        this.binding = binding;
    }

    public void onClick() {
        CameraActivity.toCameraActivity(activity);
    }
}
