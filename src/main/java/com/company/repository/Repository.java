package com.company.repository;

import com.company.entity.PunctuationMark;
import com.company.entity.Sentence;
import com.company.entity.Symbol;
import com.company.entity.Word;

import java.util.List;
import java.util.Map;

public interface Repository {
    List<Sentence> getSentences();

    void add(Sentence sentence);

    void add(Word word);

    void add(Symbol symbol);

    void add(PunctuationMark punctuationMark);

    Map<Integer, String> removeFromSentences(String startSymbols, String endSymbols);

    String stats();
}
