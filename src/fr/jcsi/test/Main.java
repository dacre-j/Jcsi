package fr.jcsi.test;

import java.sql.SQLException;

import	fr.jcsi.bdd.Bdd;
import	fr.jcsi.model.*;

public class Main
{
	public static void main(String[] args) throws SQLException 
	{
		Bdd dataBase = new Bdd();
		
		unitAll(dataBase);
	}

	public static void unitAll(Bdd dataBase) throws SQLException
	{
		Customer	customer;
		Category	category;
		Product		product;
		Orders		orders;
		
		dataBase.setAddr("jdbc:mysql://localhost/jcsi");
		dataBase.setLogin("root");
		dataBase.setPassword("");
		dataBase.connect();
		
		// CLEAR OLD TESTS dataBase
		dataBase.myQuery("DELETE FROM `jcsi`.`customer`");
		dataBase.myQuery("DELETE FROM `jcsi`.`category`");
		dataBase.myQuery("DELETE FROM `jcsi`.`product`");
		dataBase.myQuery("DELETE FROM `jcsi`.`orders`");
		dataBase.myQuery("DELETE FROM `jcsi`.`ordering`");
		
		customer = unitClient(dataBase);
		category = unitCategory(dataBase);
		product = unitProduct(dataBase, category);
		orders = unitOrder(dataBase, product);
		unitOrdering(dataBase, customer, orders);
	}	
	
	public static Customer	unitClient(Bdd dataBase) throws SQLException
	{
        // CLIENTS
        //// CREATION CLIENT
        Customer client = new Customer(dataBase);
        client.setFname("Francois");
        client.setLname("Clezio");
        client.setLogin("Winter");
        client.setPassword("pomme_de_terre");
        client.setPhone("0836656565");
        client.setAdress("42 rue de la pomme de pin");
        client.create();
        
        //// UPDATE CLIENT
        Customer client2 = new Customer(dataBase);
        client2.setFname("Jeanjean");
        client2.setLname("Dakre");
        client2.setLogin("DeBrevan");
        client2.setPassword("mama");
        client2.setPhone("0642424242");
        client2.setAdress("42 chemin de la noisette oooh");
        client2.create();
        client2.setNewLogin("SuperDeBrevan");
        client2.setNewLname("dacre");
        client2.update();
        
        //// DELETE CLIENT
        Customer client3 = new Customer(dataBase);
        client3.setFname("Jean-Francois");
        client3.setLname("Baltzinger");
        client3.setLogin("Tiks");
        client3.setPassword("papy");
        client3.setPhone("999999999");
        client3.setAdress("2 rue de la fondu");
        client3.create();
        client3.delete();
        
		System.out.print(client.toString());
        return client;
	}
	
	public static Category	unitCategory(Bdd dataBase) throws SQLException
	{
        // CATEGORIES
		//// CREATION DE CATEGORIES
        Category c1 = new Category(dataBase);
        c1.setName("Film");
        c1.create();
        
        //// UPDATE DE CATEGORIES
        Category c2 = new Category(dataBase);
        c2.setName("TESTMUSIQUE");
        c2.create();
        c2.setNewName("Musique");
        c2.update();
        
        //// DELETE DE CATEGORIES
        Category c3 = new Category(dataBase);
        c3.setName("DVD");
        c3.create();
        c3.delete();
        
        System.out.print(c1.toString());
        return c1;
	}
	
	public static Product	unitProduct(Bdd dataBase, Category category) throws SQLException
	{
		// PRODUITS
	    //// CREATION DE PRODUITS
	    Product p1 = new Product(dataBase);
	    p1.setPrice(8);
	    p1.setName("La mort dans l appeau");
	    p1.setDescription("Le nouveau documentaire choc !!!");
	    p1.setCategory(category);
	    p1.create();
	    
	    ////UPDATE DE PRODUITS
	    Product p2 = new Product(dataBase);
	    p2.setPrice(15);
	    p2.setName("Abbat");
	    p2.setDescription("Le nouveau album choc !!!");
	    p2.setCategory(category);
	    p2.create();
	    p2.setNewName("ABBAT");
	    p2.setNewPrice(12);
	    p2.setNewDescription("Le nouveau DVD choc !!!");
	    p2.setNewCategory(category);
	    p2.update();
	    
	    //// DELETE DE PRODUITS
	    Product p3 = new Product(dataBase);
	    p3.setPrice(25);
	    p3.setName("Hairy Potier");
	    p3.setDescription("Le nouveau DVD choc !!!");
	    p3.setCategory(category);
	    p3.create();
	    p3.delete();
	    
		System.out.print(p1.toString());
	    return p1;
	}

	public static Orders	unitOrder(Bdd dataBase, Product product) throws SQLException
	{
		// ORDER
		//// CREATION D'UN ORDER
		Orders o1 = new Orders(dataBase);
		o1.setProductId(product.getId());
		
		Date orderDate = new Date(21, 5, 1987);
		Date deliveryDate = new Date(24, 5, 2011);
		Date orderDate2 = new Date(8, 12, 2011);
		Date deliveryDate2 = new Date(22, 12, 2011);
		
		o1.setOrdersDate(orderDate);
		o1.setDeliveryDate(deliveryDate);
		o1.setQuantity(2);
		o1.create();
		
		////UPDATE D'UN ORDER
		Orders o2 = new Orders(dataBase);
		o2.setProductId(product.getId());
		o2.setOrdersDate(orderDate);
		o2.setDeliveryDate(deliveryDate);
		o2.setQuantity(5);
		o2.create();
		o2.setNewProductId(product.getId());
		o2.setNewOrdersDate(orderDate2);
		o2.setNewDeliveryDate(deliveryDate2);
		o2.setNewQuantity(1);
		o2.update();
		
		////DELETE D'UN ORDER
		Orders o3 = new Orders(dataBase);
		o3.setProductId(product.getId());
		o3.setOrdersDate(orderDate);
		o3.setDeliveryDate(deliveryDate);
		o3.setQuantity(12);
		o3.create();
		o3.delete();

		System.out.print(o1.toString());
		return o1;
	}	

	public static Ordering	unitOrdering(Bdd database, Customer customer, Orders orders) throws SQLException
	{
		// ORDERING
		//// CREATION D'UN ORDERING
		Ordering or1 = new Ordering(database);
		or1.setCustomerId(customer.getId());
		or1.addOrders(orders);
		or1.create();
		
		//// DELETE D'UN ORDERING
		Ordering or2 = new Ordering(database);
		or2.setCustomerId(4242);
		or2.addOrders(orders);
		or2.create();
		or2.delete();
		
		System.out.print(or1.toString());
		return or1;
	}
	
}
