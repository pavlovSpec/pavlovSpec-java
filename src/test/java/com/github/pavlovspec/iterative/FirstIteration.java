package com.github.pavlovspec.iterative;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

import com.github.pavlovspec.Specification;

/**
 * In its simplest form, it should with basic {@link Runnable}s that can be passed
 */
public class FirstIteration {

    protected Specification spec = new Specification();

    @Test
    public void shouldWorkAsBasicRunnables() {
        AtomicInteger a = new AtomicInteger();
        AtomicInteger b = new AtomicInteger();
        AtomicInteger result = new AtomicInteger();

        spec.given("Two numbers", () -> {
            a.set(1);
            b.set(3);
        }).when("I add them together", () -> {
            result.set(a.get() + b.get());
        }).then("The result is equal to the sum.", () -> {
            Assert.assertEquals(4, result.get());
        });
    }

    @Test(expected = AssertionError.class)
    public void shouldFail() {
        spec.given("A specification that fails", () -> {
            // do nothing
        }).when("the specification is executed", () -> {
            // do nothing
        }).then("then it should, in fact, fail.", () -> {
            Assert.fail();
        });
    }

}
