package com.company.entity;

import com.company.utils.Utils;

public class PunctuationMark {
    private char punctuationMark;

    public PunctuationMark(char punctuationMark) {
        Utils.punctuationMarkValidation(punctuationMark);
        this.punctuationMark = punctuationMark;
    }

    public char getPunctuationMark() {
        return punctuationMark;
    }
}
