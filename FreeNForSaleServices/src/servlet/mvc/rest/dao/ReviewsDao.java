package servlet.mvc.rest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import servlet.mvc.rest.beans.ReviewBean;
import servlet.mvc.rest.beans.ReviewDbBean;
import servlet.mvc.rest.model.Cart;
import servlet.mvc.rest.model.SellerReview;
import servlet.mvc.rest.utility.HibernateUtil;

public class ReviewsDao {


	public void saveReview(SellerReview r) {
		HibernateUtil.getSession().beginTransaction();
		
		HibernateUtil.getSession().save(r);
		HibernateUtil.getSession().getTransaction().commit();
		
	}

	public List<SellerReview> getReview(int sellerId, Integer userId) {
		HibernateUtil.getSession().beginTransaction();
		String queryStr = "SELECT * FROM SellerReview where Uid =:id and SellerId =:sellerId";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
		query.setParameter("id", userId);
		query.setParameter("sellerId", sellerId);
		List<SellerReview> sr= query.list();
		HibernateUtil.getSession().getTransaction().commit();
		
		System.out.println("query success");
		return sr;
	}

	public List<Object[]> getReviewByUserId(Integer userId) {
		HibernateUtil.getSession().beginTransaction();
		/*String queryStr = "select distinct s.SellerId,s.Comment,s.Rating,s.UId,i.Name,u.name from sellerreview s, "
				+ "inventory i,user u where s.sellerId=i.sellerId and u.uid=s.sellerId and s.Uid=:id";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
		query.addEntity(ReviewDbBean.class);,
		query.setParameter("id", userId);*/
		String hql = "select distinct s.sellerId,s.comment,s.rating,s.userByUid_1.uid,i.name,u.name from SellerReview s, "
				+ "Inventory i,User u where s.sellerId=i.user.uid and u.uid=s.sellerId and s.userByUid_1.uid=:id";
		Query query = HibernateUtil.getSession().createQuery(hql);
		query.setParameter("id", userId);
		List<Object[]> sr= query.list();
		HibernateUtil.getSession().getTransaction().commit();
		
		System.out.println("query success");
		return sr;
	}

	 public void updateReview(ReviewBean rb) {
		Transaction	tx=HibernateUtil.getSession().beginTransaction();
		String queryStr = "Update SellerReview set comment =:comment , rating=:rating  where Uid =:id and SellerId =:sellerId";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
		query.addEntity(SellerReview.class);
		query.setParameter("comment", rb.getComments());
		query.setParameter("rating", rb.getRatings());
		query.setParameter("id", rb.getUserId());
		query.setParameter("sellerId", rb.getSellerId());
		int x =query.executeUpdate();
        tx.commit();		
        System.out.println(" Query succesful " + x + " rows updated");
	}


}
