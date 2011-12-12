package fr.jcsi.test;

import java.sql.SQLException;

import	fr.jcsi.bdd.Bdd;

public class Main
{
	public static void main(String[] args) throws SQLException 
	{
		Bdd dataBase = new Bdd();
		
		dataBase.setAddr("jdbc:mysql://localhost/jcsi");
		dataBase.setLogin("root");
		dataBase.setPassword("");
		dataBase.connect();
		

	}
}
