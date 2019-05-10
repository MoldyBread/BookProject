package com.company.util;

import com.company.entity.PunctuationMark;
import com.company.entity.Sentence;
import com.company.entity.Word;
import javafx.util.Pair;

import java.util.StringTokenizer;

public class SentenceTools {
    public static Pair<Sentence,String> removeSubstring(Sentence currentSentence, String startSymbols, String endSymbols) {
        String sentence = currentSentence.toString();
        int start = sentence.indexOf(startSymbols);
        int end = sentence.lastIndexOf(endSymbols)+endSymbols.length();
        if (start != -1 && end != -1 && start <= end) {
            String res = sentence.substring(start, end);
            return new Pair<>(sentenceChange(sentence.substring(0, start) + sentence.substring(end)),res);
        }
        return null;
    }

    private static Sentence sentenceChange(String sentence) {
        Sentence result = new Sentence();
        StringTokenizer st = new StringTokenizer(sentence, " ");
        while (st.hasMoreTokens()) {
            tokenWordProcessing(st.nextToken(),result);
        }
        return result;
    }

    public static void tokenWordProcessing(String token,Sentence sentence){
        if(token.endsWith(".")||token.endsWith(",")
                ||token.endsWith("!")||token.endsWith("?")||
                token.endsWith(":")){
            sentence.add(new Word(token.substring(0,token.length()-1)));
            sentence.add(new PunctuationMark(token.charAt(token.length()-1)));
        }else{
            sentence.add(new Word(token));
        }
    }
}
