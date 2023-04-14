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

    public void mergeSort(T[] array, int leftIndex, int middle, int rightIndex) {
//		int cont = leftIndex;

        T[] aux = Arrays.copyOf(array, array.length);

        int i = leftIndex;
        int j = middle + 1;
        int k = leftIndex;

        while (i <= middle && j <= rightIndex) {

            if (aux[j].compareTo(aux[i]) > 0) {
                array[k] = aux[i];
                i++;
            } else {
                array[k] = aux[j];
                j++;
            }
            k++;

        }

        // se a metade inicial não foi toda consumida, faz o append.
        while (i <= middle) {
            array[k] = aux[i];
            i++;
            k++;
        }

        // se a metade final não foi toda consumida, faz o append.
        while (j <= rightIndex) {
            array[k] = aux[j];
            j++;
            k++;
        }
    }


    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {

            int middle = (leftIndex + rightIndex) / 2;
            sort(array, leftIndex, middle);
            sort(array, middle + 1, rightIndex);

            mergeSort(array, leftIndex, middle, rightIndex);
        }

    }
}