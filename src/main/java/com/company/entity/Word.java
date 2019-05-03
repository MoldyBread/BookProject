package com.company.entity;

import java.util.Objects;

/**
 *  The {@code Word} class represents a
 *  word in repository
 *
 *  @author Liash Danylo
 *
 */
public class Word {
    private String word;

    /**
     * Initializes word
     *
     * @param word Word string to initialize
     */
    public Word(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
