package kpatell.sorting;
/**
 * @author Krishan Patel
 * Sorts the generated data
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SortData {
	/**
	 * Prints out the array
	 * @param msg message to put in front of the array
	 * @param tArray array to print out
	 */
	public static void printArray(final String msg, final Comparable[] tArray) {
		int k = 0;
		System.out.print(msg);

		for (Comparable cc : tArray) {
			System.out.printf("%4s ", cc);

			if (++k % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println(" ");
	}

	/**
	 * Sorting an array in ascending order using selection sort
	 * @param arr array to sort
	 */
	public static void selectionSort(final Comparable[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[min]) < 0) {
					min = j;
				}
			}
			Comparable temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}

	/**
	 * Sorting an array in ascending order using insertion sort
	 * @param arr array to sort
	 */
	public static void insertionSort(final Comparable[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		
		for (int i = 1; i < arr.length; i++) {
			while (i > 0 && arr[i].compareTo(arr[i - 1]) < 0) {
				Comparable temp = arr[i];
				arr[i] = arr[i - 1];
				arr[i - 1] = temp;
				i--;
			}
		}
	}

	/**
	 * Sorting an array in ascending order using merge sort
	 * @param arr array to sort
	 */
	public static void mergeSort(final Comparable[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		
		// create the copy buffer - size of arr
		Comparable[] cb = new Comparable[arr.length];
		mergeSortHelper(0, arr.length - 1, arr, cb);
	}
	
	/**
	 * Helper to mergerSort method that sorts the array
	 * @param low the lowest index of the array
	 * @param high the highest index of the array
	 * @param arr the array to sort
	 * @param cb the copy buffer that is the temporary array that holds the sorted values
	 */
	public static void mergeSortHelper(final int low, final int high, final Comparable[] arr, final Comparable[] cb) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSortHelper(low, mid, arr, cb);
			mergeSortHelper(mid + 1, high, arr, cb);
			merge(low, mid, high, arr, cb);
		}
	}
	
	/**
	 * Merges the separated sections of the array back together
	 * @param low the lowest index of the array
	 * @param mid the index of the middle of the array
	 * @param high the highest index of the array
	 * @param arr the array to merge
	 * @param cb the copy buffer that is the temporary array that holds the sorted values
	 */
	public static void merge(final int low, final int mid, final int high, final Comparable[] arr, final Comparable[] cb) {
		int leftIndex = low;
		int rightIndex = mid + 1;
		
		for (int i = low; i <= high; i++) {
			if (leftIndex <= mid && rightIndex <= high) {
				if (arr[leftIndex].compareTo(arr[rightIndex]) <= 0) { // if leftIndex <= rightIndex, put i1 in cb
					cb[i] = arr[leftIndex];
					leftIndex++;
				} else {
					cb[i] = arr[rightIndex];
					rightIndex++;
				}
			} else if (rightIndex >= high && leftIndex <= mid) { // if leftIndex out of bounds, copy rest of right in
				cb[i] = arr[leftIndex];
				leftIndex++;
			} else if (leftIndex >= mid && rightIndex <= high) { // if rightIndex out of bounds, copy rest of left in
				cb[i] = arr[rightIndex];
				rightIndex++;
			} 
		}
		
		for (int i = 0; i < high + 1; i++) {
			arr[i] = cb[i];
		}
	}
	
	/**
	 * Verifies if the array is sorted in ascending order
	 * @param arr the array to check
	 * @return true if the array is in ascending order, false if not
	 */
	public static boolean verifyOrder(Comparable[] arr) { 
		int size = arr.length;

		if (size == 0 || size == 1) {
			return true;
		} else {
			for (int i = 0; i < size - 1; i++) {
				if (arr[i].compareTo(arr[i + 1]) > 0) {
					return false;
				}
			}
			return true;
		}		
	}

	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "sortData.txt";
		File file = new File (fileName);
		Scanner infile = new Scanner(file);

		// scan file to get the count of integers
		int count = 0;

		while (infile.hasNextInt()) {
			infile.nextInt();
			count++;
		}
		infile.close();

		// reopen file
		infile = new Scanner(new File(fileName));

		// allocate new array
		Integer[] tArray = new Integer[count];
		for (int k = 0; k < tArray.length; k++) {
			tArray[k] = infile.nextInt();
		}

		printArray("before\n", tArray);
		selectionSort(tArray);
//		insertionSort(tArray);
//		mergeSort(tArray);
		printArray("after\n", tArray);
		System.out.println("Is sorted?: " + verifyOrder(tArray));
	}
}