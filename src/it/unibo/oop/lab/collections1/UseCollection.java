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
	public static int NUMBER_ELEMENTS_TO_INSERT = 100_000;
	public static int NUMBER_ELEMENTS_TO_READ = 1000;

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
         * Prepare a variable for measuring time
         */
        long time = System.nanoTime();
    	
    	for(int i = 0; i < NUMBER_ELEMENTS_TO_INSERT; i++) {
    		arrayList.add(1, i);
    	}
    	
    	time = System.nanoTime() - time;
    	
    	System.out.println("\nInsert elements in the head of an array list: " + time);
    	
    	long time2 = System.nanoTime();
    	
    	for(int i = 0; i < NUMBER_ELEMENTS_TO_INSERT; i++) {
    		linkedList.add(1, i);
    	}
    	
    	time2 = System.nanoTime() - time;
    	
    	System.out.println("Insert elements in the head of an linked list: " + time2);
    	
    	time = System.nanoTime();
    	
    	for(int i = 0; i < NUMBER_ELEMENTS_TO_READ; i++) {
    		arrayList.get(arrayList.size()/2);
    	}
    	
    	time = System.nanoTime() - time;
    	
    	System.out.println("Read 1000 elements in array list: " + time);
    	
    	time2 = System.nanoTime();
    	
    	for(int i = 0; i < NUMBER_ELEMENTS_TO_READ; i++) {
    		linkedList.get(linkedList.size()/2);
    	}
    	
    	time2 = System.nanoTime() - time;
    	
    	System.out.println("Read 1000 elements in linked list: " + time2);
    	
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
