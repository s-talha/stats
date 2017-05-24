package com.test.stats.validation;

/**
 * Interface to create validation rules
 *
 * @param <T>
 */
public interface Validator<T> {
    public ValidationResult validate(T input);
}