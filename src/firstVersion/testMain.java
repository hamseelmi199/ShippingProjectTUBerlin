package firstVersion;

import java.util.Scanner;

public class testMain {
	public static void main(String[] args) {

		// Variables
		Scanner input = new Scanner(System.in);
		int amountLaptop = 0;
		int amountMouse = 0;
		int amountDesktop = 0;
		int amountLCDScreen = 0;
		double volumeOrder = 0;
		double weightOrder = 0;
		double volumeBigContainer = 259 * 243 * 1201;
		double volumeSmallContainer = 259 * 243 * 606;
		double amountSmC = 0;
		int amountBiC = 0;
		int totalSC = 0;

		// Input user
		System.out.print("Enter the amount of laptops required\n////  ");
		amountLaptop = input.nextInt();

		System.out.print("Enter the amount of mice required\n////  ");
		amountMouse = input.nextInt();

		System.out.print("Enter the amount of desktops required\n////  ");
		amountDesktop = input.nextInt();

		System.out.print("Enter the amount of LCD screens required\n////  ");
		amountLCDScreen = input.nextInt();

		// Calculations
		volumeOrder = ((double) amountLaptop * (60 * 50 * 50)) + ((double) amountMouse * (30 * 30 * 20))
				+ ((double) amountDesktop * (100 * 150 * 50)) + ((double) amountLCDScreen * (120 * 140 * 80));
		weightOrder = ((double) amountLaptop * 6.5) + ((double) amountMouse * 0.2) + ((double) amountDesktop * 20)
				+ ((double) amountLCDScreen * 2.6);

		// Method
		if ((volumeOrder > volumeSmallContainer) && (volumeOrder <= volumeBigContainer)) {
			amountBiC += 1;
			totalSC += 1800;
		} else if (volumeOrder <= volumeSmallContainer) {
			if (weightOrder < 500) {
				totalSC += 1000;
				amountSmC += 1;
			} else if (weightOrder > 500) {
				totalSC += 1200;
				amountSmC += 1;
			}
		} else {
			amountBiC = Math.floorDiv((int) volumeOrder, (int) volumeBigContainer);
			totalSC += 1800 * amountBiC;

			if ((volumeOrder % volumeBigContainer) * weightOrder < 500) {
				amountSmC += 1;
				totalSC += 1000;
			} else if ((volumeOrder % volumeBigContainer) * weightOrder > 500) {
				totalSC += 1200;
				amountSmC += 1;
			}
			;
		}

		// Output
		System.out.println("The shipping of your order from China to Germany will cost " + totalSC + ",- EUR with "
				+ amountBiC + " big container(s) and " + (int)amountSmC + " small container(s).");

	}
}
