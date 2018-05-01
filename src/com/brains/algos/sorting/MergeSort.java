package com.brains.algos.sorting;

/*
    Best case time complexity : Ω(n log(n))
    Average case time complexity : Θ(n log(n))
    Worst case time complexity : O(n log(n))
*/
public class MergeSort extends AbstractSort {

    @Override
    void sort(int arr[]) {
        mergeSort(arr, new int[arr.length], 0, arr.length-1);
    }


    private void mergeSort(int arr[], int temp[], int start, int end) {
        if(start >= end) return;
        int middle = start + (end - start)/2 ; // to avoid overflow
        mergeSort(arr, temp, start, middle);
        mergeSort(arr, temp, middle+1, end);
        merge(arr, temp, start, end);
    }

    private void merge(int arr[], int temp[], int leftStart, int rightEnd) {
        int leftEnd = leftStart + (rightEnd - leftStart)/2;
        int rightStart = leftEnd + 1;

        int leftIndex = leftStart;
        int rightIndex = rightStart;
        int index = leftStart;

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if(arr[leftIndex] <= arr[rightIndex]) {
                temp[index] = arr[leftIndex];
                leftIndex++;
            } else {
                temp[index] = arr[rightIndex];
                rightIndex++;
            }
            index++;
        }

        System.arraycopy(arr, leftIndex, temp, index, leftEnd-leftIndex+1);
        System.arraycopy(arr, rightIndex, temp, index, rightEnd-rightIndex+1);
        System.arraycopy(temp, leftStart, arr, leftStart,rightEnd-leftStart+1);
    }

    public static void main(String[] args) {
        MergeSort ob = new MergeSort();
        int arr[] = {2,5,8,6,3,7};
        ob.sort(arr);
        ob.printArray(arr);
    }
}

