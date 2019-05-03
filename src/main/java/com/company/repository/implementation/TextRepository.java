package com.company.repository.implementation;

import com.company.entity.PunctuationMark;
import com.company.entity.Sentence;
import com.company.entity.Symbol;
import com.company.entity.Word;
import com.company.repository.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  The {@code TextRepository} class represents an
 *  implementation of {@code Repository}
 *
 *  @author Liash Danylo
 *
 */
public class TextRepository implements Repository {
    private List<Sentence> sentences;
    private List<Word> words;
    private List<Symbol> symbols;
    private List<PunctuationMark> punctuationMarks;

    /**
     * Intitalizes empty repository
     */
    public TextRepository() {
        this.sentences = new ArrayList<>();
        this.words = new ArrayList<>();
        this.symbols = new ArrayList<>();
        this.punctuationMarks = new ArrayList<>();
    }

    @Override
    public List<Sentence> getSentences() {
        return sentences;
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

    @Override
    public Map<Integer, String> removeFromSentences(String startSymbols, String endSymbols) {
        Map<Integer, String> result = new HashMap<>();
        for (int i = 0; i < sentences.size(); i++) {
            substringRemove(i, startSymbols, endSymbols, result);
        }
        return result;
    }

    /**
     * Removes substring from sentence
     *
     * @param index Index of sentence from substring is removed
     * @param startSymbols Symbols from which substring sentence is removed
     * @param endSymbols Last symbols to which substring sentence is removed
     * @param changes Puts changes of this sentence to Map
     */
    private void substringRemove(int index, String startSymbols, String endSymbols, Map<Integer, String> changes) {
        String sentence = sentences.get(index).getSentence();
        int start = sentence.indexOf(startSymbols);
        int end = sentence.lastIndexOf(endSymbols);
        if (start != -1 && end != -1 && start <= end) {
            changes.put(index, sentence.substring(start, end + endSymbols.length()));
            sentences.set(index, new Sentence(sentence.substring(0, start) + sentence.substring(end + 1)));
        }
    }

    @Override
    public String stats() {
        return "(This statistics shows count of unique entities)\n"
                + "Sentences: " + sentences.size() + "\n"
                + "Words: " + words.size() + "\n"
                + "Symbols: " + symbols.size() + "\n"
                + "Punctuation marks: " + punctuationMarks.size();
    }
}
