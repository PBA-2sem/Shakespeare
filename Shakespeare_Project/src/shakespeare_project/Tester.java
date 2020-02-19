/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakespeare_project;

import java.io.IOException;
import java.util.Date;
import sorting_algorithms.MergeSort;
import sorting_algorithms.QuickSort;
import utilities.FileUtility;

/**
 *
 * @author Orchi
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Retrieving and sanitizing data
            String[] words = FileUtility.toStringArray("src/shakespeare_project/data.txt", "[^a-zA-Z]");
            
            // MergeSort
            String[] copyMergeSort = words;
            long before = System.currentTimeMillis();
            MergeSort.mergeSort(copyMergeSort, 0, copyMergeSort.length - 1);
            long after = System.currentTimeMillis();
            System.out.println("MERGESORT execution time: " + (after - before) + " ms");
            
            // QuickSort
            String[] copyQuickSort = words;
            long before1 = System.currentTimeMillis();
            QuickSort.quickSort(copyQuickSort, 0, copyQuickSort.length - 1);
            long after1 = System.currentTimeMillis();
            System.out.println("QUICKSORT execution time: " + (after1 - before1) + " ms");
            
            
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
