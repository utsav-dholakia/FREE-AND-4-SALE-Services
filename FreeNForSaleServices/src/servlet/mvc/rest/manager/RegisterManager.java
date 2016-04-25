package servlet.mvc.rest.manager;

import java.util.Date;
import java.util.List;

import servlet.mvc.rest.beans.RegisterBean;
import servlet.mvc.rest.dao.RegisterDao;
import servlet.mvc.rest.model.State;
import servlet.mvc.rest.model.User;
import servlet.mvc.rest.model.UserLoginInfo;

public class RegisterManager {
	static RegisterDao dao =  new RegisterDao();
	
	public Integer enrollUser(RegisterBean bean) {
		// TODO Auto-generated method stub
		Integer response;
		
		String status = dao.getUserNameStatus(bean);
		if (status == null){
			
			State state = new State();
			state.setStateId(bean.getState());
			UserLoginInfo userLogin = new UserLoginInfo();
			userLogin.setUserName(bean.getUsername());
			userLogin.setPassword(bean.getPassword());
			Date bdate = new Date(bean.getBdate());
			User user = new User(state, userLogin, bean.getName(), bdate, bean.getPhone(),
					bean.getEmail(), bean.getStreet(), bean.getCity(), bean.getZipcode(), bean.getSex(), bean.getSsn(),
					new Date(), 0);
			response = dao.getEnrollmentStatus(user);
		}else 
			response = -1;
		
		return response;
	}

	

}
