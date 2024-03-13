import java.util.*;

public class AgencyInterface 
{ 
    private void run() 
    {
       Scanner console = new Scanner(System.in);
       Couple c = new Couple();
       int      age,end;
       String   name;
       
       do {
           System.out.print("first person: "); 
           System.out.print("name: "); 
           name = console.next();
           System.out.print("age: "); 
           age = console.nextInt();
           c.addData(1,name,age);

           System.out.print("second person: "); 
           System.out.print("name: "); 
           name = console.next();
           System.out.print("age: "); 
           age = console.nextInt();
           c.addData(2,name,age);

           System.out.println("********************");
           System.out.println(c.test());           
           System.out.println("********************");
           System.out.print("Quit? (0)yes (1)no: "); 
           end = console.nextInt();
           }
       while (end!=0);
    }
    public static void main(String[] args)
    {
           AgencyInterface agency = new AgencyInterface ();
           agency.run();
    }
    public int inputAge()
    {
            // add the code here to receive an integer number as input and 
            // check if the number is greater or equal to 18
            // if the number is less than 18, the program should ask the number again
            // until the input number is greater or equal to 18
            return(0);//note that 0 was added here just to be able to compile
    }

    }