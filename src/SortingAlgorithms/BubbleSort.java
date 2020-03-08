/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package SortingAlgorithms;

public class BubbleSort {
    public BubbleSort() {

    }

    public int[] sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] >= arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
