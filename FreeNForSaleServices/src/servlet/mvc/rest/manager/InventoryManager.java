package servlet.mvc.rest.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import servlet.mvc.rest.beans.InventoryBean;
import servlet.mvc.rest.beans.ItemDetailBean;
import servlet.mvc.rest.dao.InventoryDao;
import servlet.mvc.rest.model.Category;
import servlet.mvc.rest.model.Inventory;
import servlet.mvc.rest.model.InventoryImage;
import servlet.mvc.rest.model.InventoryimageId;
import servlet.mvc.rest.model.State;
import servlet.mvc.rest.model.User;
import servlet.mvc.rest.model.UserLoginInfo;

public class InventoryManager {
	static InventoryDao dao = new InventoryDao();

	/**
	 * Fetches inventory by category
	 * 
	 * @return
	 */
	public Map<Integer, ArrayList<InventoryBean>> fetchInventoryForHomePage() {
		List<Inventory> inventories = dao.getInventoryForHomePage();
		Map<Integer, ArrayList<InventoryBean>> inventoryMap = new HashMap<Integer, ArrayList<InventoryBean>>();
		for (Inventory i : inventories) {
			InventoryBean ib = new InventoryBean();
			ib.setCategoryId(i.getCategory().getCategoryId());
			ib.setCategoryName(i.getCategory().getName());
			ib.setInventoryName(i.getName());
			ib.setItemId(i.getItemId());
			ib.setPrice(String.valueOf(i.getPrice()));
			ib.setRemainingQuantity(i.getRemainingQuantity());
			for (InventoryImage ii : i.getInventoryimages()) {
				if (ii.isRank()) {
					ib.setMainImage(ii.getImage());
				}
			}
			if (inventoryMap.containsKey(i.getCategory().getCategoryId())) {
				ArrayList<InventoryBean> ibList = inventoryMap.get(ib.getCategoryId());
				ibList.add(ib);
				inventoryMap.put(ib.getCategoryId(), ibList);
			} else {
				ArrayList<InventoryBean> ibList = new ArrayList<InventoryBean>();
				ibList.add(ib);
				inventoryMap.put(i.getCategory().getCategoryId(), ibList);
			}

		}
		return inventoryMap;
	}

	/**
	 * Saves the mdel bean for inventory to json.
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<InventoryBean> fetchInventoryByCategory(int id) {
		List<Inventory> inventories = dao.getInventoryByCat(id);
		ArrayList<InventoryBean> inventoryList = new ArrayList<InventoryBean>();
		for (Inventory i : inventories) {
			InventoryBean ib = new InventoryBean();
			ib.setCategoryId(i.getCategory().getCategoryId());
			ib.setCategoryName(i.getCategory().getName());
			ib.setInventoryName(i.getName());
			ib.setItemId(i.getItemId());
			ib.setPrice(String.valueOf(i.getPrice()));
			ib.setRemainingQuantity(i.getRemainingQuantity());
			for (InventoryImage ii : i.getInventoryimages()) {
				if (ii.isRank()) {
					ib.setMainImage(ii.getImage());
				}
			}
			inventoryList.add(ib);
		}
		return inventoryList;

	}

	public ItemDetailBean fetchMoreDetails(int itemId) {
		List<Inventory> inventories = dao.getMoreDetails(itemId);
		ItemDetailBean itemDetailBean = new ItemDetailBean();

		if (inventories != null & inventories.get(0) != null) {
			Inventory i = inventories.get(0);
			itemDetailBean.setCategoryId(i.getCategory().getCategoryId());
			itemDetailBean.setCategoryName(i.getCategory().getName());
			if (i.getDescription() != null && !i.getDescription().isEmpty())
				itemDetailBean.setDescription(i.getDescription());
			if (i.getInventoryimages() != null){
				ArrayList<String> images= new ArrayList<String>();
				for(InventoryImage ii: i.getInventoryimages()){
					images.add(ii.getImage());
				}
				itemDetailBean.setAllImages(images);
			}
			itemDetailBean.setInventoryName(i.getName());
			itemDetailBean.setItemId(itemId);
			if (i.getLocation() != null && !i.getLocation().isEmpty())
				itemDetailBean.setLocation(i.getLocation());
			for (InventoryImage ii : i.getInventoryimages()) {
				if (ii.isRank()) {
					itemDetailBean.setMainImage(ii.getImage());
				}
			}
			itemDetailBean.setPrice(String.valueOf(i.getPrice()));
			itemDetailBean.setRemainingQuantity(i.getRemainingQuantity());
			itemDetailBean.setSellerName(i.getUser().getName());
		}

		return itemDetailBean;
	}

	public ArrayList<InventoryBean> searchInventory(String inventoryName) {
		List<Inventory> inventories = dao.getInventoryByName(inventoryName);
		ArrayList<InventoryBean> inventoryList = new ArrayList<InventoryBean>();
		for (Inventory i : inventories) {
			InventoryBean ib = new InventoryBean();
			ib.setCategoryId(i.getCategory().getCategoryId());
			ib.setCategoryName(i.getCategory().getName());
			ib.setInventoryName(i.getName());
			ib.setItemId(i.getItemId());
			ib.setPrice(String.valueOf(i.getPrice()));
			ib.setRemainingQuantity(i.getRemainingQuantity());
			for (InventoryImage ii : i.getInventoryimages()) {
				if (ii.isRank()) {
					ib.setMainImage(ii.getImage());
				}
			}
			inventoryList.add(ib);
		}
		return inventoryList;
	}

	public Map<Integer, ArrayList<InventoryBean>> fetchInventoryForHomePage(Integer userId) {
		List<Inventory> inventories = dao.getInventoryForHomePage();
		Map<Integer, ArrayList<InventoryBean>> inventoryMap = new HashMap<Integer, ArrayList<InventoryBean>>();
		for (Inventory i : inventories) {
			if(i.getUser().getUid()!=userId){
				InventoryBean ib = new InventoryBean();
				ib.setCategoryId(i.getCategory().getCategoryId());
				ib.setCategoryName(i.getCategory().getName());
				ib.setInventoryName(i.getName());
				ib.setItemId(i.getItemId());
				ib.setPrice(String.valueOf(i.getPrice()));
				ib.setRemainingQuantity(i.getRemainingQuantity());
				for (InventoryImage ii : i.getInventoryimages()) {
					if (ii.isRank()) {
						ib.setMainImage(ii.getImage());
					}
				}
				if (inventoryMap.containsKey(i.getCategory().getCategoryId())) {
					ArrayList<InventoryBean> ibList = inventoryMap.get(ib.getCategoryId());
					ibList.add(ib);
					inventoryMap.put(ib.getCategoryId(), ibList);
				} else {
					ArrayList<InventoryBean> ibList = new ArrayList<InventoryBean>();
					ibList.add(ib);
					inventoryMap.put(i.getCategory().getCategoryId(), ibList);
				}
			}
		}
		return inventoryMap;
	}
	
	public String addItem(ItemDetailBean bean) {
		// TODO Auto-generated method stub
		String response = new String();
		
		/*State state = new State();
		state.setStateId(bean.getState());
		UserLoginInfo userLogin = new UserLoginInfo();
		userLogin.setUserName(bean.getUsername());
		userLogin.setPassword(bean.getPassword());
		Date bdate = new Date(bean.getBdate());
		
		User user = new User(state, userLogin, bean.getName(), bdate, bean.getPhone(),
				bean.getEmail(), bean.getStreet(), bean.getCity(), bean.getZipcode(), bean.getSex(), bean.getSsn(),
				new Date(), 0);*/
		
		Category categoryTrantiant = new Category();
		categoryTrantiant.setCategoryId(bean.getCategoryId());
		User userTrantiant = new User();
		userTrantiant.setUid(bean.getSellerId());
		
		Set <InventoryImage> iImage = new HashSet <InventoryImage>();
		ArrayList<String> allImages = bean.getAllImages();
		int i = 0;
		boolean flag = true;
		if (allImages != null && allImages.size()>0){
			for (String s : allImages){
				InventoryImage iImageIn = new InventoryImage();
				InventoryimageId iImageId = new InventoryimageId();
				iImageId.setItemId(bean.getItemId());
				iImageId.setImageId(i);
				i++;
				iImageIn.setId(iImageId);
				iImageIn.setImage(s);
				if (flag){
					iImageIn.setRank(true);
					flag = false;
				}
				iImage.add(iImageIn);
			}
		}
		
		Inventory newInventory = new Inventory();
		newInventory.setName(bean.getInventoryName());
		newInventory.setTotalQuantity(bean.getRemainingQuantity());
		newInventory.setRemainingQuantity(bean.getRemainingQuantity());
		newInventory.setDescription(bean.getDescription());
		newInventory.setCategory(categoryTrantiant);
		newInventory.setPrice(Float.valueOf(bean.getPrice()));
		newInventory.setUser(userTrantiant);
		newInventory.setDescription(bean.getDescription());
		if (iImage.size() > 0){
			newInventory.setInventoryimages(iImage);
		}
		newInventory.setLocation(bean.getLocation());
		response = dao.addInventoryToDatabase(newInventory, (HashSet<InventoryImage>) iImage);
		return response;
	}

}
