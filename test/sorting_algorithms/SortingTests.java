/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_algorithms;

import java.io.IOException;
import java.util.Arrays;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.FileUtility;

/**
 *
 * @author stanislavnovitski
 */
public class SortingTests {

    static String[] words = null;

    public SortingTests() {
    }

    @BeforeClass
    public static void setUpClass() {
        try {
            // Retrieving and sanitizing data
            words = FileUtility.toStringArray("src/shakespeare_project/data.txt", "[^a-zA-Z]");
            System.out.println("WORDCOUNT :" + words.length);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Test of mergeSort, of class MergeSort.
     */
    @Test
    public void testMergeSort() {
        String[] wordsCopy = words.clone();
        long before = System.currentTimeMillis();
        MergeSort.mergeSort(wordsCopy, 0, wordsCopy.length - 1);
        long after = System.currentTimeMillis();
        System.out.println("MERGESORT execution time: " + (after - before) + " ms");
        assertTrue(this.isSorted(wordsCopy));
    }

    /**
     * Test of QuickSort
     */
    @Test
    public void testQuickSort() {
        String[] wordsCopy = words.clone();
        long before = System.currentTimeMillis();
        QuickSort.quickSort(wordsCopy, 0, wordsCopy.length - 1);
        long after = System.currentTimeMillis();
        System.out.println("QUICKSORT execution time: " + (after - before) + " ms");
        assertTrue(this.isSorted(wordsCopy));
    }

    /**
     * Test of InsertionSort
     */
    @Test
    public void testInsertionSort() {
//        String[] wordsCopy = words.clone();
        long before = System.currentTimeMillis();
        String[] test = Arrays.copyOfRange(words.clone(), 0, 100000);
        InsertionSort.sort(test);
        long after = System.currentTimeMillis();
        System.out.println("INSERTIONSORT (10000) execution time: " + (after - before) + " ms");
        assertTrue(this.isSorted(test));
    }

    private boolean isSorted(Comparable[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    private void printSome(String[] arr, int from, int to) {
        for (int i = from; i < to; i++) {
            System.out.println(arr[i]);
        }
    }
}
