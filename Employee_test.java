
/**
 * Write a description of class Employee_test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Employee_test
{
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args)
    {
        Employee founder = new Employee(182999, "James Dean", "12/2/2008", "Developer");
        Employee engineer = new Employee();
        
        founder.setBoss(founder);
        engineer.setBoss(founder);
        
        assert founder.getID() == 182999;
        assert founder.getName() == "James Dean";
        assert founder.getBoss().equals(founder);
        assert founder.getHireDate() == "12/2/2008";
        assert founder.getCurrentPos() == "Developer";
        
        assert engineer.getBoss().equals(founder);
        assert engineer.getID() == 0;
        assert engineer.getName() == "John Doe";
        assert engineer.getHireDate() == "01/01/2019";
        assert engineer.getCurrentPos() == "programmer";
        
    }
}
