package com.rw.zx.androidocr;

import android.net.Uri;
import android.os.Environment;
import android.view.View;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.model.CropOptions;

import java.io.File;

public class CustomHelper {

    public CustomHelper() {
        init();
    }

    private void init() {
    }

    public void onClick(View view, TakePhoto takePhoto) {
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Uri imageUri = Uri.fromFile(file);

        configTakePhotoOption(takePhoto);

    }

    private void configTakePhotoOption(TakePhoto takePhoto) {
//        TakePhotoOptions.Builder builder = new TakePhotoOptions.Builder();
//        if (rgPickTool.getCheckedRadioButtonId() == R.id.rbPickWithOwn) {
//            builder.setWithOwnGallery(true);
//        }
//        if (rgCorrectTool.getCheckedRadioButtonId() == R.id.rbCorrectYes) {
//            builder.setCorrectImage(true);
//        }
//        takePhoto.setTakePhotoOptions(builder.create());

    }

    private CropOptions getCropOptions() {
//        if (rgCrop.getCheckedRadioButtonId() != R.id.rbCropYes) {
//            return null;
//        }
//        int height = Integer.parseInt(etCropHeight.getText().toString());
//        int width = Integer.parseInt(etCropWidth.getText().toString());
//        boolean withWonCrop = rgCropTool.getCheckedRadioButtonId() == R.id.rbCropOwn ? true : false;
//
//        CropOptions.Builder builder = new CropOptions.Builder();
//
//        if (rgCropSize.getCheckedRadioButtonId() == R.id.rbAspect) {
//            builder.setAspectX(width).setAspectY(height);
//        } else {
//            builder.setOutputX(width).setOutputY(height);
//        }
//        builder.setWithOwnCrop(withWonCrop);
//        return builder.create();
        return null;
    }


}
