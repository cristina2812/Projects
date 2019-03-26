drop schema if exists `tema3`;
CREATE SCHEMA IF NOT EXISTS `tema3`;
USE `tema3`;

CREATE TABLE IF NOT EXISTS `tema3`.`Customer`(
idCustomer int UNIQUE auto_increment,
nameCustomer VARCHAR(45)   UNIQUE,
AddressCustomer VARCHAR(45),
PRIMARY KEY (idCustomer)
);

CREATE TABLE IF NOT EXISTS `tema3`.`Product`(
idProduct int UNIQUE auto_increment,
nameProduct VARCHAR(45)   UNIQUE,
quantity int,
pret int,
PRIMARY KEY (idProduct)
);

CREATE TABLE IF NOT EXISTS `tema3`.`Order`(
quantity int,
nameCustomer VARCHAR(45),
nameProduct VARCHAR(45),
constraint `fk_nameCustomer` foreign key (`nameCustomer`) references `Customer` (`nameCustomer`),
constraint `fk_nameProduct` foreign key (`nameProduct`) references `Product` (`nameProduct`)
);

CREATE TABLE IF NOT EXISTS `tema3`.`Order_product`(
quantity_order int,
quantity int,
nameProduct VARCHAR(45),
nameCustomer VARCHAR(45)
);

INSERT INTO tema3.product(idProduct, nameProduct, quantity, pret) VALUES(1,'BANANE','10','3');
INSERT INTO tema3.product(idProduct, nameProduct, quantity, pret) VALUES(2,'CAPSUNI','4','9');
INSERT INTO tema3.product(idProduct, nameProduct, quantity, pret) VALUES(3,'PERE','6','10');

INSERT INTO tema3.customer(idCustomer, nameCustomer, AddressCustomer) VALUES(1,'Cristina','Cluj');
INSERT INTO tema3.customer(idCustomer, nameCustomer, AddressCustomer) VALUES(2,'Liana','Dej');
INSERT INTO tema3.customer(idCustomer, nameCustomer, AddressCustomer) VALUES(3,'Ioana','Alba');
