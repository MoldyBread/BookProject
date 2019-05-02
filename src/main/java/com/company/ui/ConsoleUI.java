package com.company.ui;

import com.company.service.TextService;

import java.util.Scanner;

public class ConsoleUI {
    private TextService textService;
    private Scanner scanner;

    public ConsoleUI(TextService textService) {
        this.textService = textService;
        scanner = new Scanner(System.in);
    }


    public void run() {
        System.out.println(textService.getStatistics());
        String startString;
        String endString;

        System.out.println("Write start string to remove from sentences: ");
        startString = scanner.nextLine();
        System.out.println("Write end string to remove from sentences: ");
        endString = scanner.nextLine();

        System.out.println(textService.removeFromSentences(startString, endString));
    }
}
