package fr.jcsi.model;
import java.sql.SQLException;

import	fr.jcsi.bdd.*;

public class Orders
{
	private Bdd		dataBase;

	private	int		id;
	private int		customId;
	private int		productId;
	private Date	ordersDate;
	private	Date	deliveryDate;
	private	int		quantity;

	private int		newCustomId;
	private int		newProductId;
	private Date	newOrdersDate;
	private	Date	newDeliveryDate;
	private	int		newQuantity;

	
	public Orders(Bdd database)
	{	
		dataBase = database;
	}
	
	public String toString()
	{
		return "Order instance, customId: " + customId
					+ ", productId: " + productId
					+ ", ordersDate: " + ordersDate.getDate()
					+ ", deliveryDate: " + deliveryDate.getDate()
					+ ", quantity: " + quantity;
	}
	
	public void create() throws SQLException
	{
		String query = "INSERT INTO `jcsi`.`orders` (`id`, `customId`, `productId`, `ordersDate`, `deliveryDate`, `quantity`)" +
				"		 VALUES (NULL, '" + customId + "', '"
						+ productId + "', '"
						+ ordersDate.getDate() + "', '"
						+ deliveryDate.getDate() + "', '"
						+ quantity + "');";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
		
		query = "SELECT `id` FROM `jcsi`.`orders` WHERE `orders`.`customId` = '" + customId + "' AND `orders`.`productId` = '" + productId + "'";
		dataBase.result = dataBase.state.executeQuery(query);
		
		if (dataBase.result.next())
			id = dataBase.result.getInt("id");

	}
	
	public void update() throws SQLException
	{
		String query = "UPDATE `jcsi`.`orders` SET  "
				+ "`customId` =  '" + newCustomId + "'"
				+ ", `productId` = '" + newProductId + "'"
				+ ", `ordersDate` = '" + newOrdersDate.getDate() + "'"
				+ ", `deliveryDate` = '" + newDeliveryDate.getDate() + "'"
				+ ", `quantity` = '" + quantity + "'"
				+ " WHERE  `orders`.`id`  ='" + id + "'"
				+ " LIMIT 1 ;";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
		
		customId = newCustomId;
		productId = newProductId;
		ordersDate = newOrdersDate;
		deliveryDate = newDeliveryDate;
		quantity = newQuantity;
	}
	
	public void delete() throws SQLException
	{	
		String query = "DELETE FROM `jcsi`.`orders` WHERE `orders`.`id` = '" + id + "';";
		System.out.print(query + "\n");
		dataBase.myQuery(query);
	}

	public int getId() {return id;}
	public int getCustomId() {return customId;}
	public int getProductId() {return productId;}
	public Date getOrdersDate() {return ordersDate;}
	public Date getDeliveryDate() {return deliveryDate;}
	public int getQuantity() {return quantity;}

	public void setCustomId(int customId) {this.customId = customId;}
	public void setProductId(int productId) {this.productId = productId;}
	public void setOrdersDate(Date ordersDate) {this.ordersDate = ordersDate;}
	public void setDeliveryDate(Date deliveryDate) {this.deliveryDate = deliveryDate;}
	public void setQuantity(int quantity) {this.quantity = quantity;}

	public int getNewCustomId() {return newCustomId;}
	public int getNewProductId() {return newProductId;}
	public Date getNewOrdersDate() {return newOrdersDate;}
	public Date getNewDeliveryDate() {return newDeliveryDate;}
	public int getNewQuantity() {return newQuantity;}

	public void setNewCustomId(int newCustomId) {this.newCustomId = newCustomId;}
	public void setNewProductId(int newProductId) {this.newProductId = newProductId;}
	public void setNewOrdersDate(Date newOrdersDate) {this.newOrdersDate = newOrdersDate;}
	public void setNewDeliveryDate(Date newDeliveryDate) {this.newDeliveryDate = newDeliveryDate;}
	public void setNewQuantity(int newQuantity) {this.newQuantity = newQuantity;}
}
