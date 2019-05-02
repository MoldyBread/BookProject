package com.company;

import com.company.parser.implementation.TextParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(new TextParser("1984.txt").getRepositoryStatistics());
    }
}
