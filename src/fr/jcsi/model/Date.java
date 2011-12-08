package fr.jcsi.model;

public class Date
{
	private int	year;
	private int	month;
	private int	day;
	
	public Date()
	{	
	}

	public Date(int sday, int smonth, int syear)
	{	
		day = sday;
		month = smonth;
		year = syear;
	}

	public String toString()
	{
		return "Date: " + day + "/" + month + "/" + year;
	}

	public String getDate() {return day + "/" + month + "/" + year;}	
	public int getYear() {return year;}
	public int getMonth() {return month;}
	public int getDay() {return day;}

	public void setYear(int year) {this.year = year;}
	public void setMonth(int month) {this.month = month;}
	public void setDay(int day) {this.day = day;}
}
