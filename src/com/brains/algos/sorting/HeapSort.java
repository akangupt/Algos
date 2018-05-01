package com.brains.algos.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import com.brains.algos.heap.Heap;

/*
    Best case time complexity : Ω(n log(n))
    Average case time complexity : Θ(n log(n))
    Worst case time complexity : O(n^2)
*/
public class HeapSort extends AbstractSort{

    @Override
    void sort(int[] arr) {

    }

    private ArrayList<Integer>  sort(ArrayList<Integer> arr) {
        Heap heap = new Heap();
        ArrayList<Integer> duplicate = new ArrayList<Integer>();
        heap.buildHeap(arr, Heap.MaxMinHeapEnum.MAX);
        int length = arr.size();
        for (int i = 0; i < length; i++) {
            int value = heap.extractTop(arr, Heap.MaxMinHeapEnum.MAX);
            duplicate.add(value);
        }
        return duplicate;
    }

    private void printArray(ArrayList<Integer> arr) {
        for (int a: arr) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        HeapSort ob = new HeapSort();
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2,5,8,6,3,7));
        arr = ob.sort(arr);
        ob.printArray(arr);
    }
}

