package servlet.mvc.rest.manager;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

import servlet.mvc.rest.beans.LoginBean;
import servlet.mvc.rest.dao.LoginDao;
import servlet.mvc.rest.model.UserLoginInfo;
import servlet.mvc.rest.utility.MemCacheUtil;

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
		List <UserLoginInfo> userLoginInfoList1 = dao.getUserName1(bean);
		String uId="";
		if(!userLoginInfoList.isEmpty() && userLoginInfoList.size() > 0 && !userLoginInfoList1.isEmpty() && userLoginInfoList1.size() > 0 )
		{
			UserLoginInfo userLoginInfo =userLoginInfoList.get(0);
			UserLoginInfo userLoginInfo1 =userLoginInfoList1.get(0);
			System.out.println(((Integer)userLoginInfo.getUid()).toString());
			if(userLoginInfo.getPassword().equals(bean.getPassword())){	
				Date curDate=new Date();
				dao.updateLoginTime(userLoginInfo.getUid(),curDate);
			//	userLoginInfoList.get(0).getUser().setLastLoginTime(curDate);
				
			uId= ((Integer)userLoginInfo.getUid()).toString();
			}else
			{
				int attmpts= userLoginInfo1.getUser().getFailedAttempts()+1;
				dao.updateFailedLogin(userLoginInfo1.getUid(),attmpts);
			//	userLoginInfoList.get(0).getUser().setFailedAttempts(attmpts);
				System.out.println("empty");
				uId= "-1";
			}
		//	MemCacheUtil.getMemCachedClient().replace(bean.getName(),0, userLoginInfoList);
		}
		else
		{
			System.out.println("empty");
			uId= "-1";
		}
		return uId;
	}

}
