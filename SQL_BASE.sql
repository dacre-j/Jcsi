DROP database IF EXISTS jcsi;
CREATE database jcsi;
use jcsi;

CREATE TABLE customer(id int NOT NULL AUTO_INCREMENT, login VARCHAR(255), password CHAR(255), lName VARCHAR(255), fName VARCHAR(255), phone VARCHAR(255), adress VARCHAR(255),
						PRIMARY KEY (id)
						);
						
CREATE TABLE category(id int NOT NULL AUTO_INCREMENT, name VARCHAR(255),
						PRIMARY KEY (id)
						);

CREATE TABLE orders(id int NOT NULL AUTO_INCREMENT, customId int, productId int, ordersDate VARCHAR(255), deliveryDate VARCHAR(255), quantity int,
					PRIMARY KEY (id),
					FOREIGN KEY (customId) REFERENCES customer(id)
					);

CREATE TABLE product(id int NOT NULL AUTO_INCREMENT, name VARCHAR(255), category VARCHAR(255), price int, description VARCHAR(255),
						PRIMARY KEY (id),
						FOREIGN KEY (category) REFERENCES category(id)
						);
						
CREATE TABLE ordering(id int NOT NULL AUTO_INCREMENT, ordersId int, productId int, productQty int,
							PRIMARY KEY (id),
							FOREIGN KEY (ordersId) REFERENCES orders(id),
							FOREIGN KEY (productId) REFERENCES product(id)
							);
							

/*INSERT INTO customer(login, password, lname, fname, phone, adress) VALUES("login1", "password", "Jean", "Jean", "+3345678910", "10 rue 42");
INSERT INTO category(name) VALUES("objet volant");
INSERT INTO product(name, category, price, description) VALUES("avion", 1, 12000, "C'est tres bien.");
INSERT INTO orders(customerId, ordersDate, deliveryDate) VALUES(1, "2008-10-02", "2008-10-17");
INSERT INTO ordering(ordersrefId, productId, productQty) VALUES(1, 1, 42);*/
