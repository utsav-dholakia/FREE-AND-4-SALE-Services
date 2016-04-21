package servlet.mvc.rest.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import servlet.mvc.rest.beans.InventoryBean;
import servlet.mvc.rest.dao.InventoryDao;
import servlet.mvc.rest.model.Inventory;
import servlet.mvc.rest.model.InventoryImage;

public class InventoryManager {
	static InventoryDao dao =  new InventoryDao();
	

	/**
	 * Fetches inventory by category
	 * @return
	 */
	public Map<Integer,ArrayList<InventoryBean>> fetchInventoryForHomePage() {
		List <Inventory> inventories = dao.getInventoryForHomePage();
		Map<Integer,ArrayList<InventoryBean>> inventoryMap = new HashMap<Integer,ArrayList<InventoryBean>>();
		for(Inventory i:inventories){
			InventoryBean ib= new InventoryBean();
			ib.setCategoryId(i.getCategory().getCategoryId());
			ib.setCategoryName(i.getCategory().getName());
			ib.setInventoryName(i.getName());
			ib.setItemId(i.getItemId());
			ib.setPrice(String.valueOf(i.getPrice()));
			ib.setRemainingQuantity(i.getRemainingQuantity());
			for(InventoryImage ii: i.getInventoryimages()){
				if(ii.isRank()){
					ib.setMainImage(ii.getImage());
				}
			}
			if(inventoryMap.containsKey(i.getCategory().getCategoryId())){
				ArrayList<InventoryBean> ibList=inventoryMap.get(ib.getCategoryId());
				ibList.add(ib);
				inventoryMap.put(ib.getCategoryId(), ibList);
			}else{
				ArrayList<InventoryBean> ibList=new ArrayList<InventoryBean>();
				ibList.add(ib);
				inventoryMap.put(i.getCategory().getCategoryId(), ibList);
			}
			
		}
		return inventoryMap;
	}


	public ArrayList<InventoryBean> fetchInventoryByCategory(int id) {
		List <Inventory> inventories = dao.getInventoryByCat(id);
		ArrayList<InventoryBean> inventoryList = new ArrayList<InventoryBean>();
		for(Inventory i:inventories){
			InventoryBean ib= new InventoryBean();
			ib.setCategoryId(i.getCategory().getCategoryId());
			ib.setCategoryName(i.getCategory().getName());
			ib.setInventoryName(i.getName());
			ib.setItemId(i.getItemId());
			ib.setPrice(String.valueOf(i.getPrice()));
			ib.setRemainingQuantity(i.getRemainingQuantity());
			for(InventoryImage ii: i.getInventoryimages()){
				if(ii.isRank()){
					ib.setMainImage(ii.getImage());
				}
			}
			inventoryList.add(ib);
		}
		return inventoryList;
		
	}

}
