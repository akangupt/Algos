package com.brains.algos.sorting;

abstract class AbstractSort {
    void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    void printArray(int arr[]) {
        for (int a: arr) {
            System.out.println(a);
        }
    }

    abstract void sort(int arr[]);

}