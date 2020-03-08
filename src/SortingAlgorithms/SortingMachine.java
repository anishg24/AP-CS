/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package SortingAlgorithms;

import java.util.Arrays;

public class SortingMachine {
    public static void main(String[] args) {
        int[] array = {9, 5, 7, 1, 10, 8};
        System.out.println("Sorted with Bubble Sort: " + Arrays.toString(new BubbleSort().sort(array)));
        System.out.println("Sorted with Selection Sort: " + Arrays.toString(new SelectionSort().sort(array)));
        System.out.println("Sorted with Selection Sort: " + Arrays.toString(new InsertionSort().sort(array)));
    }
}
