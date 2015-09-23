package com.github.pavlovspec;

import org.junit.Assert;
import org.junit.Test;

/**
 * Show failures in various portions of the {@link Specification} to get an idea of how error handling works and how easily the failing line of code can be reached.
 */
public class DemonstrateFailuresForDebugging {

    @Test
    public void shouldFailInGiven() {
        Specification spec = new Specification("Fail in Given");
        spec.given("A failure in the given", Assert::fail).then("No ", () -> {
            System.err.println("Should never have been here!");
        });
    }
}
