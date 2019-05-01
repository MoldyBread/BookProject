package com.company.parser.implementation;

import com.company.parser.Parser;
import com.company.repository.Repository;
import com.company.repository.implementation.TextRepository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TextParser implements Parser {

    private Repository textRepository;
    private StringBuilder text;

    public TextParser(String fileName) throws IOException {
        this.textRepository = new TextRepository();
        text = new StringBuilder();
        readFile(fileName);
        fillRepository();
    }

    private void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), StandardCharsets.UTF_8));
        String line;

        while ((line = reader.readLine()) != null) {
            text.append(line + "\n");
        }

    }

    private void fillRepository() {
    }


    @Override
    public TextRepository getRepostory() {
        return null;
    }
}
