package com.company.entity;

import java.util.Objects;

/**
 *  The {@code PunctuationMark} class represents a
 *  Punctuation mark in repository
 *
 *  @author Liash Danylo
 *
 */
public class PunctuationMark {
    private char punctuationMark;

    /**
     * Initializes punctuation mark
     *
     * @param punctuationMark Punctuation mark char to initialize
     */
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
