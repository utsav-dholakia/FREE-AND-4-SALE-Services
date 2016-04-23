package servlet.mvc.rest.manager;

import servlet.mvc.rest.beans.EmailBean;
import servlet.mvc.rest.dao.InventoryDao;
import servlet.mvc.rest.utility.Properties;
import servlet.mvc.rest.utility.SendEmail;

public class ContactUsManager {
	static InventoryDao dao =  new InventoryDao();

	public String sendEmail(EmailBean bean) {
		 SendEmail send = new SendEmail(bean.getSendTo(), "Message Recieved Confirmation", Properties.hello+ bean.getName()+Properties.message);
		 return "Success";
	}
	

	

}
