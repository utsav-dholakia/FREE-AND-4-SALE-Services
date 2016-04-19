package servlet.mvc.rest.manager;

import java.util.List;

import org.hibernate.HibernateException;

import servlet.mvc.rest.beans.LoginBean;
import servlet.mvc.rest.dao.LoginDao;
import servlet.mvc.rest.model.UserLoginInfo;

public class LoginManager {
	static LoginDao dao =  new LoginDao();
	
	/**
	 * Business Method to validate password and update db accordingly i.e failedAttempts or LastLoginTime
	 * @param bean
	 * @return
	 * @throws HibernateException
	 */
	public String validateUser(LoginBean bean)throws HibernateException  {
		// TODO Auto-generated method stub
		List <UserLoginInfo> userLoginInfoList = dao.getUserName(bean);
		
		if(!userLoginInfoList.isEmpty() && userLoginInfoList.size() > 0)
		{
			UserLoginInfo userLoginInfo =userLoginInfoList.get(0);
			System.out.println(((Integer)userLoginInfo.getUid()).toString());
			if(userLoginInfo.getPassword().equals(bean.getPassword())){	
				dao.updateLoginTime(userLoginInfo.getUid());
			return ((Integer)userLoginInfo.getUid()).toString();
			}else
			{
				dao.updateFailedLogin(userLoginInfo.getUid(),userLoginInfo.getUser().getFailedAttempts()+1);
				System.out.println("empty");
				return "-1";
			}
		}
		else
		{
			System.out.println("empty");
			return "-1";
		}
	}

}
