package com.company.parser.implementation;

import com.company.entity.PunctuationMark;
import com.company.entity.Sentence;
import com.company.entity.Symbol;
import com.company.entity.Word;
import com.company.parser.Parser;
import com.company.repository.Repository;
import com.company.repository.implementation.TextRepository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;


/**
 *  The {@code TextParser} class represents an
 *  implementation of {@code Repository}
 *
 *  @author Liash Danylo
 *
 */
public class TextParser implements Parser {
    private Repository textRepository;
    private StringBuilder text;

    /**
     * Reads file, creates and fills
     * text repository
     *
     * @param fileName name of file from which Text is read
     * @throws IOException
     */
    public TextParser(String fileName) throws IOException {
        text = new StringBuilder();
        readFile(fileName);
        this.textRepository = new TextRepository();
        textProcessing();
        fillRepository();
    }

    /**
     * Reads from file
     *
     * @param fileName name of file from which Text is read
     * @throws IOException
     */
    private void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), StandardCharsets.UTF_8));
        String line;

        while ((line = reader.readLine()) != null) {
            text.append(line).append(" ");
        }
    }

    /**
     * Fills repository with entities
     */
    private void fillRepository() {
        String token;
        StringBuilder sentence = new StringBuilder();
        StringTokenizer st = new StringTokenizer(text.toString(), " ");
        while (st.hasMoreTokens()) {
            token = st.nextToken();
            sentenceProcessing(token, sentence);
            textRepository.add(new Word(normalizeToken(token)));
            charsProcessing(token);
        }
    }

    /**
     * Normalizes text with double spaces and tabs
     */
    private void textProcessing() {
        String s = text.toString();
        char TABULATION = 9;
        while (s.contains("  ") || s.contains(Character.toString(TABULATION))) {
            s = s.replace(Character.toString(TABULATION), " ");
            s = s.replace("  ", " ");
        }
        text = new StringBuilder(s);
    }

    /**
     * Sentence parsing
     *
     * @param token Word that is add or close sentence
     * @param sentence Builder of sentence
     */

    private void sentenceProcessing(String token, StringBuilder sentence) {
        if (isTokenMakesSentence(token)) {
            sentence.append(token);
            textRepository.add(new Sentence(sentence.toString()));
            sentence.delete(0, sentence.length());
        } else {
            sentence.append(token).append(" ");
        }
    }

    /**
     * Checks if Token close sentence
     *
     * @param token Token to check
     * @return true if token closes sentence
     */
    private boolean isTokenMakesSentence(String token) {
        return token.charAt(token.length() - 1) == '.'
                || token.charAt(token.length() - 1) == '!'
                || token.charAt(token.length() - 1) == '?';
    }

    /**
     * Normalizes token to word
     *
     * @param token Token to normalize
     * @return normal value of word in token
     */
    private String normalizeToken(String token) {
        return token.replaceAll("[?!-+.^:,]", "");
    }


    /**
     * Chars parsing
     *
     * @param token Token in which we check all the characters
     */
    private void charsProcessing(String token) {
        for (int i = 0; i < token.length(); i++) {
            if (token.charAt(i) == 33 || token.charAt(i) == 44
                    || token.charAt(i) == 46 || token.charAt(i) == 63
                    || token.charAt(i) == 58) {
                textRepository.add(new PunctuationMark(token.charAt(i)));
            } else {
                textRepository.add(new Symbol(token.charAt(i)));
            }
        }
    }

    @Override
    public Repository getRepository() {
        return textRepository;
    }
}
