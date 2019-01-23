package com.rw.zx.androidocr.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rw.zx.androidocr.R;
import com.rw.zx.androidocr.databinding.ActivityMainBinding;
import com.rw.zx.androidocr.global.Constant;
import com.rw.zx.androidocr.handler.ocrHandler.Impl.TesseractOcrImpl;
import com.rw.zx.androidocr.handler.opencvHandler.OpencvHandler;
import com.rw.zx.androidocr.viewmodel.ImageViewModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private ImageViewModel imageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        copyFiles();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        imageViewModel = new ImageViewModel(this, binding);
        binding.setImageViewModel(imageViewModel);
        init();
    }

    protected void init() {
        TextView setting = (TextView) findViewById(R.id.setting);
        Typeface font = Typeface.createFromAsset(getAssets(), "font/fa-solid-900.ttf");
        setting.setTypeface(font);
    }

    private void copyFiles() {
        //创建父目录
        File parentfile = new File(Constant.TesseractDataPath);
        if (!parentfile.exists()) {
            parentfile.mkdir();
        }
        //循环复制2中字库
        String datafilepath = Constant.TesseractDataPath + "/eng.traineddata";

        File dataFile = new File(datafilepath);
        if (!dataFile.exists())
            copyFile(datafilepath);
    }

    private void copyFile(String datafilepath) {
        try {
            String filepath = datafilepath;
            String[] filesegment = filepath.split(File.separator);
            String filename = filesegment[(filesegment.length - 1)];//获取chi_sim.traineddata和eng.traineddata文件名
            AssetManager assetManager = getAssets();
            InputStream instream = assetManager.open(filename);//打开chi_sim.traineddata和eng.traineddata文件
            OutputStream outstream = new FileOutputStream(filepath);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = instream.read(buffer)) != -1) {
                outstream.write(buffer, 0, read);
            }
            outstream.flush();
            outstream.close();
            instream.close();
            File file = new File(filepath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {

            switch (resultCode) {
                case Constant.RESULT_CODE:
                {
                    StringBuffer buffer = new StringBuffer();
                    String imagePath = data.getStringExtra(Constant.IMAGE_PATH);
                    if (imageViewModel.getIsImageHandle()) {
                        try {
                            imagePath = OpencvHandler.handleImage(Uri.parse(imagePath));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    setImageData(imagePath);
                    imageViewModel.ocr(imagePath);
                }
                break;
                case Constant.CONFIG_BACK:
                {
                    imageViewModel.getConfig();
                }
                break;
            }
        }
    }

    public void setImageData(String imagePath) {
        ImageView imageView = this.findViewById(R.id.image);
        Glide.with(this).load(new File(imagePath)).into(imageView);
    }
}
