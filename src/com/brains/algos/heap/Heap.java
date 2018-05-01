package com.brains.algos.heap;

import java.util.ArrayList;

/*
    TODO: Make this class generic
*/

public class Heap {

    public enum MaxMinHeapEnum {
        MIN,
        MAX
    }

    public void buildHeap (ArrayList<Integer> arr, MaxMinHeapEnum type) {
        int n = arr.size();
        for (int i = (n/2)-1; i >= 0 ; i--) {
            heapifyDown(arr, i, type);
        }
    }

    public void heapifyDown (ArrayList<Integer> arr, int i, MaxMinHeapEnum type) {
        int size = arr.size();
        int leftChild = (2*i)+1;
        int rightChild = leftChild + 1;

        int smallest = i, largest = i;
        if(leftChild < size ) {
            if(arr.get(leftChild) < arr.get(smallest)) smallest = leftChild;
            else largest = leftChild;
        }
        if(rightChild < size ) {
            if(arr.get(rightChild) < arr.get(smallest)) smallest = rightChild;
            if(arr.get(rightChild) > arr.get(largest)) largest = rightChild;
        }

        switch(type) {
            case MIN:
                if(i != smallest) {
                    swap(arr, smallest, i);
                    heapifyDown(arr, smallest, MaxMinHeapEnum.MIN);
                }
                break;

            case MAX:
                if(i != largest) {
                    swap(arr, largest, i);
                    heapifyDown(arr, largest, MaxMinHeapEnum.MAX);
                }
                break;
        }
    }

    public void heapifyUp (ArrayList<Integer> arr, int i, MaxMinHeapEnum type) {
        int size = arr.size();
        int parent = (i-1)/2;
        int smallest = parent, largest = parent;

        // note that in heapifyDown i denotes the parent but in heapifyUp i denotes the child
        if(arr.get(i) < arr.get(parent)) {
            smallest = i;
        } else {
            largest = i;
        }

        switch(type) {
            case MIN:
                if(parent != smallest) {
                    swap(arr, smallest, i);
                    heapifyUp(arr, smallest, MaxMinHeapEnum.MIN);
                }
                break;

            case MAX:
                if(parent != largest) {
                    swap(arr, largest, i);
                    heapifyUp(arr, largest, MaxMinHeapEnum.MAX);
                }
                break;
        }
    }

    private void swap(ArrayList<Integer> arr, int a, int b) {
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }

    public int extractTop(ArrayList<Integer> arr, MaxMinHeapEnum type) {
        int value = arr.get(0);
        arr.set(0, arr.get(arr.size()-1));
        arr.remove(arr.size()-1);
        heapifyDown(arr, 0, type);
        return value;
    }

    public void updateAtIndex(ArrayList<Integer> arr, int index, int key, MaxMinHeapEnum type) {
        arr.set(index, key);
        heapifyDown(arr, index, type);
        heapifyUp(arr, index, type);
    }

    public void insert(ArrayList<Integer> arr, int value, MaxMinHeapEnum type) {
        arr.add(value);
        heapifyUp(arr, arr.size()-1, type);
    }

}
