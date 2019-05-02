package co.grandcircus;

import java.util.InputMismatchException;
import java.util.Scanner;


public class LabNumber8 {

	public static void main(String[] args) {

		// Alex Nouhan
		// Grand Circus 2019

		// Create scanner and declare variables, parallel arrays

		Scanner scan = new Scanner(System.in);
		boolean go = true;
		boolean go2 = true;

		String[] studentsFull = { "Bob Moog", "Suzanne Ciani", "Don Buchla", "Peter Zinovieff", "Robert Yannes",
				"Phil Dodds" };
		String[] studentsFirst = { "Bob", "Suzanne", "Don", "Peter", "Robert", "Phil" };
		String[] hometown = { "New York, New York", "Quincy, Massachusetts", "South Gate, California", "London, UK",
				"Randor Township, Pennsylvania", "Muncie, Indiana" };
		String[] food = { "Pizza", "Falafel", "Spagetti", "Bangers & Mash", "Coney Dogs", "Lo Mein" };

		// Greet user

		System.out.print(
				"Welcome to our Java class. Which student would you like to learn more about? (enter a number 1-6): ");

		while (go) {

			int userNum = getStuNum(scan);
			int stuNum = userNum - 1;
			

			while (go) {
				System.out.println();
				System.out.println("Student " + userNum + " is " + studentsFull[stuNum]
						+ ". What would you like to know about " + studentsFirst[stuNum] + "?");

				int infoNum = getInfo(scan, "(enter \"hometown\" or \"favorite food\"): ");

				if (infoNum == 1) {
					System.out.println();
					System.out.println(
							studentsFirst[stuNum] + " is from " + hometown[stuNum] + ". Would you like to know more?");
				} else if (infoNum == 2) {
					System.out.println();
					System.out.println(studentsFirst[stuNum] + "'s favorite food is " + food[stuNum]
							+ ". Would you like to know more?");
				}

				int goNum = getGo(scan, "(enter \"yes\" or \"no\" or \"start over\"): ");

				if (goNum == 1) {
					continue;
				} else if (goNum == 2) {
					go = false;
					break;
				} else if (goNum == 3) {
					System.out.println();
					System.out.print("Which student would you like to learn more about? (enter a number 1-6): ");
					break;
				}

			}
		}
		System.out.println();
		System.out.println("Thanks!");

		scan.close();

	}

	public static int getStuNum(Scanner scan) {
		int num = 0;
		boolean b = false;
		while (!b) {
			try {
				num = scan.nextInt();

				if (num > 6 || num < 1) {
					throw new IllegalArgumentException(
							"That student does not exist. Please try again. (enter a number 1-6): ");
				}

			} catch (InputMismatchException e) {
				System.out.println();
				System.out.print("That student does not exist. Please try again. (enter a number 1-6): ");
			} catch (IllegalArgumentException e) {
				System.out.println();
				System.out.print(e.getMessage());
			} catch (Exception e) {
				System.out.println();
				System.out.print("That student does not exist. Please try again. (enter a number 1-6): ");
			} finally {
				scan.nextLine();
				if (num < 7 && num > 0) {
					b = true;
				}
			}
		}
		return num;
	}

	public static int getInfo(Scanner scan, String prompt) {
		String info = "";
		int num = 0;
		while (num == 0) {
			try {
				info = getString(scan, prompt);
			} catch (Exception e) {
				System.out.println("error!");
				scan.nextLine();
			}
			if (info.equalsIgnoreCase("hometown")) {
				num = 1;
			} else if (info.equalsIgnoreCase("favorite")) {
				num = 2;
			} else {
				System.out.println();
				System.out.println("That data does not exist. Please try again.");
				continue;
			}
		}
		return num;
	}

	public static int getGo(Scanner scan, String prompt) {
		String go = "";
		int num = 0;
		while (num == 0) {
			try {
				go = getString(scan, prompt);
			} catch (Exception e) {
				System.out.println("error!");
			}
			if (go.equalsIgnoreCase("yes")) {
				num = 1;
			} else if (go.equalsIgnoreCase("no")) {
				num = 2;
			} else if (go.equalsIgnoreCase("start")) {
				num = 3;
			} else {
				System.out.println();
				System.out.println("Invalid entry.");
				continue;
			}
		}
		return num;
	}

	public static String getString(Scanner sc, String prompt) {
		System.out.print(prompt);
		String s = sc.next(); // read user entry
		sc.nextLine(); // discard any other data entered on the line
		return s;
	}

}
