package com.company.entity;

import java.util.Objects;

/**
 *  The {@code Symbol} class represents a
 *  symbol in repository
 *
 *  @author Liash Danylo
 *
 */
public class Symbol {
    private char symbol;

    /**
     * Initializes symbol
     *
     * @param symbol Symbol char to initialize
     */
    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol1 = (Symbol) o;
        return symbol == symbol1.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}
