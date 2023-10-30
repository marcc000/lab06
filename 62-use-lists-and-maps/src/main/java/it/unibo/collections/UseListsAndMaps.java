package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> aList = new ArrayList<>();
        for(int i = 1000; i < 2000 ; i++) {
            aList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> lList = new LinkedList<>(aList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int last = aList.get(aList.size() - 1);
        aList.set(aList.size() - 1, aList.get(0));
        aList.set(0, last);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (int i : aList) {
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 1; i <= 100_000; i++) {
            aList.add(i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Inserting "
                + 100_000
                + " elements in a ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        time = System.nanoTime();
        for (int i = 1; i <= 100_000; i++) {
            lList.add(i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Inserting "
                + 100_000
                + " elements in a LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for (int i = 0; i < 1_000; i++) {
            aList.get(50_000);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading "
                + 1_000
                + " elements in a ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        time = System.nanoTime();
        for (int i = 0; i < 1_000; i++) {
            lList.get(50_000);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading "
                + 1_000
                + " elements in a LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String,Long> populationMap = Map.of(
        "Africa", 1_110_635_000L,
        "Americas", 1_110_635_000L,
        "Antarctica", 0L,
        "Asia", 4_298_723_000L,
        "Europe", 742_452_000L,
        "Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long total = 0;
        for (Long l : populationMap.values()) {
            total += l;
        }
        System.out.println("World population: " + total);
    }
}
