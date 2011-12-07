package fr.jcsi.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class Bdd
{
	public String           addr;
    public String           login;
    public String           password;
    public Connection       connexion;
    public Statement		state;
    public ResultSet		result;
    
    public void connect()
    {
            try
            {
                    Class.forName("com.mysql.jdbc.Driver");
                    connexion = DriverManager.getConnection(addr, login, password);
                    state = connexion.createStatement();
            
            }
            catch (ClassNotFoundException e)        
            {
            	System.out.println("dbConnect ClassNotFoundException: " + e.toString()); e.printStackTrace();
           	} 
            catch (Exception e) 
            {
            	System.out.println("dbConnect Exception: " + e.toString());    e.printStackTrace();
            }   
    }
    
    public void myQuery(String query) throws SQLException
    {
    	state.executeUpdate(query);
    }
    
    public String getAddr() 						{return addr;}
	public String getLogin() 						{return login;}
	public Connection getConnexion() 				{return connexion;}
	public String getPassword()						{return password;}

	public void setAddr(String addr)	 			{this.addr 		= addr;}
	public void setLogin(String login) 				{this.login 	= login;}	
	public void setPassword(String password) 		{this.password 	= password;}
	public void setConnexion(Connection connexion) 	{this.connexion = connexion;}
}

