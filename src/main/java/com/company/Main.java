package com.company;

import com.company.parser.implementation.TextParser;
import com.company.service.TextService;
import com.company.service.implementation.MyTextService;
import com.company.ui.ConsoleUI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TextService textService = new MyTextService(new TextParser("1984.txt").getRepository());
        ConsoleUI consoleUI = new ConsoleUI(textService);
        consoleUI.run();
    }
}
