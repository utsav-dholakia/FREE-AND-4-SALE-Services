-- Queries
delete from SellerInfo;
delete from SellerReview;
delete from Transaction;
delete from Inventory;
delete from User;
delete from UserLoginInfo;


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



-- Inventory
/* let say we have 8 items from seller 2,3 and 5 to sell. 
*/

Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values (1, 'Table', 1, 0, 'Wooden table with shelves', 1, 8.75, 3, 'Ashwood Apartments');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values (2, 'Laptop Screen', 1, 0, 'Working screen - brand : samsumg', 5, 20.50, 3, 'Ashwood Apartments');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values (3, 'Laptop', 1, 1, 'Found left behind by someone, good condition', 5, 50.00, 5, 'Glen of McCallum');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values (4, 'Book - Statistics', 1, 0, 'Fifth Edition', 3, 27.00, 3, 'Ashwood Apartments');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values (5, 'S5 cover', 1, 1, 'Used S5 cover for sale', 5, 2.00, 2, 'University Village');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values (6, 'Diamond Rind', 2, 0, 'A diamond ring with silver surface', 2, 6.75, 5, 'Glen of McCallum');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values (7, 'Graduation gown', 1, 0, 'Bought one - not needed anymore - returning to India', 8, 20, 5, 'Glen');
Insert into Inventory (ItemId,Name,TotalQuantity,RemainingQuantity,Description,CategoryId,Price,SellerId,Location) values (8, 'Coupon', 1, 1, 'Groupon deal for frys Market for 30$ buy' , 1, 15, 2,'Ashwood Apartments');



-- transaction
/* here are 5 transaction between 2 seller (siddharth, misha, sagar) and 3 buyer (utsav, seethal and ankur). */

Insert into  Transaction (TId,UId,ItemId,PurchaseTime,Quantity,Amount,PaymentType) values (1, 4, 1, NOW(), 1, 8.75, 'Cash');
Insert into  Transaction (TId,UId,ItemId,PurchaseTime,Quantity,Amount,PaymentType) values (2, 6, 2, NOW()+1, 1, 20.50, 'Debit Card');
Insert into  Transaction (TId,UId,ItemId,PurchaseTime,Quantity,Amount,PaymentType) values (3, 1, 3, DATE_ADD(NOW(), INTERVAL 2 HOUR), 1, 50.00, 'Cash');
Insert into  Transaction (TId,UId,ItemId,PurchaseTime,Quantity,Amount,PaymentType) values (4, 1, 4, DATE_ADD(NOW(), INTERVAL 3 HOUR), 1, 8.75, 'Cash');
Insert into  Transaction (TId,UId,ItemId,PurchaseTime,Quantity,Amount,PaymentType) values (5, 6, 6, DATE_ADD(NOW(), INTERVAL 4 HOUR), 2, 13.50, 'Debit Card');
Insert into  Transaction (TId,UId,ItemId,PurchaseTime,Quantity,Amount,PaymentType) values (6, 6, 8, DATE_ADD(NOW(), INTERVAL 24 HOUR), 1, 15, 'CreditCard');

/* SAMPLE QUERIES
		
		-- I don't know how we will get following from cart as of now : tid, uid, itemid
		-- But we will get following for sure with TransactionBean : Time of Purchase, Quantity, Amount, PaymentType

		String queryStr = Insert Query here
		SQLQuery query = session.createSQLQuery(queryStr);
		query.addEntity(...);
		query.setParameter(..., ...);
		...
		...


mysql> select u.name, i.name, i.sellerid, t.purchasetime, t.quantity from transaction t, user u, inventory i where t.uid = u.uid and t.itemid = i.itemid;
+---------+-------------------+----------+---------------------+----------+
| name    | name              | sellerid | purchasetime        | quantity |
+---------+-------------------+----------+---------------------+----------+
| Seethal | Table             |        3 | 2016-04-20 02:39:45 |        1 |
| Ankur   | Laptop Screen     |        3 | 2016-04-20 02:39:48 |        1 |
| Utsav   | Laptop            |        5 | 2016-04-20 04:41:33 |        1 |
| Utsav   | Book - Statistics |        3 | 2016-04-20 05:41:49 |        1 |
| Ankur   | Diamond Rind      |        5 | 2016-04-20 06:41:49 |        2 |
| Ankur   | Coupon            |        2 | 2016-04-21 03:01:25 |        1 |
+---------+-------------------+----------+---------------------+----------+
6 rows in set (0.00 sec)


mysql> select u.name as 'buyer', i.name as 'inventory item', i.sellername, t.purchasetime, t.quantity, t.amount from transaction t, user u, (select i_inner.name as name, i_inner.itemid, u_inner.name as sellername from inventory i_inner, user u_inner where i_inner.sellerid = u_inner.uid) as i where t.uid = u.uid and t.itemid = i.itemid;
+---------+-------------------+------------+---------------------+----------+--------+
| buyer   | inventory item    | sellername | purchasetime        | quantity | amount |
+---------+-------------------+------------+---------------------+----------+--------+
| Seethal | Table             | Siddharth  | 2016-04-20 02:39:45 |        1 |   8.75 |
| Ankur   | Laptop Screen     | Siddharth  | 2016-04-20 02:39:48 |        1 |   20.5 |
| Utsav   | Laptop            | Misha      | 2016-04-20 04:41:33 |        1 |     50 |
| Utsav   | Book - Statistics | Siddharth  | 2016-04-20 05:41:49 |        1 |   8.75 |
| Ankur   | Diamond Rind      | Misha      | 2016-04-20 06:41:49 |        2 |   13.5 |
| Ankur   | Coupon            | Sagar      | 2016-04-21 03:01:25 |        1 |     15 |
+---------+-------------------+------------+---------------------+----------+--------+
6 rows in set (0.00 sec)

*/


-- SellerReview
/* here let say Siddharth has sold 3 items, misha has sold 2 items and Sagar has sold 1 item. So revviews for them are below. Empty entry is created when transaction happens (either insert if user-seller combo is unique and if not then update.)



sample query during transaction:
dao/TransactionDao.java

Insert into SellerReview 
method: public List<TransactionId> getSellerId(TransactionBean bean)

		String queryStr = "SELECT sellerid FROM Inventory WHERE ItemId = :itemid"; -- Question: what if user buy 3 items in one order? Maybe we can use OrderLine level transactions rather then Order level transaction.
		SQLQuery query = session.createSQLQuery(queryStr);
		query.addEntity(TransactionId.class);
		query.setParameter("itemid", bean.getItemId()); 

		List <TransactionId> sellerId = query.list();  -- don't know how to handle single column

method: public void updateSeller(int uid, int sellerid) -- sellerid fectched from List <TransactionId> sellerId

		... Update or Insert logic as per Login Module ...
*/

Insert into  SellerReview (SellerId,Rating,Comment,UId) values (3, NULL, NULL, 4);
Insert into  SellerReview (SellerId,Rating,Comment,UId) values (3, NULL, NULL, 6);
Insert into  SellerReview (SellerId,Rating,Comment,UId) values (5, NULL, NULL, 1);
Insert into  SellerReview (SellerId,Rating,Comment,UId) values (3, NULL, NULL, 1);
Insert into  SellerReview (SellerId,Rating,Comment,UId) values (5, NULL, NULL, 6);
Insert into  SellerReview (SellerId,Rating,Comment,UId) values (2, NULL, NULL, 6);

/*  select u2.name 'seller name', u.name as 'buyer name' from SellerReview s, User u, User u2 where s.uid = u.uid and s.sellerid = u2.uid;

select u2.name 'seller name', u.name as 'buyer name' from SellerReview s, User u, User u2 where s.uid = u.uid and s.sellerid = u2.uid;
+-------------+------------+
| seller name | buyer name |
+-------------+------------+
| Siddharth   | Utsav      |
| Misha       | Utsav      |
| Siddharth   | Seethal    |
| Sagar       | Ankur      |
| Siddharth   | Ankur      |
| Misha       | Ankur      |
+-------------+------------+
6 rows in set (0.00 sec)

*/


-- SellerInfo
/* on load one time scripting */
Insert into SellerInfo (SellerId, OverallRating)
Select SellerId, avg(Rating) From (
	select * from SellerReview Where Rating IS NOT Null
) As tmp Group by tmp.SellerId;


Update SellerReview set  Rating = 5 where SellerId = 3;
Update SellerReview set  Rating = 3 where SellerId = 3 and UID = 6;
Update SellerReview set  Rating = 2 where SellerId = 5 and UID = 6;
Update SellerReview set  Rating = 1 where SellerId = 2 and UID = 6;

/* script to change SellerReview for all SellerIds (after any update not recorded with SellerInfo, like 4 above) with avoidance of duplicates, can be used anytime
*/

Insert into SellerInfo (SellerId, OverallRating)
Select SellerId, avg(Rating) From (
	select * from SellerReview Where Rating IS NOT Null
) As tmp Group by tmp.SellerId
HAVING SellerId NOT IN(
    SELECT SellerId FROM SellerInfo
);

Update SellerInfo As S1 INNER JOIN 
	(Select SellerId, avg(rating) as Rating  From SellerReview Group by SellerId) As S2 ON s1.SellerId = s2. SellerId
	set OverallRating = Rating;

-- steps on new rating
/* 1. check on each rating first check if seller is on SellerIfo table or not
INSERT INTO SellerId (SellerId, OverallRatin)
SELECT * FROM (SELECT :sellerid, :rating) AS tmp
WHERE NOT EXISTS (
    SELECT SellerId FROM SellerInfo WHERE SellerId = :sellerid
) LIMIT 1;
*/

/* 2. if record already exists on new rating by user :

select OverallRating from SellerInfo where SellerId = :sellerid;
List <SellerReview> currentRating = query.list(); 
select count(*) as n from SellerReview where SellerId = :sellerid;
List <SellerReview> currentCount = query.list(); 

float new_rating = (currentRating.rating * currentCount.n + :rating)/ (currentCount.n + 1) ;
Insert this new rating in SellerInfo.

*/

-- validate
/* un-comment

select count(*) from SellerInfo;
select count(*) from SellerReview;
select count(*) from Transaction;
select count(*) from Inventory;
select count(*) from User;
select count(*) from UserLoginInfo;

*/
