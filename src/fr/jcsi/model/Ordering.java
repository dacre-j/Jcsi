package fr.jcsi.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import fr.jcsi.bdd.Bdd;

public class Ordering
{
	private Bdd				dataBase;

	private int				customerId;
	private List<Orders>	orders;
		
	public	Ordering(Bdd database)
	{
		dataBase = database;
		orders = new ArrayList<Orders>();
	}
	
	public String toString()
	{
		Iterator<Orders>	it = orders.iterator();
		String				string;
		Orders				curr;
		
		string = "Ordering instance" +
				"\n\tcustomerId: " + customerId;		
		while (it.hasNext())
		{
			curr = it.next();				
			string += "\n\torders:\n" + curr;
		}
		string += "\n";
		return string;
	}
	
	public void	create() throws SQLException
	{
		String				query;
		Iterator<Orders>	it = orders.iterator();
		Orders				curr;
		
		while (it.hasNext())
		{
			curr = it.next();
			query = "INSERT INTO `jcsi`.`ordering` (`id`, `customerId`, `ordersId`) " +
					"VALUES (NULL, " +
					"'" + customerId + "', " +
					"'" + curr.getId() + "');";
			System.out.print(query + "\n");
			dataBase.myQuery(query);
		}
	}
		
	public void delete() throws SQLException
	{	
		String				query;
		Iterator<Orders>	it = orders.iterator();
		Orders				curr;
		
		while (it.hasNext())
		{
			curr = it.next();
			query = "DELETE FROM `jcsi`.`ordering` " +
					"WHERE `ordering`.`customerId` = '" + customerId + "' " +
					"AND `ordering`.`ordersId` = '" + curr.getId() + "'" +
					";";
			System.out.print(query + "\n");
			dataBase.myQuery(query);
		}
	}

	public void	addOrders(Orders order)
	{
		orders.add(order);
	}
	
	public void removeOrders(Orders order)
	{
		orders.remove(order);
	}
		
	public int	getCustomerId() {return customerId;}
	public void	setCustomerId(int value) {customerId = value;}
}
