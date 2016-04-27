Delete from SellerReview;
Delete from Transaction;
Delete from cart;
Delete from InventoryImage;
Delete from Inventory;


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
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(13, 'Book - Statistics', 10, 10, 'Fifth Edition', 3, 27.00, 2, 'Ashwood Apartments')
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(14, 'Book - CLRS', 10, 10, 'Third Edition', 3, 27.00, 1, 'Ashwood Apartments')
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(15, 'Book - Database Design', 10,10, 'Seventh Edition-Elmasri', 3, 27.00, 3, 'Ashwood Apartments')
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values 	(16, 'Coupon', 15, 15, 'Kohls 15 % off' , 3, 15, 2,'Ashwood Apartments');



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

