package com.lab1;

import java.util.Scanner;

public class ThreeVariablesCalculator {

	public static double calculateDet(double[][] matrix) {
		return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[2][1] * matrix[1][2])
				- matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
				+ matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
	}

	// using cramer's rule to solve
	public static void slove(double[][] req) {

		double d[][] = { { req[0][0], req[0][1], req[0][2] }, { req[1][0], req[1][1], req[1][2] },
				{ req[2][0], req[2][1], req[2][2] }, };

		double d1[][] = { { req[0][3], req[0][1], req[0][2] }, { req[1][3], req[1][1], req[1][2] },
				{ req[2][3], req[2][1], req[2][2] }, };

		double d2[][] = { { req[0][0], req[0][3], req[0][2] }, { req[1][0], req[1][3], req[1][2] },
				{ req[2][0], req[2][3], req[2][2] }, };

		double d3[][] = { { req[0][0], req[0][1], req[0][3] }, { req[1][0], req[1][1], req[1][3] },
				{ req[2][0], req[2][1], req[2][3] }, };

		double det = calculateDet(d);
		double det1 = calculateDet(d1);
		double det2 = calculateDet(d2);
		double det3 = calculateDet(d3);

		if (det != 0) {
			double x = det1 / det;
			double y = det2 / det;
			double z = det3 / det;
			System.out.println("X = " + x);
			System.out.println("Y = " + y);
			System.out.println("Z = " + z);
		} else {
			if (det1 == 0 && det2 == 0 && det3 == 0) 
				System.out.println("Phuong trinh vo so nghiem");
			else 
				System.out.println("Phuong trinh vo nghiem");
		}
	}

	public static double[][] getInput(Scanner sc) {
		double[][] matrix = new double[3][4];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				matrix[i][j] = Double.parseDouble(sc.next());
			}
			sc.nextLine();
		}
		sc.close();

		return matrix;
	}

	public static void main(String[] args) {
		double[][] req = getInput(new Scanner(System.in));
		slove(req);
	}

}
