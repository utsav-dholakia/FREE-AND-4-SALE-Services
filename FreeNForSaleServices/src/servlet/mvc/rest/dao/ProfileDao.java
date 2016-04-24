package servlet.mvc.rest.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import servlet.mvc.rest.beans.LoginBean;
import servlet.mvc.rest.beans.RegisterBean;
import servlet.mvc.rest.model.Inventory;
import servlet.mvc.rest.model.State;
import servlet.mvc.rest.model.User;
import servlet.mvc.rest.model.UserLoginInfo;
import servlet.mvc.rest.utility.HibernateUtil;

public class ProfileDao {

	public List<User> getUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUserDetails(LoginBean bean) {
		// TODO Auto-generated method stub
		Transaction	tx=HibernateUtil.getSession().beginTransaction();
		String queryStr = "SELECT * FROM User WHERE UID = (select UId from UserLoginInfo where UserName = :userName)";
		SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
		query.addEntity(User.class);
//		query.addEntity(UserLoginInfo.class);
		query.setParameter("userName", bean.getName());
		List<User> userProfile = (List<User>)query.list(); 
		tx.commit();
		System.out.println("query success");
		return userProfile;
	}

	public void updatedUserDetails(RegisterBean bean) {
		// TODO Auto-generated method stub
//		Transaction	tx=HibernateUtil.getSession().beginTransaction();
//		
//		State state = new State();
//		state.setStateId(bean.getState());
//		Date bdate = new Date(bean.getBdate());
//		
//		String queryStr = "UPDATE User Set Bdate = :bDate, phone = :phone, Email = :email, Street = :street, city = :city, stateId = :state, Zipcode = :zipCode, Sex = :sex WHERE UId = :uId;";
//		SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
//		query.addEntity(User.class);
////		query.addEntity(UserLoginInfo.class);
//		query.setParameter("bDate", bdate);
//		query.setParameter("phone",bean.getPhone());
//		query.setParameter("email",bean.getEmail());
//		query.setParameter("street",bean.getStreet());
//		query.setParameter("city",bean.getCity());
//		query.setParameter("state",state);
//		query.setParameter("zipCode",bean.getZipcode());
//		query.setParameter("sex",bean.getSex());
//        tx.commit();

		Transaction	tx=HibernateUtil.getSession().beginTransaction();
		
		State state = new State();
		state.setStateId(bean.getState());
		Date bdate = new Date(bean.getBdate());
		
        User user= (User)HibernateUtil.getSession().get(User.class, bean.getUid()); 
        user.setBdate(bdate);
        user.setPhone(bean.getPhone());
        user.setEmail(bean.getEmail());
        user.setStreet(bean.getStreet());
        user.setCity(bean.getCity());
        user.setState(state);
//        user.getState().setStateId(bean.getState());
        user.setZipcode(bean.getZipcode());
        user.setSex(bean.getSex());
        user.setSsn(bean.getSsn());
        user.setProfilePhoto(bean.getProfilePhoto());
        HibernateUtil.getSession().update(user); 
        tx.commit();

//        Transaction	tx2=HibernateUtil.getSession().beginTransaction();
//		String queryStr = "SELECT * FROM User WHERE UID = :userId";
//		SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
//		query.addEntity(User.class);
////		query.addEntity(UserLoginInfo.class);
//		query.setParameter("userId", bean.getUid());
//		List<User> updatedProfile = (List<User>)query.list();
//		tx2.commit();
//		HibernateUtil.getSession().close();
//		return updatedProfile;
//        return null;
	}

	public List<User> getUpdatedUserDetails(RegisterBean bean) {
		// TODO Auto-generated method stub
		  Transaction	tx2=HibernateUtil.getSession().beginTransaction();
			String queryStr = "SELECT * FROM User WHERE UID = :userId";
			SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryStr);
			query.addEntity(User.class);
//			query.addEntity(UserLoginInfo.class);
			query.setParameter("userId", bean.getUid());
			List<User> updatedProfile = (List<User>)query.list();
			tx2.commit();
			return updatedProfile;
	}

}
