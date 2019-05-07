package com.company.repository.implementation;

import com.company.entity.Sentence;
import com.company.repository.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextRepository implements Repository {
    private List<Sentence> sentences;

    public TextRepository() {
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
            String res = sentences.get(i).removeSubstring(startSymbols, endSymbols);
            if (res != null) {
                result.put(i, res);
            }
        }
        return result;
    }

    @Override
    public String stats() {
        return "(This statistics shows count of unique entities)\n"
                + "Sentences: " + sentences.size();
    }

}
