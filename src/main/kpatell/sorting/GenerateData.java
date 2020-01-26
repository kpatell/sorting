package kpatell.sorting;
/**
 * @author Krishan Patel
 * Generates Data
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class GenerateData {
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "sortData.txt";
		File file = new File (fileName);
		PrintWriter outfile = new PrintWriter(file);

		Scanner input = new Scanner(System.in);
		System.out.print("Number of integers: ");
		int num = input.nextInt();

		for (int k = 0; k < num; k++) {
			int x = (int)(Math.random() * num * 10);
			outfile.println("" + x);
		}
		outfile.close();
	}
}