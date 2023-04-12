package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int middle = (leftIndex + rightIndex) / 2;
		int cont = leftIndex;

		//Ajustar para receber tipos genéricos
		T[] aux = (T[]) new Comparable[array.length];
		for (int i = leftIndex; i <= rightIndex; i++) {
			//Retirar cast
			aux[i] = array[i];
		}

		for (int i = leftIndex; i <= middle; i++) {
			for (int j = middle + 1; j <= rightIndex; j++) {
				if (aux[j].compareTo(aux[i]) > 0) {
					array[cont] = aux[i];
				} else if (aux[i].compareTo(aux[j]) > 0) {
					array[cont] = aux[j];
				}
				cont++;

				if (i == middle) {
					array[cont] = aux[i];
					cont++;
				}

				if (j == middle) {
					array[cont] = aux[j];
					cont++;
				}

			}
		}


	}
}