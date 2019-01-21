package com.rw.zx.androidocr.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.rw.zx.androidocr.R;
import com.rw.zx.androidocr.databinding.ActivityConfigBinding;
import com.rw.zx.androidocr.viewmodel.ConfigViewModel;

public class ConfigActivity extends Activity {

    private ActivityConfigBinding binding;
    private ConfigViewModel configViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_config);
        configViewModel = new ConfigViewModel(this, binding);
        binding.setConfigViewModel(configViewModel);
    }

    /**
     * 跳转到设置界面
     *
     * @param activity
     */
    public static void toConfigActivity(Activity activity) {
        Intent intent = new Intent(activity, ConfigActivity.class);
        activity.startActivityForResult(intent, 1);
    }
}
