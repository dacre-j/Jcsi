package fr.jcsi.test;

import java.sql.SQLException;

import org.junit.Test;

import fr.jcsi.bdd.Bdd;
import fr.jcsi.model.Category;
import fr.jcsi.model.Customer;
import fr.jcsi.model.Date;
import fr.jcsi.model.Ordering;
import fr.jcsi.model.Orders;
import fr.jcsi.model.Product;

public class MainTest {

	@Test
	public void clearDatabase() throws SQLException 
	{	
		Bdd dataBase = new Bdd();
		dataBase.setAddr("jdbc:mysql://localhost/jcsi");
		dataBase.setLogin("root");
		dataBase.setPassword("");
		dataBase.connect();
		
		dataBase.myQuery("DELETE FROM `jcsi`.`customer`");
		dataBase.myQuery("DELETE FROM `jcsi`.`category`");
		dataBase.myQuery("DELETE FROM `jcsi`.`product`");
		dataBase.myQuery("DELETE FROM `jcsi`.`orders`");
		dataBase.myQuery("DELETE FROM `jcsi`.`ordering`");
	}
	
	@Test
	public void testCustomer() throws SQLException 
	{		
		Bdd dataBase = new Bdd();
		dataBase.setAddr("jdbc:mysql://localhost/jcsi");
		dataBase.setLogin("root");
		dataBase.setPassword("");
		dataBase.connect();
		
		System.out.print("<Test sur les clients>\n\n");
		
        // CLIENTS
        //// CREATION CLIENT
		System.out.print("Creation d'un client:\n");
        Customer client = new Customer(dataBase);
        client.setFname("Francois");
        client.setLname("Clezio");
        client.setLogin("Winter");
        client.setPassWord("pomme_de_terre");
        client.setPhone("0836656565");
        client.setAdress("42 rue de la pomme de pin");
        client.create();
        client.exist();
        
        //// UPDATE CLIENT
		System.out.print("\nModification des caracteristiques d'un client:\n");
		Customer client2 = new Customer(dataBase);
        client2.setFname("Jeanjean");
        client2.setLname("Dakre");
        client2.setLogin("DeBrevan");
        client2.setPassWord("mama");
        client2.setPhone("0642424242");
        client2.setAdress("42 chemin de la noisette oooh");
        client2.create();
        client2.setNewLogin("SuperDeBrevan");
        client2.setNewLname("dacre");
        client2.update();
        client2.exist();
        
        //// DELETE CLIENT
		System.out.print("\nSupression d'un client:\n");
        Customer client3 = new Customer(dataBase);
        client3.setFname("Jean-Francois");
        client3.setLname("Baltzinger");
        client3.setLogin("Tiks");
        client3.setPassWord("papy");
        client3.setPhone("999999999");
        client3.setAdress("2 rue de la fondu");
        client3.create();
        client3.delete();
        
		System.out.print("\n" + client.toString() + "\n\n" + client2.toString()+ "\n\n=======================\n");
	}
	
	@Test
	public void testCategory() throws SQLException 
	{
		Bdd dataBase = new Bdd();
		dataBase.setAddr("jdbc:mysql://localhost/jcsi");
		dataBase.setLogin("root");
		dataBase.setPassword("");
		dataBase.connect();
		
		System.out.print("<Test sur les categories>\n\n");
        // CATEGORIES
		//// CREATION DE CATEGORIES
		System.out.print("Creation d'une categorie:\n");
        Category c1 = new Category(dataBase);
        c1.setName("Film");
        c1.create();
        c1.exist();
        
        //// UPDATE DE CATEGORIES
        System.out.print("\nModification des caracteristiques d'une categorie:\n");
        Category c2 = new Category(dataBase);
        c2.setName("TESTMUSIQUE");
        c2.create();
        c2.setNewName("Musique");
        c2.update();
        c2.exist();
        
        //// DELETE DE CATEGORIES
        System.out.print("\nSupression d'une categorie:\n");
        Category c3 = new Category(dataBase);
        c3.setName("DVD");
        c3.create();
        c3.delete();
        
        System.out.print("\n" +c1.toString()+ "\n\n" + c2.toString()+ "\n\n=======================\n");
	}
	
	@Test
	public void testProduct() throws SQLException 
	{
		Bdd dataBase = new Bdd();
		dataBase.setAddr("jdbc:mysql://localhost/jcsi");
		dataBase.setLogin("root");
		dataBase.setPassword("");
		dataBase.connect();
		
		System.out.print("<Test sur les produits>\n\n");
		
		System.out.print("Creation d'une categorie de test:\n");
        Category category = new Category(dataBase);
        category.setName("Film d action");
        category.create();
		
		// PRODUITS
	    //// CREATION DE PRODUITS
        System.out.print("\nCreation d'un produit:\n");
	    Product p1 = new Product(dataBase);
	    p1.setPrice(8);
	    p1.setName("La mort dans l appeau");
	    p1.setDescription("Le nouveau documentaire choc !!!");
	    p1.setCategory(category);
	    p1.create();
	    p1.exist();
	    
	    ////UPDATE DE PRODUITS
	    System.out.print("\nModification des caracteristiques d'un produit:\n");
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
	    p2.exist();
	    
	    //// DELETE DE PRODUITS
	    System.out.print("\nSupression d'un produit:\n");
	    Product p3 = new Product(dataBase);
	    p3.setPrice(25);
	    p3.setName("Hairy Potier");
	    p3.setDescription("Le nouveau DVD choc !!!");
	    p3.setCategory(category);
	    p3.create();
	    p3.delete();
	    
	    System.out.print("\n" +p1.toString()+ "\n\n" + p2.toString()+ "\n\n=======================\n");
	}
	@Test
	public void testOrders() throws SQLException 
	{
		Bdd dataBase = new Bdd();
		dataBase.setAddr("jdbc:mysql://localhost/jcsi");
		dataBase.setLogin("root");
		dataBase.setPassword("");
		dataBase.connect();
		
	    System.out.print("<Test sur les commandes>\n\n");
		
		System.out.print("Creation d'une categorie de test:\n");
        Category category = new Category(dataBase);
        category.setName("bonbon");
        category.create();
	    
        System.out.print("\nCreation d'un produit de test:\n");
	    Product product = new Product(dataBase);
	    product.setPrice(8);
	    product.setName("fraise");
	    product.setDescription("a la fraise");
	    product.setCategory(category);
	    product.create();
	    
		// ORDER
		//// CREATION D'UN ORDER
	    System.out.print("\nCreation d'une commande:\n");
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
		o1.exist();
		
		////UPDATE D'UN ORDER
		System.out.print("\nModification des caracteristiques d'une commande:\n");
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
		o2.exist();
		
		////DELETE D'UN ORDER
		System.out.print("\nSupression d'une commande:\n");
		Orders o3 = new Orders(dataBase);
		o3.setProductId(product.getId());
		o3.setOrdersDate(orderDate);
		o3.setDeliveryDate(deliveryDate);
		o3.setQuantity(12);
		o3.create();
		o3.delete();

		System.out.print("\n" +o1.toString()+ "\n\n" + o2.toString()+ "\n\n=======================\n");
	}
	
	@Test
	public void testOrdering() throws SQLException 
	{
		Bdd dataBase = new Bdd();
		dataBase.setAddr("jdbc:mysql://localhost/jcsi");
		dataBase.setLogin("root");
		dataBase.setPassword("");
		dataBase.connect();
		
	    System.out.print("<Test sur le panier>\n\n");
		
		System.out.print("Creation d'une categorie de test:\n");
        Category category = new Category(dataBase);
        category.setName("nouriture");
        category.create();
	    
        System.out.print("\nCreation d'un produit de test:\n");
	    Product product = new Product(dataBase);
	    product.setPrice(8);
	    product.setName("tarte aux pommes");
	    product.setDescription("avec des pommes");
	    product.setCategory(category);
	    product.create();
	    
		System.out.print("\nCreation d'un client de test:\n");
        Customer client = new Customer(dataBase);
        client.setFname("David");
        client.setLname("Roger");
        client.setLogin("SuperDavid");
        client.setPassWord("jaime_les_fruits");
        client.setPhone("575875642");
        client.setAdress("23 rue du jus de pomme");
        client.create();
        
	    System.out.print("\nCreation d'une commande de test:\n");
		Orders orders = new Orders(dataBase);
		orders.setProductId(product.getId());
		
		Date orderDate = new Date(21, 5, 1987);
		Date deliveryDate = new Date(24, 5, 2011);
		
		orders.setOrdersDate(orderDate);
		orders.setDeliveryDate(deliveryDate);
		orders.setQuantity(2);
		orders.create();
		
		// ORDERING
		//// CREATION D'UN ORDERING
		System.out.print("\nCreation d'un lien commande-client\n");
		Ordering or1 = new Ordering(dataBase);
		or1.setCustomerId(client.getId());
		or1.addOrders(orders);
		or1.create();
		
		//// DELETE D'UN ORDERING
		System.out.print("\nSupression d'un lien commande-client\n\n");
		Ordering or2 = new Ordering(dataBase);
		or2.setCustomerId(4242);
		or2.addOrders(orders);
		or2.create();
		or2.delete();
		
		System.out.print(or1.toString());
		System.out.print("\n" +or1.toString()+ "\n\n=======================\n");
	}
}
