package com.github.pavlovspec.exceptions;

import com.github.pavlovspec.Specification;

/**
 * An exception that occurs during the execution of a {@link Specification}. Often, this will be a wrapped checked exception.
 */
public class SpecificationExecutionException extends RuntimeException {

    public SpecificationExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
