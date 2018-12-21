package com.rw.zx.androidocr.bean;

//{'probability': {'variance': 0.020681, 'average': 0.91281, 'min': 0.455359}, 'words': '201811316136'}
public class WordResult {
    private Probability probability;
    private String words;

    public Probability getProbability() {
        return probability;
    }

    public void setProbability(Probability probability) {
        this.probability = probability;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
