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

public class TextParser implements Parser {
    private Repository textRepository;
    private StringBuilder text;

    public TextParser(String fileName) throws IOException {
        text = new StringBuilder();
        readFile(fileName);
        this.textRepository = new TextRepository(text.toString());
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

    private void fillRepository() {
        textProcessing();
        String token;
        StringBuilder sentence = new StringBuilder();
        StringTokenizer st = new StringTokenizer(text.toString(), " ");
        while (st.hasMoreTokens()) {
            token=st.nextToken();
            sentenceProcessing(token, sentence);
            textRepository.add(new Word(normalizeToken(token)));
            charsProcessing(token);
        }
        System.out.println(textRepository);
    }


    private void textProcessing(){
        String s=text.toString();
        char TABULATION = 9;
        while(s.contains("  ")||s.contains(Character.toString(TABULATION))){
            s=s.replace(Character.toString(TABULATION)," ");
            s=s.replace("  "," ");
        }
        text=new StringBuilder(s);
    }

    private void sentenceProcessing(String token, StringBuilder sentence) {
        if (isTokenMakesSentence(token)) {
            sentence.append(token);
            textRepository.add(new Sentence(sentence.toString()));
            sentence.delete(0, sentence.length());
        } else {
            sentence.append(token).append(" ");
        }
    }

    private boolean isTokenMakesSentence(String token) {
        return token.charAt(token.length() - 1) == '.'
                || token.charAt(token.length() - 1) == '!'
                || token.charAt(token.length() - 1) == '?';
    }

    private String normalizeToken(String token) {
        return token.replaceAll("[?!-+.^:,]", "");
    }

    private void charsProcessing(String token) {
        for (int i = 0; i < token.length(); i++) {
            if (token.charAt(i) == 21 || token.charAt(i) == 44
                    || token.charAt(i) == 46 || token.charAt(i) == 63) {
                textRepository.add(new PunctuationMark(token.charAt(i)));
            } else {
                textRepository.add(new Symbol(token.charAt(i)));
            }
        }
    }

    @Override
    public TextRepository getRepository() {
        return null;
    }
}
