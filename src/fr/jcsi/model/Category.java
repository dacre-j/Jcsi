package fr.jcsi.model;
import java.sql.SQLException;

import	fr.jcsi.bdd.*;

public class Category
{
	private Bdd		dataBase;

	private int		id;
	private String	name;
	private String	newName;

	
	public Category(Bdd database)
	{	
		dataBase = database;
	}

	public String toString()
	{
		return "Category instance\n\tname: " + name + "\n";
	}
	
	public void create() throws SQLException
	{
		newName = name;
		
		String query = "INSERT INTO  `jcsi`.`category` (`id`, `name`) " +
				"VALUES (NULL ,  '" + name + "');";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
		
		query = "SELECT `id` FROM `jcsi`.`category` WHERE `category`.`name` = '" + name + "'";
		dataBase.result = dataBase.state.executeQuery(query);
		
		if (dataBase.result.next())
			id = dataBase.result.getInt("id");
	}
	
	public void update() throws SQLException
	{
		String query = "UPDATE `jcsi`.`category` SET " +
				"`name` =  '" + newName + "' " +
				"WHERE  `category`.`id`  ='" + id + "' " +
				"LIMIT 1 ;";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
		
		name = newName;
	}
	
	public void delete() throws SQLException
	{	
		String	query = "DELETE FROM `jcsi`.`category` WHERE `category`.`id` = '" + id + "';";

		System.out.print(query + "\n");
		dataBase.myQuery(query);
	}
	
	public boolean	exist() throws SQLException
	{
		String	query;
		
		query = "SELECT `id` FROM `jcsi`.`category` WHERE `category`.`name` = '" + name + "'";
		System.out.print(query + "\n");
		dataBase.result = dataBase.state.executeQuery(query);
		
		if (dataBase.result.next())
		{
			System.out.print("Category exists in dataBase\n");
			return true;
		}
		System.out.print("Category does not exist in dataBase\n");
		return false;
	}
	
	public int getId() {return id;}
	public String getName()					{return name;}
	public void setName(String name)		{this.name = name;}

	public String getNewName()				{return newName;}
	public void setNewName(String name)		{this.newName = name;}
}
