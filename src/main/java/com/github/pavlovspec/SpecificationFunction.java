package com.github.pavlovspec;

@FunctionalInterface
public interface SpecificationFunction<R> {

    /**
     * Applies this specification step to the given argument
     *
     * @param t
     *            the function argument
     * @return the function result
     */
    <T> R specify(T t) throws Throwable;

}
