package kpatell.sorting;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SortDataTest {
	
	@Test
	public void testSelectionSortWithNull() {
		Comparable[] tArray = null;
		
		SortData.selectionSort(tArray);
		
		assertArrayEquals(null, tArray);
	}
	
	@Test
	public void testSelectionSortEmpty() {
		Comparable[] tArray = {};
		
		SortData.selectionSort(tArray);
		
		assertArrayEquals(new Comparable[] {}, tArray);
	}
	
	@Test
	public void testSelectionSortOneElement() {
		Comparable[] tArray = {1};
		
		SortData.selectionSort(tArray);
		
		assertArrayEquals(new Comparable[] {1}, tArray);
	}
	
	@Test
	public void testSelectionSortNoSortNeeded() {
		Comparable[] tArray = {1, 2, 3};
		
		SortData.selectionSort(tArray);
		
		assertArrayEquals(new Comparable[] {1, 2, 3}, tArray);
	}
	
	@Test
	public void testSelectionSortSomeElementsSame() {
		Comparable[] tArray = {1, 2, 1};
		
		SortData.selectionSort(tArray);
		
		assertArrayEquals(new Comparable[] {1, 1, 2}, tArray);
	}
	
	@Test
	public void testSelectionSortSortNeeded() {
		Comparable[] tArray = {3, 1, 2, 7, 9};
		
		SortData.selectionSort(tArray);
		
		assertArrayEquals(new Comparable[] {1, 2, 3, 7, 9}, tArray);
	}
	
	@Test
	public void testInsertionSortWithNull() {
		Comparable[] tArray = null;
		
		SortData.insertionSort(tArray);
		
		assertArrayEquals(null, tArray);
	}
	
	@Test
	public void testInsertionSortEmpty() {
		Comparable[] tArray = {};
		
		SortData.insertionSort(tArray);
		
		assertArrayEquals(new Comparable[] {}, tArray);
	}
	
	@Test
	public void testInsertionSortOneElement() {
		Comparable[] tArray = {1};
		
		SortData.insertionSort(tArray);
		
		assertArrayEquals(new Comparable[] {1}, tArray);
	}
	
	@Test
	public void testInsertionSortNoSortNeeded() {
		Comparable[] tArray = {1, 2, 3};
		
		SortData.insertionSort(tArray);
		
		assertArrayEquals(new Comparable[] {1, 2, 3}, tArray);
	}
	
	@Test
	public void testInsertionSortSomeElementsSame() {
		Comparable[] tArray = {1, 2, 1};
		
		SortData.insertionSort(tArray);
		
		assertArrayEquals(new Comparable[] {1, 1, 2}, tArray);
	}
	
	@Test
	public void testInsertionSortSortNeeded() {
		Comparable[] tArray = {3, 1, 2};
		
		SortData.insertionSort(tArray);
		
		assertArrayEquals(new Comparable[] {1, 2, 3}, tArray);
	}
	
	@Test
	public void testMergeSortWithNull() {
		Comparable[] tArray = null;
		
		SortData.mergeSort(tArray);
		
		assertArrayEquals(null, tArray);
	}
	
	@Test
	public void testMergeSortEmpty() {
		Comparable[] tArray = {};
		
		SortData.mergeSort(tArray);
		
		assertArrayEquals(new Comparable[] {}, tArray);
	}
	
	@Test
	public void testMergeSortOneElement() {
		Comparable[] tArray = {1};
		
		SortData.mergeSort(tArray);
		
		assertArrayEquals(new Comparable[] {1}, tArray);
	}
	
	@Test
	public void testMergeSortNoSortNeeded() {
		Comparable[] tArray = {1, 2, 3};
		
		SortData.mergeSort(tArray);
		
		assertArrayEquals(new Comparable[] {1, 2, 3}, tArray);
	}
	
	@Test
	public void testMergeSortSomeElementsSame() {
		Comparable[] tArray = {1, 2, 1};
		
		SortData.mergeSort(tArray);
		
		assertArrayEquals(new Comparable[] {1, 1, 2}, tArray);
	}
	
	@Test
	public void testMergeSortSortNeeded() {
		Comparable[] tArray = {3, 1, 2};
		
		SortData.mergeSort(tArray);
		
		assertArrayEquals(new Comparable[] {1, 2, 3}, tArray);
	}
}