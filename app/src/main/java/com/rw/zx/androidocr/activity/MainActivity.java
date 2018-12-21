package com.rw.zx.androidocr.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rw.zx.androidocr.R;
import com.rw.zx.androidocr.databinding.ActivityMainBinding;
import com.rw.zx.androidocr.global.Constant;
import com.rw.zx.androidocr.viewmodel.ImageViewModel;

import java.io.File;

public class MainActivity extends AppCompatActivity  {

    private ActivityMainBinding binding;
    private ImageViewModel imageViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        imageViewModel = new ImageViewModel(this, binding);
        binding.setImageViewModel(imageViewModel);
        init();
    }

    protected void init() {
        TextView setting = (TextView)findViewById(R.id.setting);
        Typeface font = Typeface.createFromAsset(getAssets(), "font/fa-solid-900.ttf");
        setting.setTypeface(font);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            StringBuffer buffer = new StringBuffer();
            String imagePath = data.getStringExtra(Constant.IMAGE_PATH);
            setImageData(imagePath);
            imageViewModel.ocr(imagePath);
        }
    }

    public void setImageData(String imagePath) {
        ImageView imageView = this.findViewById(R.id.image);
        Glide.with(this).load(new File(imagePath)).into(imageView);
    }
}
