import java.util.Scanner;
import javax.swing.JOptionPane;	// this for GUI input/ output

public class Draft {
	public static void main(String[] args) {
		// int num = 0;
		// System.out.print(num);

		// sampleQ1();

		// sampleQ2();

		// sampleQ3();

		// sampleQ4();
		if(5 > 4 +3)
			System.out.println("111");	// this can't be shown
			System.out.println("222");	// only this can be shown
	}

	// Shared Functions -------------------------------------------------------------------

	private void printMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
	}

	private boolean isNumber(String s) {
		for (int i = 0; i < s.length(); i++)
			if (Character.isDigit(s.charAt(i)) == false) {
				return false;
			}
		return true;
	}

	// This is a reusable function to help get an input in double type
	// This function validates if the input is a double, and not empty
	private double getInputDouble(String message) {
		String inputMessage = "Please enter ";
		String inputString = "";
		double inputDouble = 0.0;
		
		// get input
		inputString = JOptionPane.showInputDialog(inputMessage + message + ": ");

		// clean input
		inputString = inputString.trim();
		
		// check if the input is a double
		// using the replace function below removes the decimal point charcter from input,
		// in order to check if all characters in the input are numeric
		while (!isNumber(inputString.replace(".", "")) || inputString.equals("")) {
			inputString = JOptionPane.showInputDialog(inputMessage + "a valid " + message + ": ");
		}

		// parse input into double
		inputDouble = Double.parseDouble(inputString);

		return inputDouble;
	}

	// This is a reusable function to help get an input in integer type
	// This function validates if the input is a integer, and not empty
	private int getInputInt(String message) {
		String inputMessage = "Please enter ";
		String inputString = "";
		int inputInt = 0;
		
		// get input
		inputString = JOptionPane.showInputDialog(inputMessage + message + ": ");

		// clean input
		inputString = inputString.trim();
		
		// check if the input is a integer
		while (!isNumber(inputString) || inputString.equals("")) {
			inputString = JOptionPane.showInputDialog(inputMessage + "a valid " + message);
		}

		// parse input into integer
		inputInt = Integer.parseInt(inputString);

		return inputInt;
	}

	// This is a reusable function to help get an input in string type
	// This function validates if the input is not empty
	private String getInputString(String message) {
		String inputMessage = "Please enter ";
		String inputString = "";

		// get input
		inputString = JOptionPane.showInputDialog(inputMessage + message + ": ");

		while (inputString.equals("")) {
			inputString = JOptionPane.showInputDialog(inputMessage + "a valid " + message);
		}

		// clean the input
		inputString = inputString.trim().toLowerCase();

		return inputString;
	}

	// end of Shared Functions ------------------------------------------------------------


	private static void sampleQ1() {
		Scanner console = new Scanner(System.in);
		double charge_less_than_10 = 1.2;
		double charge_10_more = 1.0;
		double discount_for_50 = (1 - 0.1);

		int numOfSongs = 0;
		double total = 0;

		do {
			System.out.print("Please enter number of songs (must be a positive number): ");
			numOfSongs = console.nextInt();
		} while (numOfSongs < 0);

		// calculate total amount with corresponding charges
		if (numOfSongs < 10) {
			total = numOfSongs * charge_less_than_10;
		} else {
			total = numOfSongs * charge_10_more;
		}

		// handle discount when the number of songs is more than 50
		if (numOfSongs > 50) {
			total = total * discount_for_50;
		}

		System.out.println("The total amount due is " + total);

		/*
		 * ask for numOfSongs
		 * output total amount
		 * 
		 * if numOfSongs < 10: charge = 1.2
		 * if numOfSongs >= 10: charge = 1.0
		 * 
		 * if numOfSongs > 50: total = total * 0.9
		 * 
		 */

	}

	private static void sampleQ2() {
		Scanner console = new Scanner(System.in);

		double connectionFee = 2.0;
		double charge_first_3 = 1.2;
		double charge_additional = 0.25;
		double total = 0;

		int numOfCalls = 0;

		// add connection fee into total amount
		total += connectionFee;

		// ask for number of calls
		System.out.print("Please enter number of calls: ");
		numOfCalls = console.nextInt();

		// for the number of calls, ask for the number of mins the call lasted
		for (int i = 1; i <= numOfCalls; i++) {

			// ask for call duration
			double callDuration = 0;
			System.out.printf("Please enter the number of mins call %d lasted: ", i);
			callDuration = console.nextDouble();
		

			// handle first three mins
			if (callDuration < 3) {
				total += callDuration * charge_first_3;
			} else {	// handle any additional mins

				// add the first 3 mins to total amount
				total += 3 * charge_first_3;

				// add the remaining mins to total amount
				total += (callDuration - 3) * charge_additional;

			}
			
		}

		System.out.println("The total amount due is " + total);

	}

	private static void sampleQ3() {
		Scanner console = new Scanner(System.in);

		int n = 0;
		double total = 0;
		
		// ask for a number n
		System.out.print("Please enter a number");
		n = console.nextInt();

		// only accept number larger than 0, and even number
		while (n < 0 || (n % 2 != 0)) {
			System.out.print("Please enter number a even number larger than 0: ");
			n = console.nextInt();
		}

		// start calculation
		for (int i=2; i < n; i+=2) {
			total += n / (n = 1);
		}

		System.out.println("The total is " + total);
	}

	private static void sampleQ4() {
		Scanner console = new Scanner(System.in);

		int n = 0;
		double total = 0;
		
		// ask for a number n
		System.out.print("Please enter a number: ");
		n = console.nextInt();
		
		// only accept number larger than 0, and odd number
		while (n < 0 || (n % 2 != 1)) {
			System.out.print("Please enter number a odd number larger than 0: ");
			n = console.nextInt();
		}

		// start calculation
		for (int i=1; i <= n; i+=2) {
			int sum = 1;
			
			for (int j = 1; j <= i; j++) {
				sum *= j;
			}

			total += sum;
		}

		System.out.println("The total is " + total);
	}

	private static void sampleQ5() {
		Fruit p = new Fruit();

		// Q5bi
		p.setQtd(30);
		// as qtd variable is set as an private variable in class Fruit, it cannot be reached in class Store.
		// therfore, we need to use the public method to make changes on the private variable.


		// Q5bii
		System.out.println(p.getPrice());
		// yes, as it is a public method

	}
	
	// Student Class ------------------------------------------------------------------------
	
	// public class Student {
	// 	private int id;
	// 	public String name;		
	// }

	// public class StudentInterface {
	// 	public static void main(String args[]){
	// 		Student MITStudent = new Student();
	// 		MITStudent.id=100;
	// 		MITStudent.name="Bill";
	// 		System.out.println(" Student Name:" + MITStudent.name);
	// 		}
	// }


	// end of Student Class ------------------------------------------------------------------------

	private static void mcQ2() {

		int count = 2;

		while (count <= 20) {

			if (count % 4 == 1)

				continue;

			System.out.println(" * ");

			++count;

		} // end while

	} // end main

	// private static void mcQ3() {
	// 	for ( int i = 7; i <= 77; i ++7 ) {
	// 		System.out.println("ok");
	// 	}
	// }

	// private static void mcQ6() {
	// boolean teste1 = (smallNumber<5) && (4%2 ==0) &&(6>5);
	// }

	private static void mcQ7() {
		int x = 9;

		if (x !=9) {

			x = 8;

			System.out.println(x); 

			x--;

		} //end If
	}

}
