package com.fhbonfante.monad;

import com.fhbonfante.filter.Filter;
import com.fhbonfante.functor.Functor;

import java.util.function.Function;

public interface Monad<T> extends Functor<T,Monad<?>>,
                                  Filter<T> {
    <R> Monad<R> flatMap(Function<T,R> mapper);
}
