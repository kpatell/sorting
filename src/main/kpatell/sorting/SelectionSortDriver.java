package kpatell.sorting;
/**
 * @author Krishan Patel
 * Driver for Selection Sort
 */

import javax.swing.JFrame;

public class SelectionSortDriver {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Sorting");
		frame.setSize(1500, 850);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new SelectionSortPanel());
		frame.setVisible(true);
	}
}