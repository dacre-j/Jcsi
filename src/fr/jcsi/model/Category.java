package fr.jcsi.model;
import java.sql.SQLException;

import	fr.jcsi.bdd.*;

public class Category
{
	private Bdd		dataBase;

	private String	name;
	private String	newName;

	
	public Category(Bdd database)
	{	
		dataBase = database;
	}

	public String toString()
	{
		return "Category instance, name= " + name;
	}
	
	public void create() throws SQLException
	{
		String query = "INSERT INTO  `jcsi`.`category` (`id`, `name`)"
				+ " VALUES (NULL ,  '" + name + "');";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
	}
	
	public void update() throws SQLException
	{
		String query = "UPDATE `jcsi`.`category` SET  "
				+ "`name` =  '" + newName + "'"
				+ " WHERE  `category`.`name`  ='" + name + "'"
				+ " LIMIT 1 ;";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
		
		name = newName;
	}
	
	public void delete() throws SQLException
	{	
		String query = "DELETE FROM `jcsi`.`category` WHERE `category`.`name` = '" + name + "';";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
	}
	
	public String getName()					{return name;}
	public void setName(String name)		{this.name = name;}

	public String getNewName()				{return newName;}
	public void setNewName(String name)		{this.newName = name;}
}
