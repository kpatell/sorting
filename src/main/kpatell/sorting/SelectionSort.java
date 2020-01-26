package kpatell.sorting;
/**
 * Selection sort
 * @author Krishan Patel
 */

public class SelectionSort implements Runnable {
	Integer[] sortArray;
	ISortPanel panel;

	public SelectionSort(Integer[] anArray, ISortPanel aPanel) {
		sortArray = anArray;
		panel = aPanel;
	}
	
	public void run() {		
		for (int i = 0; i < sortArray.length; i++) {
			int min = i;
			for (int j = i + 1; j < sortArray.length; j++) {
				if (sortArray[j].compareTo(sortArray[min]) < 0) {
					min = j;
				}
			}
			Integer temp = sortArray[i];
			sortArray[i] = sortArray[min];
			sortArray[min] = temp;
			
			// Displays the whole array - put after a change is made
			panel.updateArray();
		}
	}
}