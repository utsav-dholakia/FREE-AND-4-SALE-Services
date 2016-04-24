package servlet.mvc.rest.manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import servlet.mvc.rest.beans.CartBean;
import servlet.mvc.rest.beans.ViewCartBean;
import servlet.mvc.rest.dao.TransactionDao;
import servlet.mvc.rest.model.InventoryImage;
import servlet.mvc.rest.model.Transaction;

public class TransactionManager {
	static TransactionDao dao = new TransactionDao();

	/**
	 * Get transaction history 
	 * @param bean
	 * @return
	 */
	public List<ViewCartBean> getTransHistory(CartBean bean) {
		List<Transaction> trList = dao.getTrHist(bean.getUserId());
		List<ViewCartBean> viewCartBeans = new ArrayList<ViewCartBean>();
		for (Transaction c : trList) {
			ViewCartBean vcb = new ViewCartBean();
			vcb.setAmount(Float.toString(c.getAmount()));
			for (InventoryImage ii : c.getInventory().getInventoryimages()) {
				if (ii.isRank()) {
					vcb.setImage(ii.getImage());
				}
			}
			vcb.setInventoryId(c.getInventory().getItemId());
			vcb.setItemName(c.getInventory().getName());
			vcb.setQuantity(c.getQuantity());
			vcb.setUserId(c.getId().getUid());
			if(c.getInventory().getUser().getName()!=null)
			vcb.setSellerName(c.getInventory().getUser().getName());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd::HH:mm");
			vcb.setTransactionTime(format.format(c.getPurchaseTime()));
			viewCartBeans.add(vcb);
		}
		return viewCartBeans;
	
	}

}
