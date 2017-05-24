package com.test.stats.validation;

import com.test.stats.analytics.InputStatus;

public class ValidationResult {
    private static final ValidationResult VALID = new ValidationResult(true, InputStatus.VALID_VALUE);
    public final boolean isValid;
    public final InputStatus message;

    /**
     * Set validation and message
     *
     * @param isValid
     * @param inputStatus
     */
    private ValidationResult(boolean isValid, InputStatus inputStatus) {
        this.isValid = isValid;
        this.message = inputStatus;
    }

    /**
     * Get valid state
     *
     * @return ValidationResult
     */
    public static ValidationResult valid() {
        return VALID;
    }

    /**
     * Get invalid state with the message
     *
     * @param inputStatus
     * @return ValidationResult
     */
    public static ValidationResult invalid(InputStatus inputStatus) {
        return new ValidationResult(false, inputStatus);
    }
}
