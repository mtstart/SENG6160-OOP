import java.util.*;

public class Salary_week4
{
    public static void main (String[] args)
    {
		
		// question2b();

		// question2c_5weeks();

		// String str;
		// int num1 = 13;
		// int num2 = 24;
		// str = "the str is " + num1 + num2;
		// System.out.println(str);
		// System.out.println((int)20.9);

		// int x = 5;
		// int n = 0;
		// boolean found = false;
		// while (!found) {
		// 	System.out.println(n++);
		// 	if (n==x) {
		// 		found = true;
		// 	}
		// }

    }

	private static void question2b () {
        Scanner console = new Scanner(System.in);

		double normal_hours = 40;
		double normal_pays = 10;
		double extra_pays = 15;
        double total_hours, extra_hours, total_salary;
		
        System.out.println("Please Enter total number of working hours: ");
        total_hours = console.nextDouble();
        
		
		if (total_hours <= 40) {
			// handle normal hours
			total_salary = total_hours * normal_pays;
			
		} else {
			// handle extra hours
			extra_hours = total_hours - 40;
			
			// add normal hours salary to total_salary
			total_salary = normal_hours * normal_pays;
			
			// add extra hours salary to total_salary
			total_salary += extra_hours * extra_pays;
						
		}
		
        System.out.println("Total salary is: " + total_salary + "\n");
	}

	private static void question2c_5weeks () {
        Scanner console = new Scanner(System.in);

		double normal_hours = 40;
		double normal_pays = 10;
		double extra_pays = 15;
		// int total_weeks = 5
    	// ArrayList<int> workingHours = new ArrayList<int>();

		// // Get input for 5 weeks
		// for (int i=0; i<5; i++) {
		// 	System.out.println("Please Enter total number of working hours: ");
		// 	workingHours.add(console.nextDouble());
		// }

	}

}
