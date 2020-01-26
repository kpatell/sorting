package kpatell.sorting;
/**
 * Insertion sort
 * @author Krishan Patel
 */

public class InsertionSort implements Runnable {
	Integer[] sortArray;
	ISortPanel panel;

	public InsertionSort(Integer[] anArray, ISortPanel aPanel) {
		sortArray = anArray;
		panel = aPanel;
	}

	public void run() {		
		for (int i = 1; i < sortArray.length; i++) {
			while (i > 0 && sortArray[i] < sortArray[i - 1]) {
				int temp = sortArray[i];
				sortArray[i] = sortArray[i - 1];
				sortArray[i - 1] = temp;
				i--;
				
				// Displays the whole array - put after a change is made
				panel.updateArray();
			}
		}
	}
}