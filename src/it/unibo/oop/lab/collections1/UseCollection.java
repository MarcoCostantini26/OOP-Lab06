package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static int START_VALUE = 1000;
	private static int FINAL_VALUE = 2000;
	private static int FIRST_ELEMENT = 0;
	private static int FIX_INDEX_ARRAY_LIST = 1;
	private static int NUMBER_ELEMENTS_TO_INSERT = 100_000;
	private static int NUMBER_ELEMENTS_TO_READ = 1000;

	private static long AFRICA_POPULATION = 1_110_635_000L;
    private static long AMERICAS_POPULATION = 972_005_000L;
    private static long ANTARCTICA_POPULATION = 0L;
    private static long ASIA_POPULATION = 4_298_723_000L;
    private static long EUROPE_POPULATION = 742_452_000L;
    private static long OCEANIA_POPULATION = 38_304_000L;
    
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
    	
    	Map<String, Long> map = new HashMap<String, Long>();
    	
    	map.put("Africa", AFRICA_POPULATION);
    	map.put("Americas", AMERICAS_POPULATION);
    	map.put("Antarctica", ANTARCTICA_POPULATION);
    	map.put("Asia", ASIA_POPULATION);
    	map.put("Europe", EUROPE_POPULATION);
    	map.put("Oceania", OCEANIA_POPULATION);
    	
    	long population = 0;
    	for(long people : map.values()) {
    		population += people;
    	}
    	
    	System.out.println("Population: " + population);
    }
}
