package com.fhbonfante.filter;

import java.util.function.Predicate;

@FunctionalInterface
public interface Filter<T> {
    Filter<T> filter(Predicate<T> filter);
}
