public class Couple
{
    private Person p1,p2;
//--------------------------------------------------------------------------------------
    public Couple()
    {
        p1 = new Person();
        p2 = new Person();
    }
//--------------------------------------------------------------------------------------
    public void addData(int option, String newName, int newAge)
    {
        if (option==1) setData1(p1,newName,newAge);
        else           setData1(p2,newName,newAge);
        
    }
    private void setData1(Person p, String name, int age)
    {
       p.setName(name);
       p.setAge(age);
    }
//--------------------------------------------------------------------------------------    
    public String test()
    {
       if (p1.getAge() < p2.getAge()) return("GOOD FOR "+p2.getName()+"!");
       else                           return("GOOD FOR "+p1.getName()+"!");
    }
}