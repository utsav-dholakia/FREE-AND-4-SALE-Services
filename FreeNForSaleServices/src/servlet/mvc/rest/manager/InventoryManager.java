package servlet.mvc.rest.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import servlet.mvc.rest.beans.InventoryBean;
import servlet.mvc.rest.beans.ItemDetailBean;
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


	/**
	 * Saves the mdel bean for inventory to json.
	 * @param id
	 * @return
	 */
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


	public ItemDetailBean fetchMoreDetails(int itemId) {
		List <Inventory> inventories =dao.getMoreDetails(itemId);
   	 	ItemDetailBean itemDetailBean= new ItemDetailBean();

        if(inventories!=null & inventories.get(0)!=null){
             Inventory i= inventories.get(0);
             itemDetailBean.setCategoryId(i.getCategory().getCategoryId());
             itemDetailBean.setCategoryName(i.getCategory().getName());
             if(i.getDescription()!=null && !i.getDescription().isEmpty())
             itemDetailBean.setDescription(i.getDescription());
             if(i.getInventoryimages()!=null)
             itemDetailBean.setInventoryimages(i.getInventoryimages());
             itemDetailBean.setInventoryName(i.getName());
             itemDetailBean.setItemId(itemId);
             if(i.getLocation()!=null && !i.getLocation().isEmpty())
             itemDetailBean.setLocation(i.getLocation());
             for(InventoryImage ii: i.getInventoryimages()){
 				if(ii.isRank()){
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
		List <Inventory> inventories = dao.getInventoryByName(inventoryName);
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
