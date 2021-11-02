package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	public static int START_VALUE = 1000;
	public static int FINAL_VALUE = 2000;
	public static int FIRST_ELEMENT = 0;
	public static int FIX_INDEX_ARRAY_LIST = 1;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
    	List<Integer> arrayList = new ArrayList<>();
    	for(int i = START_VALUE; i < FINAL_VALUE; i++) {
    		arrayList.add(i);
    	}
    	
    	List<Integer> linkedList = new LinkedList<>();
    	linkedList.addAll(arrayList);
    	
    	int tmpElement = arrayList.get(FIRST_ELEMENT);
    	arrayList.set(FIRST_ELEMENT, arrayList.get(arrayList.size() - FIX_INDEX_ARRAY_LIST));
    	arrayList.set(arrayList.size() - FIX_INDEX_ARRAY_LIST, tmpElement);
    	
    	for(Integer elems : arrayList) {
    		System.out.print(elems + " ");
    	}
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
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
        /*
         * 8) Compute the population of the world
         */
    }
}
