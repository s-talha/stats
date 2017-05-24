package com.test.stats.validation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerBoundsValidatorTest {

    /**
     * To test if correct exception is thrown when lower limit is greater than upper limit for range of Integers
     */
    @Test(expected = IllegalStateException.class)
    public void testLowerLimitGreaterThanUpperLimit() {
        new IntegerBoundsValidator(1000, 0);
    }

    /**
     * To test invalid range of integers
     */
    @Test
    public void testInvalidData() {
        IntegerBoundsValidator validator = new IntegerBoundsValidator(0, 1000);
        ValidationResult result = validator.validate(-1);
        assertEquals(result.isValid, false);
    }
}