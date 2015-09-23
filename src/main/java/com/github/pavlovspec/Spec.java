package com.github.pavlovspec;

import com.github.pavlovspec.functions.RunnableThatThrows;

/**
 * Static class for a utility method that can be statically imported that creates a new specification simply by calling given
 */
public class Spec {

    private Spec() {
    }

    public static <T> Specification given(String text, RunnableThatThrows runnable) {
        return new Specification().given(text, runnable);
    }

}