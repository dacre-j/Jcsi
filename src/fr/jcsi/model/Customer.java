package fr.jcsi.model;

import java.sql.SQLException;

import fr.jcsi.bdd.Bdd;

public class Customer 
{
	private Bdd				dataBase;
	private int				id;	
	private String          login;
    private String          password;
    private String          lname;
    private String          fname;
    private String          phone;
    private String          adress;
	private String          newLogin;
    private String          newPassword;
    private String          newLname;
    private String          newFname;
    private String          newPhone;
    private String          newAdress;

    public int getId()		 					{return id;}
    public String getLogin() 					{return login;}
	public String getPassword() 				{return password;}
	public String getLname() 					{return lname;}
	public String getFname() 					{return fname;}
	public String getPhone() 					{return phone;}
	public String getAdress() 					{return adress;}
    public String getNewLogin() 				{return newLogin;}
	public String getNewPassword() 				{return newPassword;}
	public String getNewLname() 				{return newLname;}
	public String getNewFname() 				{return newFname;}
	public String getNewPhone() 				{return newPhone;}
	public String getNewAdress() 				{return newAdress;}
	
	public void setLogin(String login) 			{this.login 	= login;}
	public void setPassword(String password) 	{this.password 	= password;}
	public void setLname(String lname) 			{this.lname 	= lname;}
	public void setFname(String fname) 			{this.fname 	= fname;}
	public void setPhone(String phone)			{this.phone 	= phone;}
	public void setAdress(String adress) 		{this.adress 	= adress;}
	public void setNewLogin(String login) 		{this.newLogin 	= login;}
	public void setNewPassword(String password) {this.newPassword 	= password;}
	public void setNewLname(String lname) 		{this.newLname 	= lname;}
	public void setNewFname(String fname) 		{this.newFname 	= fname;}
	public void setNewPhone(String phone)		{this.newPhone 	= phone;}
	public void setNewAdress(String adress) 	{this.newAdress = adress;}
	
	public Customer(Bdd database)
	{	
		dataBase = database;
	}
	
	public String toString()
	{
		return "Customer instance"
				+ "\n\tlogin: " + login
				+ "\n\tpassword: ****"
				+ "\n\tlname: " + lname
				+ "\n\tfname: " + fname
				+ "\n\tphone: " + phone
				+ "\n\tadress: " + adress
				+ "\n"
				;
	}
	
	public void setCustomer(String _login, String _pwd, String _lname, String _fname, String _phone, String _adress)
	{
		login 		= _login;
		password 	= _pwd;
		lname 		= _lname;
		fname 		= _fname;
		phone 		= _phone;
		adress 		= _adress;
	}
	
	public void create() throws SQLException
	{	
		newLogin = login;
		newPassword = password;
		newLname = lname;
		newFname = fname;
		newPhone = phone;
		newAdress = adress;
		String query = "INSERT INTO `jcsi`.`customer` (`id`, `login`, `password`, `lName`, `fName`, `phone`, `adress`) VALUES (NULL, '"+login+"', '"+password+"', '"+lname+"', '"+fname+"', '"+phone+"', '"+adress+"');";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
		
		query = "SELECT `id` FROM `jcsi`.`customer` WHERE `customer`.`login` = '" + login + "'";
		dataBase.result = dataBase.state.executeQuery(query);
		
		if (dataBase.result.next())
			id = dataBase.result.getInt("id");

	}
	
	public void update() throws SQLException
	{
		String query = "UPDATE  `jcsi`.`customer` SET "
				+ "`login` =  '" + newLogin
				+ "',`password` =  '"+ newPassword
				+ "',`lName` =  '" + newLname
				+"',`fName` =  '" + newFname
				+ "',`phone` =  '" + newPhone
				+ "',`adress` =  '" + newAdress
				+ "' WHERE  `customer`.`id` ='" + id + "' LIMIT 1 ;";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
		
		login = newLogin;
		password = newPassword;
		lname = newLname;
		fname = newFname;
		phone = newPhone;
		adress = newAdress;
	}
	
	public void delete() throws SQLException
	{
		String query = "DELETE FROM `jcsi`.`customer` WHERE `customer`.`id` = '"+ id +"';";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
	}
}
