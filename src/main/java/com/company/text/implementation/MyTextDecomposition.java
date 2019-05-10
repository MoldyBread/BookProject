package com.company.text.implementation;

import com.company.entity.Sentence;
import com.company.text.textDecomposition;
import com.company.util.SentenceTools;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTextDecomposition implements textDecomposition {
    private List<Sentence> sentences;

    public MyTextDecomposition() {
        this.sentences = new ArrayList<>();
    }

    @Override
    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public void add(Sentence sentence) {
        sentences.add(sentence);
    }

    @Override
    public Map<Integer, String> removeFromSentences(String startSymbols, String endSymbols) {
        Map<Integer, String> result = new HashMap<>();
        for (int i = 0; i < sentences.size(); i++) {
            Pair<Sentence, String> res = SentenceTools.removeSubstring(sentences.get(i), startSymbols, endSymbols);
            if (res != null) {
                result.put(i, res.getValue());
                sentences.set(i, res.getKey());
            }
        }
        return result;
    }

    @Override
    public Pair<Integer, Integer> stats() {
        Pair<Integer, Integer> res;
        int count = 0;
        for (Sentence sentence : sentences) {
            count += sentence.getSentencePartCount();
        }
        return new Pair<>(sentences.size(), count);
    }

}
