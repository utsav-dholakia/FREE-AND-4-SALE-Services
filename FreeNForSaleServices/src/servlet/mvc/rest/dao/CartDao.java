package servlet.mvc.rest.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import servlet.mvc.rest.beans.CartBean;
import servlet.mvc.rest.beans.ViewCartBean;
import servlet.mvc.rest.model.Cart;
import servlet.mvc.rest.model.CartId;
import servlet.mvc.rest.model.Inventory;
import servlet.mvc.rest.model.User;
import servlet.mvc.rest.utility.HibernateUtil;

public class CartDao {



	/**
	 * Method to insert in Cart table.
	 * @param c
	 * @return
	 */
	public void addToCart(Cart c) {
		Transaction	tx=HibernateUtil.getSession().beginTransaction();
		HibernateUtil.getSession().save(c); 
        tx.commit();
		
	}

	/**
	 * Method to get cart details from cart,inventoryc
	 * @param id
	 * @return
	 */
	public List<Cart> getcart(int id) {
		HibernateUtil.getSession().beginTransaction();
		String queryStr = "SELECT * FROM Cart where Uid =:id and completed =:one";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
		query.addEntity(Cart.class);
		query.setParameter("id", id);
		byte one =0;
		query.setParameter("one", one);
		List<Cart> carts= query.list();
		HibernateUtil.getSession().getTransaction().commit();
		System.out.println("query success");
		return carts;
	}

	/**
	 * Delete from cart
	 * @param cId
	 */
	public void deleteFromCart(CartId cId) {
		Transaction	tx=HibernateUtil.getSession().beginTransaction();
        Cart cart= (Cart)HibernateUtil.getSession().get(Cart.class, cId); 
		HibernateUtil.getSession().delete(cart); 
        tx.commit();		
	}

	/**
	 * Update cart
	 * @param cartId
	 * @param amount
	 * @param quantity
	 */
	public void updateCart(CartId cartId, Float amount, int quantity) {
		Transaction	tx=HibernateUtil.getSession().beginTransaction();
        Cart cart= (Cart)HibernateUtil.getSession().get(Cart.class, cartId); 
        cart.setAmount(amount);
        cart.setQuantity(quantity);
        HibernateUtil.getSession().update(cart); 
        tx.commit();
		
	} 

	/**
	 * update complete flag in cart to 1 i.e. purchase cart
	 * @param cartId
	 * @param i 
	 * @param float1 
	 */
	public void completeCart(CartId cartId, Float amount, int quantity) {
		Transaction	tx=HibernateUtil.getSession().beginTransaction();
        Cart cart= (Cart)HibernateUtil.getSession().get(Cart.class, cartId); 
        cart.setCompleted(Byte.valueOf("1"));
        cart.setAmount(amount);
        cart.setQuantity(quantity);
        HibernateUtil.getSession().update(cart); 
        tx.commit();
		
	}
	
}
