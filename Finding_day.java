package Calender;

import java.util.Scanner;

public class Finding_day
{
	
	//to find the day of the date we must have 
	//1.century code 2.month code  3.no of leep years 4.add (dd + yy) where yy is last digit of year
	//when add(1,2,3,4) then modules with 7 you get reminder that will be help to find day from week
	
	
	int yearCode;
	int monthCode;
	int day;
	int month;
	int year;
	int oddDays;
	boolean leepYear=false;
	
	public static void main(String[] args) {
		
		
		Finding_day day=new Finding_day();
		while (true)
		{
			Scanner scan=new Scanner(System.in);
			System.out.println(" ");
			System.out.println("");
			System.out.println("choose your choice");
			System.out.println("1. find day");
			System.out.println("2.exit");
			int input = scan.nextInt();
			if (input==1)
			{
				day.getData();
				day.getYearCode();
				day.getMonthCode();
				day.getOddDays();
				day.findDayNo();
				day.dayName();
			}
			if (input==2)
			{
				System.out.println("Thank you.....");
				System.exit(input);
			}
		}
		
		
		
	}
	
	//geting date
	
	public void getData()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter your year in YYYY");
		 year = scan.nextInt();
		// yearn=year;
		
		if (year%4==0 || year%400==0 && year%100!=0 )
		{
			
			 leepYear=true;
		}
		else 
		{
			
			leepYear=false;
		}
		System.out.println("enter your month in MM");
		int monthTemp=scan.nextInt();
		if (monthTemp>0 && monthTemp<=12)
		{
			month=monthTemp;
		}
		else
		{
			System.out.println("enter invalid month");
		}
		
		System.out.println("enter your day");
		int dayTemp=scan.nextInt();
		if (month==2 && leepYear==true)
		{
			if (dayTemp>0 && dayTemp<=29)
			{
				day=dayTemp;
			}
			else 
			{
				System.out.println("it is a leep year and day should be less than or equal to 29");
			}
		}
		else if(month==2 && leepYear==false){
			if (dayTemp>0 && dayTemp<=28)
			{
				day=dayTemp;
			}
			else 
			{
				System.out.println("entered a invalid day.this month contains only 28 days");
			}
		}
		else if (month==4 || month==6 || month==9|| month==11) {
			if (dayTemp>0 && dayTemp<=30)
			{
				day=dayTemp;
			}
			else 
			{
				System.out.println("enterd invalid day. This month contains only 30 days");
			}
		}
		else
		{
			if (dayTemp>0 && dayTemp<=31)
			{
				day=dayTemp;
				
			}
			else 
			{
				System.out.println("entered invalid date. this month contains 31 days");
			}
		}
		
		
		
		
		
	}

	
	//getting year code 
	
	public int getYearCode()
	{

		int year2=year;
		int temp=0;
		 yearCode=6;
		while ( temp<year)
		{
			
			temp=temp+100;
			if (temp<=year)
			{
				yearCode=yearCode-2;
				if (yearCode<0)
				{
					yearCode=6;
				}
				//System.out.println(" inside year code "+ temp +"    "+yearCode);
			}
		}
		
		System.out.println(" year code "+ yearCode);
		return yearCode;
		
		
		
	}
	
	
	//month code 
	
	public int getMonthCode()
	{
		switch (month)
		{
		case 1 :  monthCode=0;
					break;
		case 2 : monthCode=3;
					break;
		case 3 : monthCode=3;
					break;
		case 4 : monthCode= 6;
					break;
		case 5 : monthCode = 1;
					break;
		case 6 : monthCode=4;
					break;
		case 7 : monthCode=6;
					break;
		case 8 : monthCode=2;
					break;
		case 9 : monthCode=5;
					break;
		case 10 : monthCode=0;
					break;
		case 11 : monthCode=3;
					break;
		case 12 : monthCode=5;
					break;
		}
		
		//System.out.println("month code "+ monthCode);
		return monthCode;

	}
	
	public int getOddDays()
	{
		int temp22 = year;
		int lastTwo=temp22%100;
		int sum=lastTwo+day;
		
		int NoOfLeepYear=lastTwo/4;
		
		oddDays=sum+NoOfLeepYear+monthCode+yearCode;
		
		return oddDays;
	}
	
	int dayNo;
	public int findDayNo()
	{
		 dayNo = oddDays%7;
		 
		if (dayNo>7)
		{
			
			return dayNo=dayNo-7;
		}
		else
		{
			return dayNo;
		}
	}
	String name;
	public void dayName()
	{
		
		switch (dayNo) {
		case 0: name="sunday";
		         break;
		case 1: name="monday";
				break;
		case 2: name="tuesday";
				break;
		case 3: name="wednesday";
				break;
		case 4: name="thursday";
				break;
		case 5: name="friday";
				break;
		case 6: name="saturday";
				break;
		case 7: name="sunday";
			    break;
			    }
		System.out.println(day+"/"+ month+"/"+ year +" is a "+ name);
	}
	
	
}
	
	
	




