package servlet.mvc.rest.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import servlet.mvc.rest.beans.LoginBean;
import servlet.mvc.rest.model.User;
import servlet.mvc.rest.model.UserLoginInfo;
import servlet.mvc.rest.utility.HibernateUtil;

public class LoginDao {

	/**
	 * Fetch userdetails by username
	 * @param bean
	 * @return
	 * @throws HibernateException
	 */
	public List<UserLoginInfo> getUserName(LoginBean bean) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction	tx=session.beginTransaction();
		
		String queryStr = "SELECT * FROM UserLoginInfo WHERE UserName = :userName";
		SQLQuery query = session.createSQLQuery(queryStr);
		query.addEntity(UserLoginInfo.class);
		query.setParameter("userName", bean.getName());
		//query.setParameter("password", bean.getPassword());
		List <UserLoginInfo> userLoginInfo = query.list(); 
		//UserLoginInfo userLoginInfo = (UserLoginInfo) session.get(UserLoginInfo.class, bean.getName());
		session.getTransaction().commit();
		//if (tx!=null) tx.rollback();     
	        session.close(); 
		System.out.println("query success");
		return userLoginInfo;
		// TODO Auto-generated method stub
		
	}

	/**
	 * Update Login Time
	 * @param uid
	 * @throws HibernateException
	 */
	public void updateLoginTime(int uid) throws HibernateException  {
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction	tx=session.beginTransaction();
        User user= (User)session.get(User.class, uid); 
        user.setLastLoginTime(new Date());
		session.update(user); 
        tx.commit();
    //    if (tx!=null) tx.rollback();     
        session.close(); 
	}

	/**
	 * Update Failed Login attempts.
	 * @param uid
	 * @param i
	 * @throws HibernateException
	 */
	public void updateFailedLogin(int uid, int i) throws HibernateException  {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction	tx=session.beginTransaction();
        User user= (User)session.get(User.class, uid); 
        user.setFailedAttempts(i);;
		session.update(user); 
        tx.commit();
      //  if (tx!=null) tx.rollback();     
        session.close(); 
	}
	
}
