package com.test.stats.analytics;

import com.test.stats.validation.IntegerBoundsValidator;
import com.test.stats.validation.ValidationResult;
import com.test.stats.validation.Validator;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * StatisticsTracker class to add statistics data and evaluate median on behalf of that data
 */
public class StatisticsTracker {

    private Queue<Integer> lowerHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private Queue<Integer> higherHeap = new PriorityQueue<>();
    private Validator<Integer> validator;

    /**
     * Create validator on behalf of lower and upper limit of integers
     *
     * @param lowerLimit
     * @param upperLimit
     */
    public StatisticsTracker(int lowerLimit, int upperLimit) {
        validator = new IntegerBoundsValidator(lowerLimit, upperLimit);
    }

    /**
     * Add number to the respective heap
     *
     * @param number
     */
    private void addNumber(int number) {
        Queue<Integer> targetHeap = lowerHeap.size() <= higherHeap.size() ? lowerHeap : higherHeap;
        targetHeap.add(number);
        adjustBalance();
    }

    /**
     * Validate number and responsible to add it the heaps
     *
     * @param number
     */
    public void add(int number) {
        ValidationResult result = validator.validate(number);
        if (result.isValid) {
            addNumber(number);
        } else if (!result.isValid && result.message == InputStatus.VALUE_GREATER_THAN_MAX) {
            /* Set the number to the maxiumum number if it exceeds the limit */
            addNumber(1000);
        }
    }

    /**
     * To balance the heaps after adding a number
     */
    private void adjustBalance() {
        if (!lowerHeap.isEmpty() && !higherHeap.isEmpty() && lowerHeap.peek() > higherHeap.peek()) {
            Integer lowerHeapHead = lowerHeap.poll();
            Integer higherHeapHead = higherHeap.poll();
            lowerHeap.add(higherHeapHead);
            higherHeap.add(lowerHeapHead);
        }
    }

    /**
     * Calcuate median value
     *
     * @return median
     */
    public Integer calculateMedian() {
        if (lowerHeap.isEmpty() && higherHeap.isEmpty()) {
            throw new IllegalStateException("Empty heap is not allowed");
        } else {
            return lowerHeap.size() == higherHeap.size() ? (lowerHeap.peek() + higherHeap.peek()) / 2 : lowerHeap.peek();
        }
    }
}