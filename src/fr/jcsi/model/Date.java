package fr.jcsi.model;

public class Date
{
	private int	year;
	private int	month;
	private int	day;
	
	public Date()
	{	
	}
	
	public String toString()
	{
		return "Date: " + month + "/" + day + "/" + year;
	}

	public String getDate() {return month + "/" + day + "/" + year;}	
	public int getYear() {return year;}
	public int getMonth() {return month;}
	public int getDay() {return day;}

	public void	setDate(int newDay, int newMonth, int newYear)
	{
		day = newDay;
		month = newMonth;
		year = newYear;
	}
	public void setYear(int year) {this.year = year;}
	public void setMonth(int month) {this.month = month;}
	public void setDay(int day) {this.day = day;}
}
