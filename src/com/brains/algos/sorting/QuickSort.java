package com.brains.algos.sorting;

/*
    Best case time complexity : Ω(n log(n))
    Average case time complexity : Θ(n log(n))
    Worst case time complexity : O(n^2)
*/
public class QuickSort extends AbstractSort {

    @Override
    void sort(int arr[]) {
        quickSort(arr,0, arr.length-1);
    }

    private void quickSort(int arr[], int start, int end) {
        if(start >= end) return;
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }

    private int partition(int arr[], int start, int end) {
        int pivot = arr[end];
        int i = start-1;
        for(int j = start; j < end; j++) {
            if(arr[j] <= pivot) {
                i = i + 1;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, end);
        return i+1;
    }

    public static void main(String[] args) {
        QuickSort ob = new QuickSort();
        int arr[] = {2,5,8,6,3,7};
        ob.sort(arr);
        ob.printArray(arr);
    }
}
