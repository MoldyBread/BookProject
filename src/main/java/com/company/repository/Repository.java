package com.company.repository;

import com.company.entity.PunctuationMark;
import com.company.entity.Sentence;
import com.company.entity.Symbol;
import com.company.entity.Word;

public interface Repository {
    void add(Sentence sentence);

    void add(Word word);

    void add(Symbol symbol);

    void add(PunctuationMark punctuationMark);
}
