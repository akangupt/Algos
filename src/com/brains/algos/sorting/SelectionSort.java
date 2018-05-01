package com.brains.algos.sorting;

/*
    Best case time complexity : Ω(n^2)
    Average case time complexity : Θ(n^2)
    Worst case time complexity : O(n^2)
*/
public class SelectionSort extends AbstractSort {

    @Override
    void sort(int arr[]) {
        for(int i = 0; i <arr.length-1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            if(min != i) swap(arr, min, i);
        }
    }

    public static void main(String[] args) {
        SelectionSort ob = new SelectionSort();
        int arr[] = {2,5,8,6,3,7};
        ob.sort(arr);
        ob.printArray(arr);
    }
}