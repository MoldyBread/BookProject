package com.company.text;

import com.company.entity.Sentence;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public interface textDecomposition {
    List<Sentence> getSentences();

    void add(Sentence sentence);

    Map<Integer, String> removeFromSentences(String startSymbols, String endSymbols);

    Pair<Integer, Integer> stats();
}
