/* Student.java
Manage a student's name and three test scores.
*/
public class Student {

    //Instance variables
    //Each student object will have a name and three test scores
    private String name;             //Student name
    private int test1;               //Score on test 1
    private int test2;               //Score on test 2
    private int test3;               //Score on test 3

    //Constructor method

    public Student()
    {
    //Initialize a new student's name to the empty string and his test
    //scores to zero.
        name = "";
        test1 = 0;
        test2 = 0;
        test3 = 0;
    }
    
    //Other methods

    //Set a student's name
    public void setName (String nm)
    {
        name = nm;
    }

    //Get a student's name
    public String getName ()
    {
        return name;
    }

    //Set the score on the indicated test
    public void setScore (int i, int score)
    {
        if      (i == 1) test1 = score;
        else if (i == 2) test2 = score;
        else             test3 = score;
    }

    // Get the score on the indicated test
    public int getScore (int i)
    {
        if      (i == 1) return test1;
        else if (i == 2) return test2;
        else             return test3;
    }

    //Compute and return a student's average
   public int getAverage()
    {
        int average;
        average = (int) Math.round((test1 + test2 + test3) / 3.0);
        return average;
    }
  
    //  Method getHighScore
    //  Compute and return a student's highest score

}  




