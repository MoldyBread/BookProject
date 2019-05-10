package com.company.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence {
    private List<SentencePart> sentence;

    public Sentence() {
        this.sentence = new ArrayList<>();
    }

    public void add(Word word) {
        sentence.add(word);
    }

    public void add(PunctuationMark punctuationMark) {
        sentence.add(punctuationMark);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence1 = (Sentence) o;
        return Objects.equals(sentence, sentence1.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence);
    }

    public int getSentencePartCount(){
        return sentence.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sentence.size(); i++) {
            result.append(sentence.get(i)).append(i == sentence.size() - 1 ? "" : " ");
        }
        return result.toString();
    }
}
