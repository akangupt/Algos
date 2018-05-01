package com.brains.algos.sorting;

/*
    Best case time complexity : Ω(n)
    Average case time complexity : Θ(n^2)
    Worst case time complexity : O(n^2)
*/
public class BubbleSort extends AbstractSort {

    @Override
    void sort(int arr[]) {
        boolean swapped = true;
        int lastSorted = arr.length;
        while (swapped) {
            swapped = false;
            for(int i = 1; i <lastSorted; i++) {
                if (arr[i] < arr[i-1]) {
                    swap(arr, i-1, i);
                    swapped = true;
                }
            }
            lastSorted -- ;
        }
    }

    public static void main(String[] args) {
        BubbleSort ob = new BubbleSort();
        int arr[] = {2,5,8,6,3,7};
        ob.sort(arr);
        ob.printArray(arr);
    }
}
