package com.test.stats.validation;

import com.test.stats.analytics.InputStatus;

/**
 * IntegerBoundsValidator class to validate if integers belong to the specified range
 */
public class IntegerBoundsValidator implements Validator<Integer> {
    private int lowerBound;
    private int upperBound;

    /**
     * Set lower and upper limits for valiation
     *
     * @param lower
     * @param upper
     */
    public IntegerBoundsValidator(int lower, int upper) {
        if (lower > upper) {
            throw new IllegalStateException();
        }
        lowerBound = lower;
        upperBound = upper;
    }

    /**
     * Validae input on base of specified rules
     */
    @Override
    public ValidationResult validate(Integer input) {
        if (input < lowerBound) {
            return ValidationResult.invalid(InputStatus.VALUE_LESS_THAN_MIN);
        }
        if (input > upperBound) {
            return ValidationResult.invalid(InputStatus.VALUE_GREATER_THAN_MAX);
        }
        return ValidationResult.valid();
    }
}
