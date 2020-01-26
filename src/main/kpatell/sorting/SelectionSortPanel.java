package kpatell.sorting;
// Written by: Patrick Sliwinski, Chris Schroeder, John Chapin
// Edited by: Krishan patel

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.util.Random;

public class SelectionSortPanel extends JPanel implements ISortPanel {
	private Integer [] myArray;
	private final int scale = 100;
	private final int delayLength = 300;

	public SelectionSortPanel() {
		// initialize array with random values
		myArray = generateArray();

		// create a sorting object
		SelectionSort sort = new SelectionSort(myArray, this);

		// create thread for sorting
		Thread sortingThread = new Thread(sort);

		// calls the run() method in InsertionSort class
		sortingThread.start();
	}

	/**
	 * calls repaint() to invoke paintComponent(Graphics g) to redraw the array
	 */
	public void updateArray()  {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					repaint();
					
					try {
						Thread.sleep(delayLength);
					} catch (InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		for (int i = 0; i < myArray.length; i++) {
			// set rectangle color based on value in array
			g.setColor(new Color(i * 3, i * 2, i + 100));

			// draw rectangle
			g.fillRect((getWidth() / myArray.length) * i,
					getHeight() - (((getHeight() - 100) / scale) * myArray[i]), (getWidth() / myArray.length) / 2,
					(((getHeight() - 100) / scale) * myArray[i]));

			// draw number on rectangle
			g.drawString(myArray[i] + "", (getWidth() / myArray.length) * i,
					getHeight() - (((getHeight() - 100) / scale) * myArray[i]) - 15);
		}
	}

	/**
	 * Generate a new array that contains random numbers is is properly shuffled.
	 * @return A newly minted array of integers in all kinds of fun random order.
	 */
	private Integer[] generateArray(){
		// set array to random size from 40 to 69 elements
		int size = (int) (Math.random() * 30 + 40);
		System.out.println("size = " + size);

		// initialize array with random values
		Integer newArray[] = new Integer[size];
		for (int i = 0; i < size; i++) {
			newArray[i] = (int) (Math.random() * scale + 1);
		}

		return newArray;
	}
}