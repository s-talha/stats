package com.test.stats;

import com.test.stats.analytics.StatisticsTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    private App() {
    }

    /**
     * Get data from command line argument and calculates median value
     *
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalStateException();
        }
        try {
            /* Create Integer arrray from input data */
            Integer[] data = Arrays.stream(args[0].replaceAll("\\s+", "").split(",")).map(Integer::valueOf)
                    .toArray(Integer[]::new);

            StatisticsTracker statisticsTracker = new StatisticsTracker(0, 1000);

            for (Integer number : data) {
                statisticsTracker.add(number);
            }

            int median = statisticsTracker.calculateMedian();
            LOG.debug("Median = " + median);

        } catch (NumberFormatException ex) {
            LOG.debug(ex.getMessage());
        }
    }
}
