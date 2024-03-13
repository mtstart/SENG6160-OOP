import java.util.*;

public class MidTerm {

	private static int MY_STUDNET_ID = 3423026;

	public static void main(String[] args) {

		q11Task1();
	}

	// This is a reusable function to help get an input in integer type
	// This function validates if the input is a integer, and not empty
	private static int getInputInt(String message) {
		String inputMessage = "Please enter ";
		int inputInt = 0;

		Scanner console = new Scanner(System.in);
		
		System.out.print(inputMessage + message + ": ");
		inputInt = console.nextInt();

		return inputInt;
	}


	private static void q11Task1() {
		// this function verifies my sudent number
		int studentNumber = 0; 	// store as int type

		// ask for student no, without c
		studentNumber = getInputInt("Student number (without the c)");
		
		// check if is my studnet id, using while loop, ask input again.
		while (studentNumber != MY_STUDNET_ID) {
			studentNumber = getInputInt("Student number (without the c)");
		}

		// print student number
		System.out.println("Student Number: " + studentNumber);

		// task 2 is only perform when my student number is inputted
		q11Task2(studentNumber);
	}


	private static void q11Task2(int studentNumber) {
		// This function will perform the following actions:  
		// after verifying my student id
		// 1. ask for number of days i went for walk in last 30 days
		// 2. check if is 30 or less
		// 3. ask for number of days i went for jog in last 30 days
		// 4. check if is 30 or less
		// 5. calculate the probability of walking today: number of walking days / 30
		// 6. calculate the probability of jogging today: number of walking days / 30
		// 7. calculate active index: (jogging days + walking days) / 30 * 100
		// 8. check if probability of active index <= 30, show message "Need to work on it."
		// 9. check if probability of active (index > 30 && index < 60), show message "Keep it up."
		// 10. check if probability of active index > 60, show message "Wonderful work."
		// -- check if user input is a negative number, using while loop, ask input again.

		int walkingDays = 0;
		int joggingDays = 0;

		double activeIndex = 0.0;

		// 1. ask for number of walking days i went for walk in last 30 days
		walkingDays = getInputInt("number of walking days");


		// 2. check if walking days is 30 or less, and not a negative number
		while (walkingDays < 0 || walkingDays > 30) {
			walkingDays = getInputInt("number of walking days");
		}
		System.out.println("Number of walking days in the last 30 days: " + walkingDays);


		// 3. ask for number of days i went for jog in last 30 days
		joggingDays = getInputInt("number of jogging days");


		// 4. check if jogging days is 30 or less, and not a negative number
		while (joggingDays < 0 || joggingDays > 30) {
			joggingDays = getInputInt("number of walking days");
		}
		System.out.println("Number of jogging days in the last 30 days: " + joggingDays);


		// 5. calculate the probability of walking today
		System.out.println("Probability of walking today = " + String.format(" %.2f", (double) walkingDays / 30));

		// 6. calculate the probability of jogging today
		System.out.println("Probability of jogging today = " + String.format(" %.2f", (double) joggingDays / 30));


		// 7. calculate active index
		activeIndex = getActiveIndex(walkingDays, joggingDays);
		System.out.println("Active Index = " + activeIndex);


		// 8, 9, 10. check if active index range
		checkActiveIndex(activeIndex);

	}

	private static double getActiveIndex(int walkingDays, int joggingDays) {
		// 7. calculate active index: (jogging days + walking days) / 30 * 100

		double activeIndex = (walkingDays + joggingDays) / 30 * 100;
		return activeIndex;
	}

	private static void checkActiveIndex(double activeIndex) {
		// 8. check if probability of active index <= 30, show message "Need to work on it."
		// 9. check if probability of active (index > 30 && index < 60), show message "Keep it up."
		// 10. check if probability of active index > 60, show message "Wonderful work."
		
		if (activeIndex <= 30) {
			System.out.println("Need to work on it.");
		} else if (activeIndex > 30 && activeIndex < 60) {
			System.out.println("Keep it up.");
		} else {
			System.out.println("Wonderful work.");
		}

	}
}
