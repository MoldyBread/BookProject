package com.company.service;

public interface TextService {
    String getStatistics();

    void removeFromSentences(String startSymbols, String endSymbols);
}
