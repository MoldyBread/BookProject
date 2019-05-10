package com.company.service.implementation;

import com.company.text.textDecomposition;
import com.company.service.TextService;
import javafx.util.Pair;

import java.util.Map;

public class MyTextService implements TextService {
    private textDecomposition textTextDecomposition;

    public MyTextService(textDecomposition textTextDecomposition) {
        this.textTextDecomposition = textTextDecomposition;
    }

    @Override
    public Pair<Integer, Integer> getStatistics() {
        return textTextDecomposition.stats();
    }

    @Override
    public String removeFromSentences(String startSymbols, String endSymbols) {
        StringBuilder result = new StringBuilder();
        Map<Integer, String> changes = textTextDecomposition.removeFromSentences(startSymbols, endSymbols);
        for (Map.Entry<Integer, String> entry : changes.entrySet()) {
            result.append("In sentence \"");
            result.append(textTextDecomposition.getSentences().get(entry.getKey()));
            result.append("\" removed this substring:\n")
                    .append(entry.getValue()).append("\n");
        }
        return result.toString();
    }

}
