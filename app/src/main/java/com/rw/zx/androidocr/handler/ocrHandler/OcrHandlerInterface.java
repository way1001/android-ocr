package com.rw.zx.androidocr.handler.ocrHandler;

import android.graphics.Bitmap;

public interface OcrHandlerInterface {
    public void ocr(String bitmapPath);
    public void onResult(String result);
}
