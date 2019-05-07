package com.company.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Sentence {
    private List<Word> sentence;

    public Sentence() {
        this.sentence = new ArrayList<>();
    }

    public void add(Word word) {
        sentence.add(word);
    }

    public String removeSubstring(String startSymbols, String endSymbols) {
        String sentence = toString();
        this.sentence = new ArrayList<>();
        int start = sentence.indexOf(startSymbols);
        int end = sentence.lastIndexOf(endSymbols)+endSymbols.length();
        if (start != -1 && end != -1 && start <= end) {
            String res = sentence.substring(start, end);
            sentenceChange(sentence.substring(0, start) + sentence.substring(end));
            return res;
        }
        return null;
    }

    private void sentenceChange(String sentence) {
        this.sentence = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(sentence, " ");
        while (st.hasMoreTokens()) {
            add(new Word(st.nextToken()));
        }
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sentence.size(); i++) {
            result.append(sentence.get(i)).append(i == sentence.size() - 1 ? "" : " ");
        }
        return result.toString();
    }
}
