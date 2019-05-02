package com.company.ui;

import com.company.service.TextService;

import java.util.Scanner;

public class ConsoleUI {
    private TextService textService;
    private Scanner scanner;

    public ConsoleUI(TextService textService) {
        this.textService = textService;
        scanner=new Scanner(System.in);
    }


    public void run(){
        System.out.println(textService.getStatistics());
        System.out.println(textService.removeFromSentences("in","n"));
    }
}
