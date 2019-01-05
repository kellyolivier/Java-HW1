import java.util.Date;
import java.util.regex.*;

/**
 * Write a description of class Date here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KelDate
{
    // instance variables - replace the example below with your own
    private int day;
    private int month;
    private int year;
    private final int[] daysPerMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    private static Date date;
    
    /**
     * Constructor for objects of class Date
     */
    public KelDate(int Month, int Day, int Year)
    {
        //set vars
        day = Day;
        month = Month;
        year = Year;
        //check if vars illegal and set null
        if(!this.isValidDate()){        
            day = 0;
            month = 0;
            year = 0;
        }
    }
    
    /**
     * @depricate
     * Constructor for objects of class Date
     */
    public KelDate(int days)
    {
        //find remainder days
        int remainderDays = days % 365;
        
        //find years
        int daysForYears = days - remainderDays;
        
        //find months
        int i;
        int monthCount = 0;
        for(i = 0; i < 12; i++)
        {
            if((remainderDays - daysPerMonth[i]) <= 0)
            {
                break;
            }
            else
            {
               remainderDays = remainderDays - daysPerMonth[i];
               monthCount++;
            }
        }
        
        //set class variables
        day = remainderDays;
        month = monthCount;
        year = (daysForYears / 365);
        
    }
    
    public int getDay()
    {
        return day;
    }
    public int getMonth()
    {
        return month;
    }
    public int getYear()
    {
        return year;
    }
    
    //calculate distance in days between two date objects, using getTotalDay
    public static int daysBetweenDates(KelDate dateOne, KelDate dateTwo)
    {
        int dayTotalOne = dateOne.getTotalDays();
        int dayTotalTwo = dateTwo.getTotalDays();
        
        int diffDays;
        if(dayTotalOne > dayTotalTwo)
        {
            diffDays = dayTotalOne - dayTotalTwo;
        }
        else
        {
            diffDays = dayTotalTwo - dayTotalOne;
        }
        return diffDays;
    }
    
    //make sure date is valid
    private boolean isValidDate(){
        boolean isLeapYear = false;
        if(year % 4 == 0)
        {
            isLeapYear = true;
        }
        
        //upper limit added to year to avoid total days calculations getting really big, since this is based on
        if (day <= 0)
        {
            return false;
        }
        else if(month <=0)
        {
            return false;
        }
        else if(month >12)
        {
            return false;
        }
        else if(year > 4000)
        {
            return false;
        }
        else if (day > daysPerMonth[month - 1] )
        {
            if(month == 2 && day == 28 && isLeapYear)
            {
                return true;
            }
            return false;
        }
        
        return true;
    }
    
    //set date only (not individual setters for day,month and year) because practical application use should require user to know whole goal date
    public void setDate(int newDay, int newMonth, int newYear)
    {
        if(this.isValidDate()){
            day = newDay;
            month = newMonth;
            year = newYear;
        }
    }
    
    //day totals based on 1950 so that numbers aren't too large but can go back pretty far, and dates before then shouldn't really be manipulated that much anyway
    public int getTotalDays()
    {
        //convert years to days
        int days = (this.year) * 365;
        
        //leap year days calculation
        int remainderYears = this.year % 4;
        int yearsForLeap = this.year - remainderYears;
        
        int leapDays = yearsForLeap / 4;
        
        //convert months to days
        for(int i = 0; i <= this.month -1; i++)
        {
            days += daysPerMonth[i];
        }
        
        //add days
        days += this.day;
        
        return days;
    }
    
    //get current date
    public static KelDate getTodaysDate()
    {
        String dateString = date.toString();
        int day = -1;
        String month = "";
        int monthInt = -1;
        int year = -1;

        // reg for day
        Pattern pattern = Pattern.compile(" ([0-9][0-9]) ");
        Matcher matcher = pattern.matcher(dateString);
        if (matcher.find())
        {
           day = Integer.valueOf(matcher.group(1));
        }

        // reg for month
        pattern = Pattern.compile(" ([A-Z][a-z]+) ");
        matcher = pattern.matcher(dateString);
        if (matcher.find())
        {
           month = matcher.group(1);
        }
        // reg for year
        pattern = Pattern.compile(" ([0-9]{4}) ");
        matcher = pattern.matcher(dateString);
        if (matcher.find())
        {
           year = Integer.valueOf(matcher.group(1));
        }

        switch (month)
        {
            case "Jan": monthInt = 0;
            case "Feb": monthInt = 1;
            case "Mar": monthInt = 2;
            case "Apr": monthInt = 3;
            case "May": monthInt = 4;
            case "Jun": monthInt = 5;
            case "Jul": monthInt = 6;
            case "Aug": monthInt = 7;
            case "Sep": monthInt = 8;
            case "Oct": monthInt = 9;
            case "Nov": monthInt = 10;
            case "Dec": monthInt = 11;
        }

        return new KelDate( monthInt +1, day, year);
    }
    
    //makes date n days in future based on current date. Will not take negative numbers
    //date from whatever current date object holds.
    public KelDate moveDateOut(int n)
    {
        //int totalDays = this.getTotalDays();
        
        int currDay = this.day;
        int currMonth = this.month;
        int currYear = this.year;
        
        for(int i = 0; i <n; i++)
        {
            currDay++;
            if(currDay > daysPerMonth[month -1])
            {
                if(currYear % 4 == 0 && currMonth == 2 && currDay == 29)
                {
                    continue;
                }
                currDay = 1;
                currMonth++;
            }
            if(currMonth > 12)
            {
                currDay = 1;
                currMonth =1;
                currYear++;
            }
             
        }
        
        return new KelDate(currMonth, currDay, currYear);
        
    }
}
