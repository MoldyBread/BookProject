package com.company.repository.implementation;

import com.company.entity.PunctuationMark;
import com.company.entity.Sentence;
import com.company.entity.Symbol;
import com.company.entity.Word;
import com.company.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class TextRepository implements Repository {
    private String text;
    private List<Sentence> sentences;
    private List<Word> words;
    private List<Symbol> symbols;
    private List<PunctuationMark> punctuationMarks;

    public TextRepository(String text) {
        this.text = text;
        this.sentences = new ArrayList<>();
        this.words = new ArrayList<>();
        this.symbols = new ArrayList<>();
        this.punctuationMarks = new ArrayList<>();
    }

    @Override
    public void add(Sentence sentence) {
        if (!sentences.contains(sentence)) {
            sentences.add(sentence);
        }
    }

    @Override
    public void add(Word word) {
        if (!words.contains(word)) {
            words.add(word);
        }
    }

    @Override
    public void add(Symbol symbol) {
        if (!symbols.contains(symbol)) {
            symbols.add(symbol);
        }
    }

    @Override
    public void add(PunctuationMark punctuationMark) {
        if (!punctuationMarks.contains(punctuationMark)) {
            punctuationMarks.add(punctuationMark);
        }
    }
}
