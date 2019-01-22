package com.rw.zx.androidocr.viewmodel;

import android.app.Activity;
import android.content.Intent;

import com.rw.zx.androidocr.databinding.ActivityConfigBinding;
import com.rw.zx.androidocr.global.Constant;

public class ConfigViewModel {

    public final Activity activity;
    private final ActivityConfigBinding binding;

    private boolean isLocalOcr;
    private boolean isImageHandle;

    public ConfigViewModel(Activity activity, ActivityConfigBinding binding) {
        this.activity = activity;
        this.binding = binding;

        isLocalOcr = false;
        isImageHandle = false;

    }

    public void onBack() {
        Intent intent = new Intent();
        intent.putExtra(Constant.CONFIG_ISLOCAL, true);
        intent.putExtra(Constant.CONFIG_ISOPENCV, true);
        activity.setResult(Constant.CONFIG_BACK, intent);
        activity.finish();
    }
}
