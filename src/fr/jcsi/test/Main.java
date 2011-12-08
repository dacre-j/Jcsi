package fr.jcsi.test;

import java.sql.SQLException;

import	fr.jcsi.bdd.Bdd;
import	fr.jcsi.model.*;

public class Main
{
	public static void main(String[] args) throws SQLException 
	{
		Bdd database = new Bdd();
		database.setAddr("jdbc:mysql://localhost/jcsi");
		database.setLogin("root");
		database.setPassword("");
		database.connect();
		
		// CLEAR OLD TESTS DATABASE
		database.myQuery("DELETE FROM `jcsi`.`category`");
		database.myQuery("DELETE FROM `jcsi`.`product`");
		database.myQuery("DELETE FROM `jcsi`.`orders`");
		
		
        // CATEGORIES
		//// CREATION DE CATEGORIES
        Category c1 = new Category(database);
        c1.setName("Film");
        c1.create();
        
        //// UPDATE DE CATEGORIES
        Category c2 = new Category(database);
        c2.setName("TESTMUSIQUE");
        c2.create();
        c2.setNewName("Musique");
        c2.update();
        
        //// DELETE DE CATEGORIES
        Category c3 = new Category(database);
        c3.setName("DVD");
        c3.create();
        c3.delete();
        
        
        // PRODUITS
        //// CREATION DE PRODUITS
        Product p1 = new Product(database);
        p1.setPrice(8);
        p1.setName("La mort dans l appeau");
        p1.setDescription("Le nouveau documentaire choc !!!");
        p1.setCategory(c1);
        p1.create();
        
        ////UPDATE DE PRODUITS
        Product p2 = new Product(database);
        p2.setPrice(15);
        p2.setName("Abbat");
        p2.setDescription("Le nouveau album choc !!!");
        p2.setCategory(c1);
        p2.create();
        p2.setNewName("ABBAT");
        p2.setNewPrice(12);
        p2.setNewDescription("Le nouvel album choc !!!");
        p2.setNewCategory(c2);
        p2.update();
        
        //// DELETE DE CATEGORIES
        Product p3 = new Product(database);
        p3.setPrice(25);
        p3.setName("Hairy Potier");
        p3.setDescription("Le nouveau DVD choc !!!");
        p3.setCategory(c1);
        p3.create();
        p3.delete();
        
        
        // ORDER
        //// CREATION D'UN ORDER
        Orders o1 = new Orders(database);
        o1.setCustomId(124);
        o1.setProductId(12);
        
        Date orderDate = new Date(21, 5, 1987);
        Date deliveryDate = new Date(24, 5, 2011);
        Date orderDate2 = new Date(8, 12, 2011);
        Date deliveryDate2 = new Date(22, 12, 2011);
        
        o1.setOrdersDate(orderDate);
        o1.setDeliveryDate(deliveryDate);
        o1.setQuantity(2);
        o1.create();
        
        ////UPDATE D'UN ORDER
        Orders o2 = new Orders(database);
        o2.setCustomId(123);
        o2.setProductId(22);
        o2.setOrdersDate(orderDate);
        o2.setDeliveryDate(deliveryDate);
        o2.setQuantity(2);
        o2.create();
        o2.setNewCustomId(121);
        o2.setNewProductId(23);
        o2.setNewOrdersDate(orderDate2);
        o2.setNewDeliveryDate(deliveryDate2);
        o2.setNewQuantity(1);
        o2.update();
        
        ////DELETE D'UN ORDER
        Orders o3 = new Orders(database);
        o3.setCustomId(13);
        o3.setProductId(222);
        o3.setOrdersDate(orderDate);
        o3.setDeliveryDate(deliveryDate);
        o3.setQuantity(12);
        o3.create();
        o3.delete();
	}
}
