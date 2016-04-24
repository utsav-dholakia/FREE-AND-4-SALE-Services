package servlet.mvc.rest.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import servlet.mvc.rest.beans.ItemDetailBean;
import servlet.mvc.rest.beans.LoginBean;
import servlet.mvc.rest.model.Cart;
import servlet.mvc.rest.model.Inventory;
import servlet.mvc.rest.model.User;
import servlet.mvc.rest.model.UserLoginInfo;
import servlet.mvc.rest.utility.HibernateUtil;
import servlet.mvc.rest.utility.MemCacheUtil;
import servlet.mvc.rest.utility.Properties;

public class InventoryDao {

	/**
	 * Fetch Inventory from cache or db for homepage
	 * 
	 * @param bean
	 * @return
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public List<Inventory> getInventoryForHomePage() throws HibernateException {

		/*if (MemCacheUtil.getMemCachedClient().get(Properties.Inventorykey) != null) {
			System.out.println(Properties.cacheHit);
			return (List<Inventory>) MemCacheUtil.getMemCachedClient().get(Properties.Inventorykey);
		} else {
			System.out.println(Properties.cacheMiss);*/

			Transaction tx = HibernateUtil.getSession().beginTransaction();

			String queryStr = "SELECT * FROM Inventory";
			SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
			query.addEntity(Inventory.class);
			// query.setParameter("password", bean.getPassword());
			List<Inventory> inventories = query.list();
			HibernateUtil.getSession().getTransaction().commit();
			System.out.println("query success");

			//MemCacheUtil.getMemCachedClient().add(Properties.Inventorykey, 0, inventories);
			return inventories;
			// TODO Auto-generated method stub

		//}
	}

	/**
	 * Fetch Inventory by CategoryId
	 * @param id
	 * @return
	 */
	public List<Inventory> getInventoryByCat(int id) {
		if (MemCacheUtil.getMemCachedClient().get(Properties.category + id) != null) {
			System.out.println(Properties.cacheHit);
			return (List<Inventory>) MemCacheUtil.getMemCachedClient().get(Properties.category + id);
		} else {
			System.out.println(Properties.cacheMiss);

			Transaction tx = HibernateUtil.getSession().beginTransaction();

			String queryStr = "SELECT * FROM Inventory where categoryId =:cId";
			SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
			query.addEntity(Inventory.class);
			query.setParameter("cId", id);

			// query.setParameter("password", bean.getPassword());
			List<Inventory> inventories = query.list();
			HibernateUtil.getSession().getTransaction().commit();
			System.out.println("query success");

			MemCacheUtil.getMemCachedClient().add(Properties.category + id, 0, inventories);
			return inventories;
		}

	}

	/**
	 * Fetch Item details by itemID
	 * @param itemId
	 * @return
	 */
	public List<Inventory> getMoreDetails(int itemId) {
	/*	if (MemCacheUtil.getMemCachedClient().get(Properties.item + itemId) != null) {
			System.out.println(Properties.cacheHit);
			return (List<Inventory>) MemCacheUtil.getMemCachedClient().get(Properties.item + itemId);
		} else {
			System.out.println(Properties.cacheMiss);*/

			Transaction tx = HibernateUtil.getSession().beginTransaction();

			String queryStr = "SELECT * FROM Inventory where ItemId =:itemId";
			SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
			query.addEntity(Inventory.class);
			query.setParameter("itemId", itemId);

			// query.setParameter("password", bean.getPassword());
			List<Inventory> inventories = query.list();
			HibernateUtil.getSession().getTransaction().commit();
			System.out.println("query success");

			//MemCacheUtil.getMemCachedClient().add(Properties.item + itemId, 0, inventories);
			return inventories;
		//}
	}

	public List<Inventory> getInventoryByName(String inventoryName) {
		
			Transaction tx = HibernateUtil.getSession().beginTransaction();

			String queryStr = "SELECT * FROM Inventory where name like :iName";
			SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
			query.addEntity(Inventory.class);
			String iName= "%"+inventoryName+"%";
			query.setParameter("iName", iName);

			// query.setParameter("password", bean.getPassword());
			List<Inventory> inventories = query.list();
			HibernateUtil.getSession().getTransaction().commit();
			System.out.println("query success");

			return inventories;
	
	}

	/**
	 * Update remaining count on purchase
	 * @param q
	 * @param itemId
	 */
	public void updateRemainingCount(int q, Integer itemId) {
		Transaction	tx=HibernateUtil.getSession().beginTransaction();
        Inventory i= (Inventory)HibernateUtil.getSession().get(Inventory.class, itemId); 
        i.setRemainingQuantity(q);
        HibernateUtil.getSession().update(i); 
        tx.commit();
	}
}
