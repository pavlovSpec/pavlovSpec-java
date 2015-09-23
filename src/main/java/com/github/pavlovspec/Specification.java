package com.github.pavlovspec;

import com.github.pavlovspec.exceptions.SpecificationExecutionException;
import com.github.pavlovspec.functions.RunnableThatThrows;

public class Specification {

    protected String title = null;

    public Specification() {
        this(null);
    }

    public Specification(String title) {
        this.title = title;
    }

    public Specification given(String text, RunnableThatThrows runnable) {
        System.out.print("Given: ");
        return process(text, runnable);
    }

    public Specification when(String text, RunnableThatThrows runnable) {
        System.out.print("When: ");
        return process(text, runnable);
    }

    public Specification then(String text, RunnableThatThrows runnable) {
        System.out.print("Then: ");
        return process(text, runnable);
    }

    protected Specification process(String text, RunnableThatThrows runnable) {
        System.out.println(text);
        try {
            runnable.run();
        } catch (Error | RuntimeException e) {
            throw e;
        } catch (Throwable e) {
            // should only be checked exceptions at this point
            throw new SpecificationExecutionException("An exception occurred during execution of the Specification", e);
        }
        return this;
    }

    /**
     * Other versions of Pavlov have had an execute method that actually performs the {@link Specification} while the other methods simply gather and build the full Spec.
     * 
     * This has advantages, like fully forming the GWT language such that you can print the whole specification before running (and if you fail in the when, then you can see what it was meant to test.
     * 
     * At this time, it's needlessly complex. It may be revisited in the future, but to maintain passivity, you shouldn't NEED to call execute. Futhermore, not doing the collecting and delayed execution is likely to make debugging and stack
     * traces far less confusing.
     * 
     * 
     */
    @SuppressWarnings("unused")
    private void execute() {
        throw new UnsupportedOperationException();
    }

}
