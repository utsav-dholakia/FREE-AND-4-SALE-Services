package servlet.mvc.rest.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import servlet.mvc.rest.beans.RegisterBean;
import servlet.mvc.rest.model.User;
import servlet.mvc.rest.model.UserLoginInfo;
import servlet.mvc.rest.utility.HibernateUtil;

public class RegisterDao {

	public String getUserNameStatus(RegisterBean bean) {
		// TODO Auto-generated method stub
		Transaction	tx=HibernateUtil.getSession().beginTransaction();
		
		String queryStr = "SELECT * FROM UserLoginInfo WHERE userName LIKE :userName";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
		query.addEntity(UserLoginInfo.class);
		query.setParameter("userName", bean.getUsername());
		List <UserLoginInfo> userLogin = (List <UserLoginInfo>)query.list(); 
		tx.commit();
		System.out.println("query success");
		if (userLogin.size() > 0){
			return userLogin.get(0).getUserName();
		}else 
			return null;
	}
	
	public String getEnrollmentStatus(User user) {
		// TODO Auto-generated method stub
		Transaction	tx=HibernateUtil.getSession().beginTransaction();
//		
//		String queryStr = "SELECT name FROM User WHERE UserName = :userName";
//		SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
//		query.addEntity(User.class);
//		query.setParameter("userName", bean.getName());
//		List <User> user = query.list(); 
//		tx.commit();
		HibernateUtil.getSession().save(user);
		System.out.println("User added to the database");
		HibernateUtil.getSession().save(user.getUserLoginInfo());
		System.out.println("User login credentials added to the database"); //   
        tx.commit();
		return "User registration is successful.";
	}

	

}
