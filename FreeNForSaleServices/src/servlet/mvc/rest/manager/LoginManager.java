package servlet.mvc.rest.manager;

import java.util.List;

import servlet.mvc.rest.beans.LoginBean;
import servlet.mvc.rest.dao.LoginDao;
import servlet.mvc.rest.model.UserLoginInfo;

public class LoginManager {
	static LoginDao dao =  new LoginDao();
	public String validateUser(LoginBean bean) {
		// TODO Auto-generated method stub
		List <UserLoginInfo> userLoginInfo = dao.getUser(bean);
		if(!userLoginInfo.isEmpty() && userLoginInfo.size() > 0)
		{
			return userLoginInfo.get(0).getUid().toString();
		}
		else
		{
			return "";
		}
	}

}
