package com.company.service;

/**
 *  The {@code TextService} interface represents a
 *  service to work woth text repositories
 *
 *  @author Liash Danylo
 *
 */

public interface TextService {
    /**
     *
     * @return Statistics of current repository
     */
    String getStatistics();

    /**
     * Removes substring from sentence from
     * startSymbols to endSymbols
     *
     * @param startSymbols Symbols from which substring sentence is removed
     * @param endSymbols Last symbols to which substring sentence is removed
     * @return Text to inform about removings
     */
    String removeFromSentences(String startSymbols, String endSymbols);
}
