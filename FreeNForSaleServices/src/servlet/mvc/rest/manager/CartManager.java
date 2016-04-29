package servlet.mvc.rest.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import servlet.mvc.rest.beans.CartBean;
import servlet.mvc.rest.beans.UpdateCartBean;
import servlet.mvc.rest.beans.ViewCartBean;
import servlet.mvc.rest.dao.CartDao;
import servlet.mvc.rest.dao.InventoryDao;
import servlet.mvc.rest.dao.LoginDao;
import servlet.mvc.rest.dao.ReviewsDao;
import servlet.mvc.rest.dao.TransactionDao;
import servlet.mvc.rest.model.Cart;
import servlet.mvc.rest.model.CartId;
import servlet.mvc.rest.model.Inventory;
import servlet.mvc.rest.model.InventoryImage;
import servlet.mvc.rest.model.SellerReview;
import servlet.mvc.rest.model.Transaction;
import servlet.mvc.rest.model.TransactionId;
import servlet.mvc.rest.model.User;
import servlet.mvc.rest.utility.Properties;
import servlet.mvc.rest.utility.SendEmail;

public class CartManager {
	static CartDao dao = new CartDao();

	/**
	 * Add to cart: bean to model
	 * 
	 * @param bean
	 */
	public void addToCart(CartBean bean) {
		Cart c = new Cart();
		c.setAmount(new Float(bean.getAmount()));
		c.setCompleted(new Byte("0"));
		Inventory i = new Inventory();
		i.setItemId(bean.getInventoryId());
		c.setInventory(i);
		c.setQuantity(bean.getQuantity());
		User u = new User();
		u.setUid(bean.getUserId());
		c.setUser(u);

		CartId cartId = new CartId();
		cartId.setCartId(bean.getUserId());
		cartId.setItemId(bean.getInventoryId());
		cartId.setUid(bean.getUserId());
		c.setId(cartId);
		dao.addToCart(c);

	}

	/**
	 * Get cart details: Model to bean
	 * 
	 * @param bean
	 * @return
	 */
	public List<ViewCartBean> getCart(CartBean bean) {
		List<Cart> cartList = dao.getcart(bean.getUserId());
		List<ViewCartBean> viewCartBeans = new ArrayList<ViewCartBean>();
		InventoryDao iDao= new InventoryDao();
		
		for (Cart c : cartList) {
			System.out.println(c.getInventory().getItemId());
			ViewCartBean vcb = new ViewCartBean();
			
			vcb.setAmount(Float.toString(c.getAmount()));
			vcb.setCompleted(Byte.toString(c.getCompleted()));
			vcb.setId(c.getId().getCartId());
			vcb.setInventoryId(c.getInventory().getItemId());
			
			vcb.setQuantity(c.getQuantity());
			
			List<Inventory>inList= iDao.getMoreDetails(vcb.getInventoryId());
			if (inList != null && inList.size()>0 && inList.get(0).getUser().getUid()>0){
				vcb.setSellerId(inList.get(0).getUser().getUid());
				if (inList.get(0).getCategory() != null)
					vcb.setCategoryId(inList.get(0).getCategory().getCategoryId());
				
				for (InventoryImage ii : inList.get(0).getInventoryimages()) {
					if (ii.isRank()) {
						vcb.setImage(ii.getImage());
					}
				}
				vcb.setTotalQuantity(inList.get(0).getTotalQuantity());
				vcb.setItemName(inList.get(0).getName());
			}
			vcb.setUserId(c.getId().getUid());
			viewCartBeans.add(vcb);
		}
		return viewCartBeans;

	}

	/**
	 * Update cart: bean to model
	 * 
	 * @param bean
	 */
	public void saveUpdate(UpdateCartBean beans) {
		if (beans.getUpdateItems() != null) {
			for (CartBean bean : beans.getUpdateItems()) {
				if (bean.getInventoryId() != null && bean.getInventoryId() > 0) {
					CartId cartId = new CartId();
					cartId.setCartId(bean.getUserId());
					cartId.setItemId(bean.getInventoryId());
					cartId.setUid(bean.getUserId());
					dao.updateCart(cartId, Float.valueOf(bean.getAmount()), bean.getQuantity());
				}

			}
		}
		if (beans.getRemoveItems() != null && !beans.getRemoveItems().isEmpty() && beans.getRemoveItems().size() > 0) {
			for (Integer i : beans.getRemoveItems()) {
				CartId cId = new CartId();
				cId.setCartId(beans.getUserId());
				cId.setItemId(i);
				cId.setUid(beans.getUserId());
				dao.deleteFromCart(cId);
			}
		}

	}

	/**
	 * Purchasse cart: update cart and save in transaction
	 * 
	 * @param beans
	 */
	public String purchaseCart(UpdateCartBean beans) {
		String response = "";
		Boolean flag = false;
		if (beans.getUpdateItems() != null) {
			for (CartBean bean : beans.getUpdateItems()) {
				if (bean.getInventoryId() != null && bean.getInventoryId() > 0) {
					InventoryDao IDao = new InventoryDao();
					List<Inventory> iList = IDao.getMoreDetails(bean.getInventoryId());
					if (iList != null) {
						if (iList.get(0).getRemainingQuantity() > 0) {
							int q = iList.get(0).getRemainingQuantity() - bean.getQuantity();
							IDao.updateRemainingCount(q, bean.getInventoryId());
							CartId cartId = new CartId();
							cartId.setCartId(bean.getUserId());
							cartId.setItemId(bean.getInventoryId());
							cartId.setUid(bean.getUserId());
							dao.completeCart(cartId, Float.valueOf(bean.getAmount()), bean.getQuantity());
							Transaction tr = new Transaction();
							tr.setAmount(Float.valueOf(bean.getAmount()));
							tr.setPaymentType(beans.getPaymentType());
							tr.setQuantity(bean.getQuantity());
							tr.setPurchaseTime(new Date());
							TransactionId trId = new TransactionId();
							trId.setItemId(bean.getInventoryId());
							trId.setUid(bean.getUserId());
							tr.setId(trId);
							TransactionDao trDao = new TransactionDao();
							trDao.saveTranaction(tr);
							ReviewsDao rDao = new ReviewsDao();
							List<SellerReview> r1 = rDao.getReview(bean.getSellerId(), bean.getUserId());
							if ( r1.size()<=0) {
								SellerReview r = new SellerReview();
								r.setSellerId(bean.getSellerId());
								User u = new User();
								u.setUid(bean.getUserId());
								r.setUserByUid_1(u);
								//r.setUserByUid(u);
								rDao.saveReview(r);
							}
							response = "Success";
							flag = true;
						} else {
							response = "Unavailable";
						}
					}

				}

			}
		}
		if (beans.getRemoveItems() != null && !beans.getRemoveItems().isEmpty() && beans.getRemoveItems().size() > 0) {
			for (Integer i : beans.getRemoveItems()) {
				CartId cId = new CartId();
				cId.setCartId(beans.getUserId());
				cId.setItemId(i);
				cId.setUid(beans.getUserId());
				dao.deleteFromCart(cId);
			}
		}

		if (flag) {
			LoginDao lDao = new LoginDao();
			List<User> users = lDao.getEmailbyUserId(beans.getUserId());
			String emailId = "";
			String name = "";
			if (users != null) {
				emailId = users.get(0).getEmail();
				name = users.get(0).getName();

				SendEmail send = new SendEmail(emailId, "Payment Recieved Confirmation",
						Properties.hello + name + Properties.paymentMessage);
			}
		}
		return response;
	}

}
