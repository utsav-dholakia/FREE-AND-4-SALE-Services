package servlet.mvc.rest.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.spy.memcached.MemcachedClient;
import servlet.mvc.rest.beans.LoginBean;
import servlet.mvc.rest.model.User;
import servlet.mvc.rest.model.UserLoginInfo;
import servlet.mvc.rest.utility.HibernateUtil;
import servlet.mvc.rest.utility.MemCacheUtil;
import servlet.mvc.rest.utility.Properties;

public class LoginDao {

	/**
	 * Fetch userdetails by username
	 * 
	 * @param bean
	 * @return
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public List<UserLoginInfo> getUserName(LoginBean bean) throws HibernateException {

		if (MemCacheUtil.getMemCachedClient().get(bean.getName()) != null) {
			System.out.println(Properties.cacheHit);
			return (List<UserLoginInfo>) MemCacheUtil.getMemCachedClient().get(bean.getName());
		} else {
			System.out.println(Properties.cacheMiss);

			Transaction tx = HibernateUtil.getSession().beginTransaction();

			String queryStr = "SELECT * FROM UserLoginInfo WHERE UserName = :userName";
			SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
			query.addEntity(UserLoginInfo.class);
			query.setParameter("userName", bean.getName());
			// query.setParameter("password", bean.getPassword());
			List<UserLoginInfo> userLoginInfo = query.list();
			// UserLoginInfo userLoginInfo = (UserLoginInfo)
			// session.get(UserLoginInfo.class, bean.getName());
			HibernateUtil.getSession().getTransaction().commit();
			// if (tx!=null) tx.rollback();
			// HibernateUtil.getSession().close();
			System.out.println("query success");

			MemCacheUtil.getMemCachedClient().add(bean.getName(), 0, userLoginInfo);
			return userLoginInfo;
			// TODO Auto-generated method stub

		}
	}
	public List<UserLoginInfo> getUserName1(LoginBean bean) throws HibernateException {

//		if (MemCacheUtil.getMemCachedClient().get(bean.getName()) != null) {
//			System.out.println(Properties.cacheHit);
//			return (List<UserLoginInfo>) MemCacheUtil.getMemCachedClient().get(bean.getName());
//		} else {
//			System.out.println(Properties.cacheMiss);

			Transaction tx = HibernateUtil.getSession().beginTransaction();

			String queryStr = "SELECT * FROM UserLoginInfo WHERE UserName = :userName";
			SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
			query.addEntity(UserLoginInfo.class);
			query.setParameter("userName", bean.getName());
			// query.setParameter("password", bean.getPassword());
			List<UserLoginInfo> userLoginInfo = query.list();
			// UserLoginInfo userLoginInfo = (UserLoginInfo)
			// session.get(UserLoginInfo.class, bean.getName());
			HibernateUtil.getSession().getTransaction().commit();
			// if (tx!=null) tx.rollback();
			// HibernateUtil.getSession().close();
			System.out.println("query success");

			//MemCacheUtil.getMemCachedClient().add(bean.getName(), 0, userLoginInfo);
			return userLoginInfo;
			// TODO Auto-generated method stub

		}
	//}

	/**
	 * Update Login Time
	 * 
	 * @param uid
	 * @throws HibernateException
	 */
	public void updateLoginTime(int uid, Date d) throws HibernateException {
		Transaction tx = HibernateUtil.getSession().beginTransaction();
		User user = (User) HibernateUtil.getSession().get(User.class, uid);
		user.setLastLoginTime(d);
		HibernateUtil.getSession().update(user);
		tx.commit();
		// if (tx!=null) tx.rollback();
		// HibernateUtil.getSession().close();
	}

	/**
	 * Update Failed Login attempts.
	 * 
	 * @param uid
	 * @param i
	 * @throws HibernateException
	 */
	public void updateFailedLogin(int uid, int i) throws HibernateException {
		// Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = HibernateUtil.getSession().beginTransaction();
		User user = (User) HibernateUtil.getSession().get(User.class, uid);
		user.setFailedAttempts(i);
		;
		HibernateUtil.getSession().update(user);
		tx.commit();
		// if (tx!=null) tx.rollback();
		// HibernateUtil.getSession().close();
	}

	/**
	 * Returns emailId from db
	 * @param userId
	 * @return
	 */
	public List<User> getEmailbyUserId(int userId) {
		HibernateUtil.getSession().beginTransaction();
		String queryStr = "SELECT * FROM User WHERE Uid = :userId";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
		query.addEntity(User.class);
		query.setParameter("userId", userId);
		List<User> users = query.list();
		HibernateUtil.getSession().getTransaction().commit();
		
		return users;
	}

}
