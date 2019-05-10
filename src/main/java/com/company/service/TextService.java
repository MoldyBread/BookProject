package com.company.service;

import javafx.util.Pair;

public interface TextService {
    Pair<Integer, Integer> getStatistics();

    String removeFromSentences(String startSymbols, String endSymbols);
}
