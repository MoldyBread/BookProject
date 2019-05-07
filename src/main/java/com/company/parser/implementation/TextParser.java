package com.company.parser.implementation;

import com.company.entity.Sentence;
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


public class TextParser implements Parser {
    private Repository textRepository;
    private StringBuilder text;

    public TextParser(String fileName) throws IOException {
        text = new StringBuilder();
        readFile(fileName);
        this.textRepository = new TextRepository();
        textProcessing();
        fillRepository();
    }

    private void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), StandardCharsets.UTF_8));
        String line;

        while ((line = reader.readLine()) != null) {
            text.append(line).append(" ");
        }
    }

    private void textProcessing() {
        String s = text.toString();
        final char TABULATION = 9;
        while (s.contains("  ") || s.contains(Character.toString(TABULATION))) {
            s = s.replace(Character.toString(TABULATION), " ");
            s = s.replace("  ", " ");
        }
        text = new StringBuilder(s);
    }

    private void fillRepository() {
        String token;
        Sentence currentSentence = new Sentence();
        StringTokenizer st = new StringTokenizer(text.toString(), " ");
        while (st.hasMoreTokens()) {
            token = st.nextToken();
            if (sentenceProcessing(token, currentSentence)) {
                currentSentence = new Sentence();
            }
        }
    }

    private boolean sentenceProcessing(String token, Sentence sentence) {
        if (isTokenMakesSentence(token)) {
            sentence.add(new Word(token));
            textRepository.add(sentence);
            return true;
        }
        sentence.add(new Word(token));
        return false;
    }

    private boolean isTokenMakesSentence(String token) {
        return token.charAt(token.length() - 1) == '.'
                || token.charAt(token.length() - 1) == '!'
                || token.charAt(token.length() - 1) == '?';
    }


    @Override
    public Repository getRepository() {
        return textRepository;
    }
}
