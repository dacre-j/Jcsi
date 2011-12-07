package fr.jcsi.model;
import java.sql.SQLException;

import	fr.jcsi.bdd.*;

public class Order
{
	private Bdd		dataBase;

	private int		customId;
	private int		productId;
	private Date	orderDate;
	private	Date	delivaryDate;
	private	int		quantity;

	private int		newCustomId;
	private int		newProductId;
	private Date	newOrderDate;
	private	Date	newDelivaryDate;
	private	int		newQuantity;

	
	public Order(Bdd database)
	{	
		dataBase = database;
	}
	
	public String toString()
	{
		return "Product instance, customId: " + customId
					+ ", productId: " + productId
					+ ", orderDate: " + orderDate.getDate()
					+ ", delivaryDate: " + delivaryDate.getDate()
					+ ", quantity: " + quantity;
	}
	
	public void create() throws SQLException
	{
		String query = "INSERT INTO `jcsi`.`order` (`id`, `customId`, `productId`, `orderDate`, `delivaryDate`, `quantity`)" +
				"		 VALUES (NULL, '" + customId + "', '"
						+ productId + "', '"
						+ orderDate.getDate() + "', '"
						+ delivaryDate.getDate() + "', '"
						+ quantity + "');";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
	}
	
	public void update() throws SQLException
	{
		String query = "UPDATE `jcsi`.`order` SET  "
				+ "`customId` =  '" + newCustomId + "'"
				+ ", `productId` = '" + newProductId + "'"
				+ ", `orderDate` = '" + newOrderDate.getDate() + "'"
				+ ", `delivaryDate` = '" + newDelivaryDate.getDate() + "'"
				+ ", `quantity` = '" + quantity + "'"
				+ " WHERE  `product`.`customId`  ='" + customId + "'"
				+ " AND `product`.`productId`  ='" + productId + "'"
				+ " LIMIT 1 ;";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
		
		customId = newCustomId;
		productId = newProductId;
		orderDate = newOrderDate;
		delivaryDate = newDelivaryDate;
		quantity = newQuantity;
	}
	
	public void delete() throws SQLException
	{	
		String query = "DELETE FROM `jcsi`.`product` WHERE `order`.`customId` = '" + customId + "' AND `product`.`productId` = '" + productId + "';";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
	}

	public int getCustomId() {return customId;}
	public int getProductId() {return productId;}
	public Date getOrderDate() {return orderDate;}
	public Date getDelivaryDate() {return delivaryDate;}
	public int getQuantity() {return quantity;}

	public void setCustomId(int customId) {this.customId = customId;}
	public void setProductId(int productId) {this.productId = productId;}
	public void setOrderDate(Date orderDate) {this.orderDate = orderDate;}
	public void setOrderDate(int day, int month, int year) {this.orderDate.setDate(day, month, year);}
	public void setDelivaryDate(Date delivaryDate) {this.delivaryDate = delivaryDate;}
	public void setDelivaryDate(int day, int month, int year) {this.delivaryDate.setDate(day, month, year);}
	public void setQuantity(int quantity) {this.quantity = quantity;}

	public int getNewCustomId() {return newCustomId;}
	public int getNewProductId() {return newProductId;}
	public Date getNewOrderDate() {return newOrderDate;}
	public Date getNewDelivaryDate() {return newDelivaryDate;}
	public int getNewQuantity() {return newQuantity;}

	public void setNewCustomId(int newCustomId) {this.newCustomId = newCustomId;}
	public void setNewProductId(int newProductId) {this.newProductId = newProductId;}
	public void setNewOrderDate(Date newOrderDate) {this.newOrderDate = newOrderDate;}
	public void setNewOrderDate(int day, int month, int year) {this.newOrderDate.setDate(day, month, year);}
	public void setNewDelivaryDate(Date newDelivaryDate) {this.newDelivaryDate = newDelivaryDate;}
	public void setNewDelivaryDate(int day, int month, int year) {this.newDelivaryDate.setDate(day, month, year);}
	public void setNewQuantity(int newQuantity) {this.newQuantity = newQuantity;}
}
