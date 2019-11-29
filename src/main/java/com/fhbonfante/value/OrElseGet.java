package com.fhbonfante.value;

import java.util.function.Supplier;

@FunctionalInterface
public interface OrElseGet<T> {
    T orElseGet(Supplier<T> otherSupplier);
}
