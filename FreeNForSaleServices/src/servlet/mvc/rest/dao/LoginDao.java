package servlet.mvc.rest.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import servlet.mvc.rest.beans.LoginBean;
import servlet.mvc.rest.model.UserLoginInfo;
import servlet.mvc.rest.utility.HibernateUtil;

public class LoginDao {

	public List<UserLoginInfo> getUser(LoginBean bean) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		String queryStr = "SELECT * FORM UserLoginInfo WHERE UserName = :userName AND Password = :password";
		SQLQuery query = session.createSQLQuery(queryStr);
		query.addEntity(UserLoginInfo.class);
		query.setParameter("userName", bean.getName());
		query.setParameter("password", bean.getPassword());
		List <UserLoginInfo> userLoginInfo = query.list(); 
		//UserLoginInfo userLoginInfo = (UserLoginInfo) session.get(UserLoginInfo.class, bean.getName());
		session.getTransaction().commit();
		System.out.println("query success");
		return userLoginInfo;
		// TODO Auto-generated method stub
		
	}
	
}
