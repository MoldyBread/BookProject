package com.company.parser;

import com.company.repository.Repository;

/**
 *  The {@code Parser} interface represents a
 *  Parser that creates and fills repository
 *
 *  @author Liash Danylo
 *
 */
public interface Parser {
    /**
     *
     * @return Created repository
     */
    Repository getRepository();
}
