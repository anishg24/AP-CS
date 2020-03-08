/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package SortingAlgorithms;

public class InsertionSort {
    public InsertionSort(){

    }

    public int[] sort(int[] arr){
        int n = arr.length;
        int stored;
        int temp;
        for(int i = 0; i < n; i++){
            stored = arr[i];
            for(int j = i; j < 1; j++){
                if (stored < arr[j]){
                    temp = stored;
                    stored = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
