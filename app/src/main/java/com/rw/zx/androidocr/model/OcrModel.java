package com.rw.zx.androidocr.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rw.zx.androidocr.bean.OcrResult;
import com.rw.zx.androidocr.handler.ocrHandler.Impl.BaiduAiOcrImpl;
import com.rw.zx.androidocr.handler.ocrHandler.OcrHandler;
import com.rw.zx.androidocr.viewmodel.ImageViewModel;

import java.io.IOException;

public class OcrModel {

    private ImageViewModel imageViewModel;

    OcrHandler ocrHandler;

    private static final ObjectMapper objectMapper = new ObjectMapper();


    public OcrModel(ImageViewModel imageViewModel) {
        this.imageViewModel = imageViewModel;
        ocrHandler = new BaiduAiOcrImpl(imageViewModel.activity, this);

    }

    public void ocr(String filePath) {
        ocrHandler.ocr(filePath);
    }

    public void onResult(String result) {
        try {
            OcrResult ocrResult = objectMapper.readValue(result, OcrResult.class);
            String word = "";
            if (ocrResult.words_result_num > 0) {
                word = ocrResult.words_result.get(0).getWords();
            } else {
                word = "no result";
            }
            imageViewModel.setResultString(word);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
