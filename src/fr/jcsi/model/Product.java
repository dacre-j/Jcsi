package fr.jcsi.model;

import java.sql.SQLException;

import fr.jcsi.bdd.*;
import fr.jcsi.model.Category;

public class Product
{
	private Bdd			dataBase;
	
	private String		name;
	private String		newName;
	private int			price;
	private int			newPrice;
	private String		description;
	private String		newDescription;
	private Category	category;
	private Category	newCategory;

	public Product(Bdd base)
	{
		dataBase = base;
	}
	
	public String toString()
	{
		return "Product instance, name: " + name + ", price: " + price + ", description: " + description + ", category: " + category;
	}
	
	public void create() throws SQLException
	{
		String query = "INSERT INTO `jcsi`.`product` (`id`, `name`, `category`, `price`, `description`)" +
				"		 VALUES (NULL, '" + name + "', '" + category.getName() + "', '" + price + "', '" + description + "');";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
	}
	
	public void update() throws SQLException
	{
		String query = "UPDATE `jcsi`.`product` SET  "
				+ "`name` =  '" + newName + "'"
				+ ", `price` = '" + newPrice + "'"
				+ ", `description` = '" + newDescription + "'"
				+ ", `category` = '" + newCategory.getName() + "'"
				+ " WHERE  `product`.`name`  ='" + name + "'"
				+ " AND `product`.`description`  ='" + description + "'"
				+ " LIMIT 1 ;";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
		
		name = newName;
		price = newPrice;
		description = newDescription;
		category = newCategory;
	}
	
	public void delete() throws SQLException
	{	
		String query = "DELETE FROM `jcsi`.`product` WHERE `product`.`id` = '" + name + "' AND `product`.`description` = '" + description + "';";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
	}
	
	public void setName(String name) {this.name = name;}
	public void setPrice(int price) {this.price = price;}
	public void setDescription(String description) {this.description = description;}
	public void setCategory(Category category) {this.category = category;}

	public String	getName() {return name;}
	public int 		getPrice() {return price;}
	public String 	getDescription() {return description;}
	public Category getCategory() {return category;}

	public void setNewName(String name) {this.newName = name;}
	public void setNewPrice(int price) {this.newPrice = price;}
	public void setNewDescription(String description) {this.newDescription = description;}
	public void setNewCategory(Category category) {this.newCategory = category;}

	public String	getNewName() {return newName;}
	public int 		getNewPrice() {return newPrice;}
	public String 	getNewDescription() {return newDescription;}
	public Category getNewCategory() {return newCategory;}
}
