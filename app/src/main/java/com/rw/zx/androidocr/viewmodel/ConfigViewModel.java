package com.rw.zx.androidocr.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import com.rw.zx.androidocr.databinding.ActivityConfigBinding;
import com.rw.zx.androidocr.global.Constant;

public class ConfigViewModel {

    public final Activity activity;
    private final ActivityConfigBinding binding;

    private SharedPreferences shareData;
    public boolean isLocalOcr;
    public boolean isImageHandle;

    public ConfigViewModel(Activity activity, ActivityConfigBinding binding) {
        this.activity = activity;
        this.binding = binding;

        shareData = activity.getSharedPreferences("Config", 0);
        isLocalOcr = shareData.getBoolean(Constant.CONFIG_ISLOCALOCR, false);
        isImageHandle = shareData.getBoolean(Constant.CONFIG_ISIMAGEHANDLE, false);

        binding.setConfigViewModel(this);

    }

    public void onBack() {
        SharedPreferences.Editor editor = shareData.edit();
        editor.putBoolean(Constant.CONFIG_ISLOCALOCR, isLocalOcr);
        editor.putBoolean(Constant.CONFIG_ISIMAGEHANDLE, isImageHandle);
        editor.commit();

        Intent intent = new Intent();
        intent.putExtra(Constant.CONFIG_ISLOCALOCR, isLocalOcr);
        intent.putExtra(Constant.CONFIG_ISIMAGEHANDLE, isImageHandle);
        activity.setResult(Constant.CONFIG_BACK, intent);
        activity.finish();
    }
}
