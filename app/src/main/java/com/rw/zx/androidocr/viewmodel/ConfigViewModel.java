package com.rw.zx.androidocr.viewmodel;

import android.app.Activity;

import com.rw.zx.androidocr.databinding.ActivityConfigBinding;

public class ConfigViewModel {

    public final Activity activity;
    private final ActivityConfigBinding binding;

    public ConfigViewModel(Activity activity, ActivityConfigBinding binding) {
        this.activity = activity;
        this.binding = binding;
    }
}
