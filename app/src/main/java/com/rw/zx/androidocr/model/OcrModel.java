package com.rw.zx.androidocr.model;

public interface OcrModel {
    void ocr(String filePath);
    void onResult(String result);
}
