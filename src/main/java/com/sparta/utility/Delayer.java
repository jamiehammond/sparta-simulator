package com.sparta.utility;

import java.util.concurrent.TimeUnit;

/**
 * The class {@code Delayer} is an utility class delaying the execution of
 * caller thread.
 *
 * @author Samurah
 * @since 1.0
 */

public class Delayer {

    /**
     * Performs a {@link TimeUnit#sleep(long) TimeUnit.sleep}
     * Handles {@link InterruptedException}
     *
     * @param timeout the minimum time to sleep. If less than
     * or equal to zero, do not sleep at all.
     */
    public static void delay(long timeout) {
        try{
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException ignored) {}
    }
}
