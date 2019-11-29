package com.fhbonfante.value;

import java.util.function.Supplier;

@FunctionalInterface
public interface OrElseThrow<T> {
    <X extends Throwable> T orElseThrow(Supplier<X> throwableSupplier) throws X;
}
