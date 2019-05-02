package com.company.entity;

import java.util.Objects;

public class PunctuationMark {
    private char punctuationMark;

    public PunctuationMark(char punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PunctuationMark that = (PunctuationMark) o;
        return punctuationMark == that.punctuationMark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(punctuationMark);
    }
}
