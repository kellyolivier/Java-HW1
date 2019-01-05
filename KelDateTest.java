
/**
 * Write a description of class KelDateTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KelDateTest
{
    public static void main(String args[])
    {
        KelDate bday = new KelDate(3,30,1998);
        KelDate incorrect = new KelDate(23,23,1923);
        KelDate one = new KelDate(3,1,1998);
        KelDate early = new KelDate (1,1,1);
        
        assert bday.getDay() == 30;
        assert bday.getMonth() == 3;
        assert bday.getYear() == 1998;
        
        assert incorrect.getDay() == 0;
        assert incorrect.getMonth() == 0;
        assert incorrect.getYear() == 0;
        
        assert bday.getTotalDays() == 729390;
        
        assert KelDate.daysBetweenDates(bday, one) == 29;
        assert KelDate.daysBetweenDates(one, bday) == 29;
        
        System.out.println("asserts done");
    }
}
