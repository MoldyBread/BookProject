package com.company.service.implementation;

import com.company.repository.implementation.TextRepository;
import com.company.service.TextService;

public class MyTextService implements TextService {
    private TextRepository textRepository;

    public MyTextService(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    @Override
    public String getStatistics(){
        return textRepository.stats();
    }

    @Override
    public void removeFromSentences(String startSymbols, String endSymbols){
        textRepository.removeFromSentences(startSymbols,endSymbols);
    }
}
