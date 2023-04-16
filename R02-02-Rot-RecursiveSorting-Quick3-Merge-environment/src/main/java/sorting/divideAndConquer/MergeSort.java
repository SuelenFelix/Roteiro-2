package sorting.divideAndConquer;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {

            int middle = (leftIndex + rightIndex) / 2;
            sort(array, leftIndex, middle);
            sort(array, middle + 1, rightIndex);

            mergeSort(array, leftIndex, middle, rightIndex);
        }

    }

    public void mergeSort(T[] array, int leftIndex, int middle, int rightIndex) {
        T[] aux = Arrays.copyOf(array, array.length);

        int i = leftIndex;
        int j = middle + 1;
        int cont = leftIndex;

        while (i <= middle && j <= rightIndex) {

            if (aux[j].compareTo(aux[i]) > 0) {
                array[cont] = aux[i];
                i++;
            } else {
                array[cont] = aux[j];
                j++;
            }
            cont++;

        }

        while (i <= middle) {
            array[cont] = aux[i];
            i++;
            cont++;
        }

        while (j <= rightIndex) {
            array[cont] = aux[j];
            j++;
            cont++;
        }
    }
}