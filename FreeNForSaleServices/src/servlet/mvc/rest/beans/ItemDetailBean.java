package servlet.mvc.rest.beans;

import java.util.Set;

import servlet.mvc.rest.model.InventoryImage;

public class ItemDetailBean {
	private int itemId;
	private int categoryId;
	private String categoryName;
	private String InventoryName;
	private String price;
	private int remainingQuantity;
	private String mainImage;
	private String sellerName;
	private String description;
	private String location;
	private Set<InventoryImage> inventoryimages;

	
	public String getMainImage() {
		return mainImage;
	}
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getInventoryName() {
		return InventoryName;
	}
	public void setInventoryName(String inventoryName) {
		InventoryName = inventoryName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getRemainingQuantity() {
		return remainingQuantity;
	}
	public void setRemainingQuantity(int remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Set<InventoryImage> getInventoryimages() {
		return inventoryimages;
	}
	public void setInventoryimages(Set<InventoryImage> inventoryimages) {
		this.inventoryimages = inventoryimages;
	}

}
