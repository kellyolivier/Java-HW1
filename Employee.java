
/**
 * Write a description of class Employee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Employee
{
   // instance variables - replace the example below with your own
    private int ID;
    private String name;
    private String hireDate;
    private String currentPosition;
    private Employee boss;

    /**
     * Constructor for objects of class Employee
     */
    public Employee()
    {
        initialize(0, "John Doe", "01/01/2019", "programmer");
       
    }
    /**
     * Constructor for objects of class Employee
     */
    public Employee(int empID,String empName, String empHireDate, String empCurrentPos)
    {
        initialize(empID, empName, empHireDate, empCurrentPos);
       
    }
    /**
     * initialization used by constructors
     */
    public void initialize(int empID,String empName, String empHireDate, String empCurrentPos)
    {
        ID= empID;
        name = empName;
        hireDate = empHireDate;
        currentPosition = empCurrentPos;
       
    }
    
    public void setID(int newID)
    {
        ID = newID;
    }
    public void setName(String newName)
    {
        name = newName;
    }
    public void setHireDate(String newHireDate)
    {
        hireDate = newHireDate;
    }
    public void setCurrentPos(String newCurrentPos)
    {
        currentPosition = newCurrentPos;
    }
    public void setBoss(Employee newBoss)
    {
        boss = newBoss;
    }
    
    public int getID()
    {
        return ID;
    }
    public String getName()
    {
        return name;
    }
    public String getHireDate()
    {
        return hireDate;
    }
    public String getCurrentPos()
    {
        return currentPosition;
    }
    public Employee getBoss()
    {
        return boss;
    }
    
}
