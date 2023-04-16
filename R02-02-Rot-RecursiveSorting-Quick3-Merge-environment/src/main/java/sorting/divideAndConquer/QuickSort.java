package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

import java.util.Random;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex && array != null) {
            int index_pivot = partition(array, leftIndex, rightIndex);
            sort(array, leftIndex, index_pivot - 1);
            sort(array, index_pivot + 1, rightIndex);
        }
    }

    public int partition(T[] array, int leftIndex, int rightIndex) {
        int randomPivotIndex = new Random().nextInt(rightIndex - leftIndex + 1) + leftIndex;
        Util.swap(array, leftIndex, randomPivotIndex);

        T pivot = array[leftIndex];
        int inicio = leftIndex + 1;
        int fim = rightIndex;

        while (fim >= inicio) {
            if (pivot.compareTo(array[inicio]) >= 0) {
                inicio++;
            } else if (pivot.compareTo(array[fim]) < 0) {
                fim--;
            } else {
                Util.swap(array, inicio, fim);
                inicio ++;
                fim --;
            }
        }
        array[leftIndex] = array[fim];
        array[fim] = pivot;
        return fim;

    }
}
