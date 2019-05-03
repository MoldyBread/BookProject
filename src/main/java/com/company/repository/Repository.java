package com.company.repository;

import com.company.entity.PunctuationMark;
import com.company.entity.Sentence;
import com.company.entity.Symbol;
import com.company.entity.Word;

import java.util.List;
import java.util.Map;

/**
 *  The {@code Repository} interface represents a
 *  repository with entities like {@code Sentence},{@code Word}
 *  {@code Symbol} and @code PunctuationMark}
 *
 *  @author Liash Danylo
 *
 */
public interface Repository {
    /**
     * Sentences getter
     *
     * @return Sentences of this repository
     */
    List<Sentence> getSentences();


    /**
     * Adds sentence to repository
     *
     * @param sentence Sentence that is added to repository
     */
    void add(Sentence sentence);

    /**
     * Adds word to repository
     *
     * @param word Word that is added to repository
     */
    void add(Word word);

    /**
     * Adds symbol to repository
     *
     * @param symbol Symbol that is added to repository
     */
    void add(Symbol symbol);

    /**
     * Adds punctuation mark to repository
     *
     * @param punctuationMark Punctuation mark that is added to repository
     */
    void add(PunctuationMark punctuationMark);

    /**
     * Removes substring from sentences
     * from startSymbols to endSymbols.
     *
     * @param startSymbols Symbols from which substring sentence is removed
     * @param endSymbols Last symbols to which substring sentence is removed
     * @return Map of sentence numbers as keys
     *         and changes in this sentences as values
     */
    Map<Integer, String> removeFromSentences(String startSymbols, String endSymbols);

    /**
     *
     * @return Statistics of current repository
     */
    String stats();
}
