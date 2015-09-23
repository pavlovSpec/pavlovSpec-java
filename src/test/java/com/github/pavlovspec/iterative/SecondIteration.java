package com.github.pavlovspec.iterative;

import java.util.concurrent.atomic.AtomicReference;

import org.junit.Assert;
import org.junit.Test;

import com.github.pavlovspec.Spec;
import com.github.pavlovspec.exceptions.SpecificationExecutionException;

/**
 * Allowing exceptions to be thrown, and tested
 */
public class SecondIteration {

    class CheckedException extends Exception {

    }

    @Test
    public void shouldAllowCheckedExceptionToBeThrown() {
        try {
            Spec.given("A specification", () -> {
            }).when("I add a lambda that throws a checked exception", () -> {
                throw new CheckedException();
            }).then("The specification compiles, and throws the exception when run.", () -> {
                Assert.fail("Should never run this line.");
            });
        } catch (SpecificationExecutionException e) {
            Assert.assertTrue(e.getCause() instanceof CheckedException);
        }
    }

    @Test
    public void shouldAllowPassingExceptionToThen() {

        AtomicReference<CheckedException> exception = new AtomicReference<>();

        Spec.given("A specification asserting an exception is thrown", () -> {
        }).when("I add a lambda that throws a checked exception", () -> {
            try {
                throw new CheckedException();
            } catch (CheckedException e) {
                exception.set(e);
            }
        }).then("The specification compiles, and throws the exception when run.", () -> {
            Assert.assertTrue(exception.get() instanceof CheckedException);
        });
    }

}
