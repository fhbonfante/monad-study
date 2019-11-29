package com.fhbonfante.control;

import com.fhbonfante.monad.Monad;
import com.fhbonfante.value.OrElseGet;
import com.fhbonfante.value.OrElseThrow;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.Objects.nonNull;

/**
 * Data structure that represents an element that may be present or not.
 *
 * It wraps a value of type {@link T} and provide safe data manipulation, dealing with
 * nullable values. Also provides
 *
 *
 * @param <T>
 */
public final class Option<T> implements Monad<T>,
                                        OrElseGet<T>,
                                        OrElseThrow<T> {

    private static final Option<?> EMPTY = new Option<>();
    private T value;

    private Option() {}

    private Option(T value) {
        this.value = value;
    }

    /**
     * Unit function to generate an empty Option inferring type {@link T}
     * @param <T> the inferred type
     * @return an {@link Option<T>} without value
     */
    public static <T> Option<T> empty() {
        Option<T> empty = (Option<T>) EMPTY;
        return empty;
    }

    /**
     *
     * @param value
     * @param <T>
     * @return
     */
    public static <T> Option<T> of(T value) {
        return new Option<>(value);
    }

    @Override
    public <R> Option<R> map(Function<? super T, ? extends R> mapper) {
        return isPresent() ? new Option<>(mapper.apply(value)): empty();
    }

    @Override
    public <R> Option<R> flatMap(Function<T, R> mapper) {
        return isPresent() ? of(mapper.apply(value)) : empty();
    }

    @Override
    public Option<T> filter(Predicate<T> filter) {
        if (isPresent()) {
            return filter.test(value) ? this : empty();
        } else {
            return this;
        }
    }

    @Override
    public T orElseGet(Supplier<T> otherSupplier) {
        return isPresent() ? value : otherSupplier.get();
    }

    @Override
    public <X extends Throwable> T orElseThrow(Supplier<X> throwableSupplier) throws X {
        if (isPresent()) {
            return value;
        } else {
            throw throwableSupplier.get();
        }
    }

    public boolean isPresent() {
        return nonNull(value);
    }

}
