package com.brains.algos.sorting;

/*
    Best case time complexity : Ω(n)
    Average case time complexity : Θ(n^2)
    Worst case time complexity : O(n^2)
*/
public class InsertionSort extends AbstractSort {

    void sort(int arr[]) {
        int n = arr.length;
        for(int i = 1; i <n; i++) {
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        InsertionSort ob = new InsertionSort();
        int arr[] = {2,5,8,6,3,7};
        ob.sort(arr);
        ob.printArray(arr);
    }
}
