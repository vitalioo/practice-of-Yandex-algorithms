package org.example;

import java.util.ArrayList;

public class Quicksort {
    public ArrayList<Integer> quicksort(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int pivot = partition(list, low, high);

            quicksort(list, low, pivot - 1);
            quicksort(list, pivot, high);
        }

        return list;
    }

    public int partition(ArrayList<Integer> numbers, int low, int high) {
        int middle = low + (high - low) / 2;
        Integer pivot = numbers.get(middle);

        int leftIndex = low;
        int rightIndex = high;

        while (leftIndex <= rightIndex) {

            while (numbers.get(leftIndex) < pivot) {
                ++leftIndex;
            }

            while (numbers.get(rightIndex) > pivot) {
                --rightIndex;
            }

            if (leftIndex <= rightIndex) {
                Integer tmpValue = numbers.get(leftIndex);
                numbers.set(leftIndex, numbers.get(rightIndex));
                numbers.set(rightIndex, tmpValue);
                ++leftIndex;
                --rightIndex;
            }
        }

        return leftIndex;
    }
}