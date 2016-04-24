package servlet.mvc.rest.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import servlet.mvc.rest.beans.CartBean;
import servlet.mvc.rest.beans.InventoryBean;
import servlet.mvc.rest.beans.ReviewBean;
import servlet.mvc.rest.beans.ReviewDbBean;
import servlet.mvc.rest.dao.ReviewsDao;
import servlet.mvc.rest.model.SellerReview;

public class ReviewManager {
	static ReviewsDao dao = new ReviewsDao();

	public Map<Integer, ReviewBean> getReviews(CartBean bean) {
		List<Object[]> sellerReviews = dao.getReviewByUserId(bean.getUserId());
		Map<Integer, ReviewBean> reviewMap = new HashMap<Integer, ReviewBean>();
		for (Object[] r : sellerReviews) {

			if (reviewMap.containsKey((Integer) r[0])) {
				ReviewBean rbean = reviewMap.get(r[0]);
				rbean.getItems().add((String) r[4]);
				reviewMap.put((Integer) r[0], rbean);
			} else {
				ReviewBean rb = new ReviewBean();
				if ((String) r[1] != null) {
					rb.setComments((String) r[1]);
				} else {
					rb.setComments("");
				}
				if ((Integer) r[2] != null) {
					rb.setRatings((Integer) r[2]);
				} else {
					rb.setRatings(0);
				}
				rb.setSellerId((Integer) r[0]);
				rb.setUserId((Integer) r[3]);
				rb.setSellerName((String) r[5]);
				ArrayList<String> items = new ArrayList<String>();
				items.add((String) r[4]);
				;
				rb.setItems(items);
				reviewMap.put((Integer) r[0], rb);
			}

		}
		return reviewMap;
	}
	
	public Map<Integer, ReviewBean> saveReviews(List<ReviewBean> beans) {
		Integer userId= 0;
		for(ReviewBean rb : beans){
			userId=rb.getUserId();
			//List<SellerReview> r1 = dao.getReview(rb.getSellerId(), rb.getUserId());
		//	if(r1!=null && r1.size()==1){
				dao.updateReview(rb);
				
		//	}	
		}
		CartBean c=new CartBean();
		c.setUserId(userId);
		Map<Integer, ReviewBean> reviewMap=getReviews(c);
		return reviewMap;
	}

}
