/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakespeare_project;

import java.io.IOException;
import sorting_algorithms.MergeSort;
import sorting_algorithms.QuickSort;
import sorting_algorithms.TrieSort;
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
            System.out.println("WORDCOUNT :" + words.length);

            double count = 0;
            for (String w : words) {
                count += w.length();
            }
            System.out.println("avg " + (count / (long) words.length));

            
            // MergeSort
            String[] copyMergeSort = words.clone();
            long before = System.currentTimeMillis();
            MergeSort.mergeSort(copyMergeSort, 0, copyMergeSort.length - 1);
            long after = System.currentTimeMillis();
            System.out.println("MERGESORT execution time: " + (after - before) + " ms");
            
            // QuickSort
            String[] copyQuickSort = words.clone();
            long before1 = System.currentTimeMillis();
            QuickSort.quickSort(copyQuickSort, 0, copyQuickSort.length - 1);
            long after1 = System.currentTimeMillis();
            System.out.println("QUICKSORT execution time: " + (after1 - before1) + " ms");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
