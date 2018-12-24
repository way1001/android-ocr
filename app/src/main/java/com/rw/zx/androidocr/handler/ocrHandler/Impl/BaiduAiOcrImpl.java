package com.rw.zx.androidocr.handler.ocrHandler.Impl;

import android.content.Context;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.baidu.ocr.sdk.model.GeneralBasicParams;
import com.baidu.ocr.sdk.model.GeneralResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rw.zx.androidocr.handler.ocrHandler.OcrHandler;
import com.rw.zx.androidocr.model.OcrModel;

import java.io.File;


public class BaiduAiOcrImpl implements OcrHandler {

    Context context;
    OcrModel ocrModel;
    static final ObjectMapper objectMapper = new ObjectMapper();

    public BaiduAiOcrImpl(Context context, OcrModel ocrModel) {

        this.context = context;
        this.ocrModel = ocrModel;
        OCR.getInstance(context).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken result) {
                // 调用成功，返回AccessToken对象
                String token = result.getAccessToken();
            }
            @Override
            public void onError(OCRError error) {
                // 调用失败，返回OCRError子类SDKError对象
            }
        }, context.getApplicationContext(), "OioWvL68cQjBWRmfanYDXk2F", "pc3bhgdBcmu9sO6W2ssk6yERLeVr3wEd");
    }

    @Override
    public void ocr(String bitmapPath) {
        GeneralBasicParams param = new GeneralBasicParams();
        param.setDetectDirection(false);
        param.setLanguageType(GeneralBasicParams.ENGLISH);
        param.setImageFile(new File(bitmapPath));

        String result = "识别服务调用失败";

        // 调用通用文字识别服务
        OCR.getInstance(context).recognizeGeneralBasic(param, new OnResultListener<GeneralResult>() {
            @Override
            public void onResult(GeneralResult result) {
                BaiduAiOcrImpl.this.onResult(result.getJsonRes());
            }
            @Override
            public void onError(OCRError error) {
                // 调用失败，返回OCRError对象
            }
        });
    }

    @Override
    public void onResult(String result) {
        ocrModel.onResult(result);
    }
}
