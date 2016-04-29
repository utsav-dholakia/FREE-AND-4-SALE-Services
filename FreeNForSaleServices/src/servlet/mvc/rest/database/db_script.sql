CREATE SCHEMA FreeNForSale;

USE FreeNForSale;

CREATE TABLE UserLoginInfo(
	UId INT PRIMARY KEY AUTO_INCREMENT,
	UserName VARCHAR(25) UNIQUE NOT NULL,
	Password VARCHAR(15) NOT NULL
);

CREATE TABLE User (
	UId INT PRIMARY KEY,
	Name VARCHAR(30) NOT NULL,
	Bdate DATE,
	Phone VARCHAR(12) NOT NULL,
	Email VARCHAR(30) NOT NULL,
	Street VARCHAR(25),
	City VARCHAR(15),
	StateId INT,
	Zipcode INT,
	Sex VARCHAR(1),
	SSN BIGINT,
	LastLoginTime DATETIME NOT NULL,
	FailedAttempts INT NOT NULL,
	ProfilePhoto VARCHAR(100)
);

CREATE TABLE State(
	StateId INT PRIMARY KEY AUTO_INCREMENT,
	Name VARCHAR(2) NOT NULL,
	FullName VARCHAR(30) NOT NULL
);

CREATE TABLE Inventory(
	ItemId INT PRIMARY KEY AUTO_INCREMENT,
	Name VARCHAR(50) NOT NULL,
	TotalQuantity INT NOT NULL,
	RemainingQuantity INT NOT NULL,
	Description VARCHAR(200) NOT NULL,
	CategoryId INT NOT NULL,
	Price FLOAT NOT NULL,
	SellerId INT NOT NULL,
	Location VARCHAR(50) NOT NULL
);

CREATE TABLE Category(
	CategoryId INT PRIMARY KEY AUTO_INCREMENT,
	Name VARCHAR(50)
);

CREATE TABLE InventoryImage(
	ItemId INT,
	ImageId INT,
	Image VARCHAR(100) NOT NULL,
	Rank BOOL NOT NULL,
	PRIMARY KEY(ItemId,ImageId)
);

CREATE TABLE Finance(
	UId INT,
	CardNo CHAR(16) NOT NULL,
	CVV INT NOT NULL,
	ExpiryDate DATE NOT NULL,
	CardType VARCHAR(10) NOT NULL,
	PRIMARY KEY(UId,CardNo)
);

CREATE TABLE Cart(
	CartId INT AUTO_INCREMENT,
	UId INT,
	ItemId INT,
	Quantity INT NOT NULL,
	Amount FLOAT NOT NULL,
	Completed TINYINT NOT NULL,
	PRIMARY KEY(CartId,UId,ItemId)
);

CREATE TABLE Transaction(
	TId INT AUTO_INCREMENT,
	UId INT,
	ItemId INT,
	PurchaseTime DATETIME NOT NULL,
	Quantity INT NOT NULL,
	Amount FLOAT NOT NULL,
	PaymentType VARCHAR(10) NOT NULL,
	PRIMARY KEY(TId,UId,ItemId)
);

CREATE TABLE SellerReview(
	SellerId INT,
	Rating INT,
	Comment VARCHAR(150),
	UId INT NOT NULL,
	PRIMARY KEY(SellerId, UId)
);

CREATE TABLE SellerInfo (
	SellerId INT PRIMARY KEY,
	OverallRating float
);

ALTER TABLE User ADD FOREIGN KEY (UId) REFERENCES UserLoginInfo(UId);
ALTER TABLE User ADD FOREIGN KEY (StateId) REFERENCES State(StateId);
ALTER TABLE Inventory ADD FOREIGN KEY (SellerId) REFERENCES User(UId);
ALTER TABLE Inventory ADD FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId);
ALTER TABLE InventoryImage ADD FOREIGN KEY (ItemId) REFERENCES Inventory(ItemId);
ALTER TABLE Finance ADD FOREIGN KEY (UId) REFERENCES User(UId);
ALTER TABLE Cart ADD FOREIGN KEY (UId) REFERENCES User(UId);
ALTER TABLE Cart ADD FOREIGN KEY (ItemId) REFERENCES Inventory(ItemId);
ALTER TABLE Transaction ADD FOREIGN KEY (UId) REFERENCES User(UId);
ALTER TABLE Transaction ADD FOREIGN KEY (ItemId) REFERENCES Inventory(ItemId);
ALTER TABLE SellerReview ADD FOREIGN KEY (SellerId) REFERENCES User(UId);
ALTER TABLE SellerReview ADD FOREIGN KEY (UId) REFERENCES User(UId);
ALTER TABLE SellerInfo ADD FOREIGN KEY (SellerId) REFERENCES User(UId);

-- Insertion started

#Add data into State table

INSERT into State (Name,FullName) values ('AL', 'Alabama'),
('AK', 'Alaska'),
('AZ', 'Arizona'),
('AR', 'Arkansas'),
('CA', 'California'),
('CO', 'Colorado'),
('CT', 'Connecticut'),
('DE', 'Delaware'),
('DC', 'District of Columbia'),
('FL', 'Florida'),
('GA', 'Georgia'),
('HI', 'Hawaii'),
('ID', 'Idaho'),
('IL', 'Illinois'),
('IN', 'Indiana'),
('IA', 'Iowa'),
('KS', 'Kansas'),
('KY', 'Kentucky'),
('LA', 'Louisiana'),
('ME', 'Maine'),
('MD', 'Maryland'),
('MA', 'Massachusetts'),
('MI', 'Michigan'),
('MN', 'Minnesota'),
('MS', 'Mississippi'),
('MO', 'Missouri'),
('MT', 'Montana'),
('NE', 'Nebraska'),
('NV', 'Nevada'),
('NH', 'New Hampshire'),
('NJ', 'New Jersey'),
('NM', 'New Mexico'),
('NY', 'New York'),
('NC', 'North Carolina'),
('ND', 'North Dakota'),
('OH', 'Ohio'),
('OK', 'Oklahoma'),
('OR', 'Oregon'),
('PA', 'Pennsylvania'),
('PR', 'Puerto Rico'),
('RI', 'Rhode Island'),
('SC', 'South Carolina'),
('SD', 'South Dakota'),
('TN', 'Tennessee'),
('TX', 'Texas'),
('UT', 'Utah'),
('VT', 'Vermont'),
('VA', 'Virginia'),
('WA', 'Washington'),
('WV', 'West Virginia'),
('WI', 'Wisconsin'),
('WY', 'Wyoming');


-- Queries
delete from SellerInfo;
delete from SellerReview;
delete from Transaction;
delete from Inventory;
delete from User;
delete from UserLoginInfo;
delete from Category;

-- UserLoginInfo Table
Insert into UserLoginInfo (UId, UserName, Password) values (1, 'Utsav', 'Batman');
Insert into UserLoginInfo (UId, UserName, Password) values (2, 'Sagar', 'Pokemon');
Insert into UserLoginInfo (UId, UserName, Password) values (3, 'Siddharth', 'Game');
Insert into UserLoginInfo (UId, UserName, Password) values (4, 'Seethal', 'Study');
Insert into UserLoginInfo (UId, UserName, Password) values (5, 'Misha', 'India');
Insert into UserLoginInfo (UId, UserName, Password) values (6, 'Ankur', 'Color');


      
-- User
Insert into  User (UId,Name,Bdate,Phone,Email,Street,City,StateId,Zipcode,Sex,SSN,LastLoginTime,FailedAttempts,ProfilePhoto) values (1, 'Utsav', '1992-05-05', '4697345790', 'uvd@gmail.com', '7650 McCallum', 'Dallas', 45, 75252, 'M', NULL, Now(), 0, NULL);
Insert into  User (UId,Name,Bdate,Phone,Email,Street,City,StateId,Zipcode,Sex,SSN,LastLoginTime,FailedAttempts,ProfilePhoto) values (2, 'Sagar', '1990-12-05', 4697345722, 'sam@gmail.com', '1190 Prussia', 'philadelphia', 39, 19406, 'M', NULL, Now(), 0, NULL);
Insert into  User (UId,Name,Bdate,Phone,Email,Street,City,StateId,Zipcode,Sex,SSN,LastLoginTime,FailedAttempts,ProfilePhoto) values (3, 'Siddharth', '1991-08-25', 4697345789, 'sid@gmail.com', '18 south wacker', 'chicago', 14, 60606, 'M', NULL, Now(), 0, NULL);
Insert into  User (UId,Name,Bdate,Phone,Email,Street,City,StateId,Zipcode,Sex,SSN,LastLoginTime,FailedAttempts,ProfilePhoto) values (4, 'Seethal', '1990-04-04', 9727345722, 'seethal@gmail.com', '7740 McCallum', 'Dallas', 45, 75252, 'F', NULL, Now(), 0, NULL);
Insert into  User (UId,Name,Bdate,Phone,Email,Street,City,StateId,Zipcode,Sex,SSN,LastLoginTime,FailedAttempts,ProfilePhoto) values (5, 'Misha', '1993-03-15', 919467827812, 'ms&s@gmail.com', '28 Backto', 'bhavnagar', 14, 36400, 'F', NULL, Now(), 0, NULL);
Insert into  User (UId,Name,Bdate,Phone,Email,Street,City,StateId,Zipcode,Sex,SSN,LastLoginTime,FailedAttempts,ProfilePhoto) values (6, 'Ankur', '1989-04-20', 9467844312, 'color@gmail.com', '7732 McCallum', 'Dallas', 45, 75252, 'M', NULL, Now(), 0, NULL);


-- category
INSERT INTO Category VALUES (1,"Heave Products");
INSERT INTO Category VALUES (2,"Clothing,Shoes & Jewelry");
INSERT INTO Category VALUES (3,"Light Products");

-- Inventory
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(1, 'T-Shirt', 25, 25, 'Long Pink Tshirt ', 2, 8.75, 4, 'McCallum Glen');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(2, 'Black Pant', 22, 22, 'Long Pink Tshirt ', 2, 12.5, 4, 'McCallum Glen');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(3, 'Watch', 25, 25, 'Black And Golden Watch', 2, 30.0, 3, 'Ashwood Apartments');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(4, 'Shoes', 25, 25, 'Black and Blue Shoes', 2, 15, 2, 'Ashwood Apartments');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(5, 'Watch for Girls', 22, 22, 'Agile Pinkish Watch', 2, 12.5, 5, 'McCallum Courts');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(6, 'Puma Shoes', 22, 22, 'Puma Shoes ', 2, 12.5, 4, 'Ashwood Apartments');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(7, 'Table', 20, 20, 'Wooden table with shelves', 1, 8.75, 3, 'Ashwood Apartments');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(8, 'Laptop Screen', 21, 21, 'Working screen - brand : samsumg', 1, 20.50, 3, 'Ashwood Apartments');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(9, 'Laptop', 10, 10, 'Dell Refurbished Laptop ', 1, 350.00, 1, 'Glen of McCallum');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(10, 'Iphone 6S', 15, 15, 'Boxed Iphone 6S white model', 1, 412, 1, 'Glen of McCallum');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(11, 'S5 cover', 10, 10, 'Used S5 cover for sale', 3, 2.00, 2, 'University Village');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(12, 'Graduation gown', 10, 10, 'Not needed anymore - returning to India', 3, 20, 5, 'Glen');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(13, 'Book - Statistics', 10, 10, 'Fifth Edition', 3, 27.00, 2, 'Ashwood Apartments');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(14, 'Book - CLRS', 10, 10, 'Third Edition', 3, 27.00, 1, 'Ashwood Apartments');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(15, 'Book - Database Design', 10,10, 'Seventh Edition-Elmasri', 3, 27.00, 3, 'Ashwood Apartments');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(16, 'Coupon', 15, 15, 'Kohls 15 % off' , 3, 15, 2,'Ashwood Apartments');


-- InventoryImage
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(1,1,"images/pr.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(1,2,"images/pr1.jpg",0);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(2,1,"images/pr2.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(2,2,"images/pr3.jpg",0);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(3,1,"images/pr7.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(3,2,"images/pr6.jpg",0);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(4,1,"images/pr11.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(4,2,"images/pr10.jpg",0);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(5,1,"images/pr14.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(5,2,"images/pr15.jpg",0);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(6,1,"images/pr20.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(6,2,"images/pr21.jpg",0);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(7,2,"images/table2.jpg",0);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(7,1,"images/table1.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(8,1,"images/laptopScreen1.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(8,2,"images/laptopScreen2.jpg",0);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(9,1,"images/Laptop1.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(9,2,"images/Laptop2.jpg",0);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(10,1,"images/iphone1.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(10,2,"images/iphone2.jpg",0);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(11,1,"images/s5.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(11,2,"images/s5_2.jpg",0);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(12,1,"images/Gown1.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(12,2,"images/Gown2.jpg",0);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(13,1,"images/stats.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(14,1,"images/clrs.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(15,1,"images/elmasri.jpg",1);
insert into inventoryImage (ItemId,ImageId,Image,Rank) values 	(16,1,"images/prc16.jpg",1);
