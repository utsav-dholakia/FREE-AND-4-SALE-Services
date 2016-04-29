package servlet.mvc.rest.manager;

import java.text.SimpleDateFormat;
import java.util.List;

import servlet.mvc.rest.beans.LoginBean;
import servlet.mvc.rest.beans.RegisterBean;
import servlet.mvc.rest.dao.ProfileDao;
import servlet.mvc.rest.model.User;

public class ProfileManager {
	static ProfileDao dao =  new ProfileDao();
	
	public RegisterBean getProfile(LoginBean bean) {
		// TODO Auto-generated method stub
		RegisterBean userDetails = new RegisterBean();
		List<User> userQuery = dao.getUserDetails(bean);
		User temp = userQuery.get(0);
		userDetails.setName(temp.getName());
		userDetails.setBdate(temp.getBdate().getTime());
		
		userDetails.setPhone(temp.getPhone());
		userDetails.setEmail(temp.getEmail());
		userDetails.setStreet(temp.getStreet());
		userDetails.setCity(temp.getCity());
		userDetails.setState(temp.getState().getStateId());
		userDetails.setZipcode(temp.getZipcode());
		userDetails.setSex(temp.getSex());
		userDetails.setSsn(temp.getSsn());
		userDetails.setLastLoginTime(temp.getLastLoginTime());
		System.out.println("time:" + temp.getLastLoginTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd::HH mm ss");
		userDetails.setLastLoginInString(sdf.format(temp.getLastLoginTime()));
		System.out.println(userDetails.getLastLoginInString());
		userDetails.setFailedAttempts(temp.getFailedAttempts());
		
		userDetails.setProfilePhoto(temp.getProfilePhoto());	
		return userDetails;
	}

	public RegisterBean updateNgetProfile(RegisterBean bean) {
		// TODO Auto-generated method stub
		RegisterBean updatedDetails = new RegisterBean();
		dao.updatedUserDetails(bean);
		List<User> updatedUserQuery = dao.getUpdatedUserDetails(bean);
		User temp = updatedUserQuery.get(0);
		updatedDetails.setName(temp.getName());
		updatedDetails.setBdate(temp.getBdate().getTime());
		updatedDetails.setPhone(temp.getPhone());
		updatedDetails.setEmail(temp.getEmail());
		updatedDetails.setStreet(temp.getStreet());
		updatedDetails.setCity(temp.getCity());
		updatedDetails.setState(temp.getState().getStateId());
		updatedDetails.setZipcode(temp.getZipcode());
		updatedDetails.setSex(temp.getSex());
		updatedDetails.setSsn(temp.getSsn());
		updatedDetails.setLastLoginTime(temp.getLastLoginTime());
		updatedDetails.setFailedAttempts(temp.getFailedAttempts());
		updatedDetails.setProfilePhoto(temp.getProfilePhoto());
		return updatedDetails;
	}

}
