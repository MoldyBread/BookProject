package com.company.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word {
    private List<Symbol> word;

    public Word(String word) {
        this.word = new ArrayList<>();
        setSymbols(word);
    }

    private void setSymbols(String word){
        for (char c : word.toCharArray()) {
            if (c == 33 || c == 44
                    || c == 46 || c == 63
                    || c == 58) {
                this.word.add(new PunctuationMark(c));
            }else{
                this.word.add(new Symbol(c));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Symbol symbol:word) {
            res.append(symbol);
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
