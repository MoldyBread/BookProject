package com.company.entity;

import java.util.Objects;

public class PunctuationMark implements SentencePart{
    private char symbol;

    public PunctuationMark(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PunctuationMark that = (PunctuationMark) o;
        return symbol == that.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
