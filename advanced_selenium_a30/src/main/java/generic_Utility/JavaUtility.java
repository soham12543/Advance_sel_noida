package generic_Utility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{

	public static int generateRandomNumer() {
		Random random = new Random();
		return random.nextInt(1000);
	}
	
	public String currentdate()
	{
		Date todaydateobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //Month should be capital
		String currentdate=sdf.format(todaydateobj); //Will pick current date  
		return currentdate;
	}
	
	public String newAddedDate(int day)
	{
		Date todaydateobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //Month should be capital
		String currentdate=sdf.format(todaydateobj); //Will pick current date  
		Calendar cal=Calendar.getInstance(); //get instance is static method of Calendor
		cal.setTime(todaydateobj); //pass current date
		int days=30; //No of days to be added
		cal.add(Calendar.DAY_OF_MONTH, days);  //ENUM of day should be passed along with no of days to be added
		Date newDateObj=cal.getTime(); //Get new date object after adding 30 days
		String newDate=sdf.format(newDateObj); //again convert Date object into String format
		return newDate;
	}
	
}
