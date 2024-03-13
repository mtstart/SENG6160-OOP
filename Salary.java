import java.util.*;

public class Salary
{
    public static void main (String[] args)
    {
        Scanner console = new Scanner(System.in);
        double total_hours = 0;
		double total_salary = 0;
		double extra_hours = 0;
		
		double normal_hours = 40;
		double normal_payrate = 10;
		double extra_payrate = 15;
		
        System.out.println("Please Enter number of normal hours: ");
        total_hours = console.nextDouble();
		
		if (total_hours < normal_hours) {
			total_salary = total_hours * normal_payrate;			
		} else {
			extra_hours = total_hours - normal_hours;
			total_salary = (normal_hours * normal_payrate) + extra_hours * extra_payrate;
		}
		        
		
        System.out.println("Total salary is: " + total_salary);
    }
}
