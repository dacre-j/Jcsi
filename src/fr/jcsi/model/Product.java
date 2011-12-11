package fr.jcsi.model;

import java.sql.SQLException;

import fr.jcsi.bdd.*;
import fr.jcsi.model.Category;

public class Product
{
	private Bdd			dataBase;
	
	private int			id;	
	private String		name;
	private int			price;
	private String		description;
	private Category	category;

	private String		newName;
	private int			newPrice;
	private String		newDescription;
	private Category	newCategory;

	public Product(Bdd base)
	{
		dataBase = base;
	}
	
	public String toString()
	{
		return "Product instance"
				+ "\n\tname: " + name
				+ "\n\tprice: " + price
				+ "\n\tdescription: " + description
				+ "\n\tcategory:\n" + category
				+ "\n";
	}
	
	public void create() throws SQLException
	{
		String query = "INSERT INTO `jcsi`.`product` (`id`, `name`, `category`, `price`, `description`)" +
				"		 VALUES (NULL, '" + name + "', '" + category.getName() + "', '" + price + "', '" + description + "');";
		System.out.print(query + "\n");
		dataBase.myQuery(query);

		query = "SELECT `id` FROM `jcsi`.`product` WHERE `product`.`name` = '" + name + "' AND `product`.`description` = '" + description + "'";
		dataBase.result = dataBase.state.executeQuery(query);
		
		if (dataBase.result.next())
			id = dataBase.result.getInt("id");
	}
	
	public void update() throws SQLException
	{
		String query = "UPDATE `jcsi`.`product` SET  "
				+ "`name` =  '" + newName + "'"
				+ ", `price` = '" + newPrice + "'"
				+ ", `description` = '" + newDescription + "'"
				+ ", `category` = '" + newCategory.getName() + "'"
				+ " WHERE  `product`.`id`  ='" + id + "'"
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
		String query = "DELETE FROM `jcsi`.`product` WHERE `product`.`id` = '" + id + "';";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
	}
	
	public void setName(String name) {this.name = name;}
	public void setPrice(int price) {this.price = price;}
	public void setDescription(String description) {this.description = description;}
	public void setCategory(Category category) {this.category = category;}

	public int		getId()	{return id;}
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
