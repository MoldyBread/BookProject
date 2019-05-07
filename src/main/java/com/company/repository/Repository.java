package com.company.repository;

import com.company.entity.Sentence;

import java.util.List;
import java.util.Map;

public interface Repository {
    List<Sentence> getSentences();

    void add(Sentence sentence);

    Map<Integer, String> removeFromSentences(String startSymbols, String endSymbols);

    String stats();
}
