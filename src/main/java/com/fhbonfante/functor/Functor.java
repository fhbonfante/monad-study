package com.fhbonfante.functor;

import java.util.function.Function;

@FunctionalInterface
public interface Functor<T, F extends Functor<?,?>> {
    <R> F map(Function<? super T,? extends R> mapper);
}
