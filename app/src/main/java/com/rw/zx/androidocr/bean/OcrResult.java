package com.rw.zx.androidocr.bean;

import java.util.List;

//{'log_id': 8138749016161590229, 'direction': 0, 'words_result_num': 1, 'words_result': [{'probability': {'variance': 0.020681, 'average': 0.91281, 'min': 0.455359}, 'words': '201811316136'}]}
public class OcrResult {
    public long log_id;
    public int direction;
    public int words_result_num;
    public List<WordResult> words_result;

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(int words_result_num) {
        this.words_result_num = words_result_num;
    }

    public List<WordResult> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<WordResult> words_result) {
        this.words_result = words_result;
    }
}
