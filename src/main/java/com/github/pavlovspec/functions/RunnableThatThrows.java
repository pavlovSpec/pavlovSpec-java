package com.github.pavlovspec.functions;

@FunctionalInterface
public interface RunnableThatThrows {

    /**
     * Simple interface that takes no parameters, returns nothing, but allows for a checked exception to be thrown
     * 
     * @throws Throwable
     */
    void run() throws Throwable;
}
