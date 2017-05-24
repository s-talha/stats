package com.test.stats.analytics;

import com.test.stats.analytics.StatisticsTracker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatisticsTrackerTest {

    /**
     * To test if correct exception is thrown when tyring to calcuate median with empty heaps
     */
    @Test(expected = IllegalStateException.class)
    public void testMedianCalculationWithEmptyHeaps() {
        new StatisticsTracker(0, 1000).calculateMedian();
    }

    /**
     * To test if medium is correctly calculated
     */
    @Test
    public void testMedianCalculation() throws Exception {
        Integer expectedMedian = 6;
        StatisticsTracker statisticsTracker = new StatisticsTracker(0, 1000);

        statisticsTracker.add(4);
        statisticsTracker.add(1);
        statisticsTracker.add(6);
        statisticsTracker.add(3);
        statisticsTracker.add(7);
        statisticsTracker.add(8);
        statisticsTracker.add(7);

        assertEquals("Median is same as expected", statisticsTracker.calculateMedian(), expectedMedian);
    }

    /**
     * To test if median calculatoin with value exceeding upper limit
     */
    @Test
    public void testMedianWithHighValueThanUpper() {

        Integer expectedMedian = 1000;
        StatisticsTracker statisticsTracker = new StatisticsTracker(0, 1000);
        statisticsTracker.add(2000);
        statisticsTracker.add(1);
        statisticsTracker.add(2000);

        assertEquals("Median is same as expected", statisticsTracker.calculateMedian(), expectedMedian);
    }
}