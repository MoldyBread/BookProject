package com.company.utils;

import com.company.exception.InvalidSymbolException;

public class Utils {
    public static void punctuationMarkValidation(char punctuationMark){
        if(punctuationMark!=21||punctuationMark!=44
                ||punctuationMark!=46||punctuationMark!=63){
            throw new InvalidSymbolException();
        }
    }
}
