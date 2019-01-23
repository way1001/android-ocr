package com.rw.zx.androidocr.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rw.zx.androidocr.bean.OcrResult;
import com.rw.zx.androidocr.bean.WordResult;
import com.rw.zx.androidocr.handler.ocrHandler.Impl.BaiduAiOcrImpl;
import com.rw.zx.androidocr.handler.ocrHandler.OcrHandler;
import com.rw.zx.androidocr.viewmodel.ImageViewModel;

import java.io.IOException;

public class BaiduOcrModel implements OcrModel{

    private ImageViewModel imageViewModel;

    private OcrHandler ocrHandler;

    private static final ObjectMapper objectMapper = new ObjectMapper();


    public BaiduOcrModel(ImageViewModel imageViewModel) {
        this.imageViewModel = imageViewModel;
        ocrHandler = new BaiduAiOcrImpl(imageViewModel.activity, this);

    }

    public void ocr(String filePath) {
        ocrHandler.ocr(filePath);
    }

    public void onResult(String result) {
        try {
            OcrResult ocrResult = objectMapper.readValue(result, OcrResult.class);
            StringBuilder word = new StringBuilder();
            if (ocrResult.words_result_num > 0) {
                for (WordResult wordResult: ocrResult.words_result) {
                    word.append(wordResult.getWords());
                }
            } else {
                word.append("no result");
            }
            imageViewModel.setResultString(word.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
