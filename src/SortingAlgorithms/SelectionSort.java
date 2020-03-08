/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package SortingAlgorithms;

public class SelectionSort {
    public SelectionSort() {

    }

    public int[] sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx]) min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
