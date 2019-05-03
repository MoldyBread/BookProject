package com.company.service.implementation;

import com.company.repository.Repository;
import com.company.service.TextService;

import java.util.Map;


/**
 *  The {@code MyTextService} class represents an
 *  implementation of {@code TextService} to work with text repository
 *
 *  @author Liash Danylo
 *
 */
public class MyTextService implements TextService {
    private Repository textRepository;

    /**
     *  Initializes TextService
     */
    public MyTextService(Repository textRepository) {
        this.textRepository = textRepository;
    }

    @Override
    public String getStatistics() {
        return textRepository.stats();
    }

    @Override
    public String removeFromSentences(String startSymbols, String endSymbols) {
        StringBuilder result = new StringBuilder();
        Map<Integer, String> changes = textRepository.removeFromSentences(startSymbols, endSymbols);
        for (Map.Entry<Integer, String> entry : changes.entrySet()) {
            result.append("In sentence \"").append(textRepository.getSentences().get(entry.getKey())
                    .getSentence()).append("\" removed this substring:\n")
                    .append(entry.getValue()).append("\n");
        }
        return result.toString();
    }
}
