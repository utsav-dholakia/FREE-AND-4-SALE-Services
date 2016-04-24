package servlet.mvc.rest.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import servlet.mvc.rest.utility.HibernateUtil;

public class TransactionDao {

	/**
	 * Save tranaction
	 * @param tr
	 */
	public void saveTranaction(servlet.mvc.rest.model.Transaction tr) {
		Transaction	tx=HibernateUtil.getSession().beginTransaction();
		HibernateUtil.getSession().save(tr); 
        tx.commit();		
	}

	/**
	 * Get Transactions
	 * @param userId
	 * @return
	 */
	public List<servlet.mvc.rest.model.Transaction> getTrHist(Integer userId) {
		HibernateUtil.getSession().beginTransaction();
		String queryStr = "SELECT * FROM Transaction where Uid =:id";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
		query.addEntity(servlet.mvc.rest.model.Transaction.class);
		query.setParameter("id", userId);
		List<servlet.mvc.rest.model.Transaction> trs= query.list();
		HibernateUtil.getSession().getTransaction().commit();
		System.out.println("query success");
		return trs;
	}


}
