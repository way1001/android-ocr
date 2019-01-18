package com.rw.zx.androidocr.model;

import com.rw.zx.androidocr.handler.ocrHandler.Impl.TesseractOcrImpl;
import com.rw.zx.androidocr.handler.ocrHandler.OcrHandler;
import com.rw.zx.androidocr.viewmodel.ImageViewModel;

public class TesseractOcrModel implements OcrModel{

    private ImageViewModel imageViewModel;

    private OcrHandler ocrHandler;

    public TesseractOcrModel(ImageViewModel imageViewModel) {
        this.imageViewModel = imageViewModel;
        ocrHandler = new TesseractOcrImpl(imageViewModel.activity, this);
    }

    public void ocr(String filePath) {
        ocrHandler.ocr(filePath);
    }

    public void onResult(String result) {

        imageViewModel.setResultString(result);
    }
}
