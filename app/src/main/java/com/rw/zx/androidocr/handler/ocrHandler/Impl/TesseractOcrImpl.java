package com.rw.zx.androidocr.handler.ocrHandler.Impl;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

import com.googlecode.tesseract.android.TessBaseAPI;
import com.rw.zx.androidocr.bean.OcrResult;
import com.rw.zx.androidocr.global.Constant;
import com.rw.zx.androidocr.handler.ocrHandler.OcrHandler;
import com.rw.zx.androidocr.model.TesseractOcrModel;

import java.io.File;
public class TesseractOcrImpl implements OcrHandler {

    private TessBaseAPI mTess;
    Context context;
    TesseractOcrModel tesseractOcrModel;
    public TesseractOcrImpl(Context context, TesseractOcrModel tesseractOcrModel) {
        this.context = context;
        this.tesseractOcrModel = tesseractOcrModel;
        init();
    }

    public void init() {
        String lang = "eng";//中文简体+英文
        mTess = new TessBaseAPI();
        mTess.init(Environment.getExternalStorageDirectory().getAbsolutePath(), lang);//mFilePath不知道？
    }

    @Override
    public void ocr(String bitmapPath) {
        String OCRresult = null;
        File bitmapFile = new File(bitmapPath);
        mTess.setImage(bitmapFile);
        OCRresult = mTess.getUTF8Text();
        this.onResult(OCRresult);
    }

    @Override
    public void onResult(String result) {
        tesseractOcrModel.onResult(result);
    }
}
