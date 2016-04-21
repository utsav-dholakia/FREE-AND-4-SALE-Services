package servlet.mvc.rest.model;// default package
// Generated Apr 17, 2016 3:22:53 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Inventory generated by hbm2java
 */
@Entity
@Table(name = "Inventory", catalog = "FreeNForSale")
public class Inventory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3684866718203505294L;

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ItemId", unique = true, nullable = false)
	private Integer itemId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CategoryId", nullable = false)
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SellerId", nullable = false)
	private User user;

	@Column(name = "Name", nullable = false, length = 50)
	private String name;

	@Column(name = "TotalQuantity", nullable = false)
	private int totalQuantity;

	@Column(name = "RemainingQuantity", nullable = false)
	private int remainingQuantity;

	@Column(name = "Description", nullable = false, length = 200)
	private String description;

	@Column(name = "Price", nullable = false, precision = 12, scale = 0)
	private float price;

	@Column(name = "Location", nullable = false, length = 50)
	private String location;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventory")
	private Set<Transaction> transactions = new HashSet<Transaction>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventory")
	private Set<Cart> carts = new HashSet<Cart>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "inventory")
	private Set<InventoryImage> inventoryimages = new HashSet<InventoryImage>(0);

	public Inventory() {
	}

	public Inventory(Category category, User user, String name, int totalQuantity, int remainingQuantity,
			String description, float price, String location) {
		this.category = category;
		this.user = user;
		this.name = name;
		this.totalQuantity = totalQuantity;
		this.remainingQuantity = remainingQuantity;
		this.description = description;
		this.price = price;
		this.location = location;
	}

	/*public Inventory(Category category, User user, String name, int totalQuantity, int remainingQuantity,
			String description, float price, String location, Set transactions, Set carts, Set inventoryimages) {
		this.category = category;
		this.user = user;
		this.name = name;
		this.totalQuantity = totalQuantity;
		this.remainingQuantity = remainingQuantity;
		this.description = description;
		this.price = price;
		this.location = location;
		this.transactions = transactions;
		this.carts = carts;
		this.inventoryimages = inventoryimages;
	}
*/

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalQuantity() {
		return this.totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public int getRemainingQuantity() {
		return this.remainingQuantity;
	}

	public void setRemainingQuantity(int remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Set<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Set<InventoryImage> getInventoryimages() {
		return this.inventoryimages;
	}

	public void setInventoryimages(Set<InventoryImage> inventoryimages) {
		this.inventoryimages = inventoryimages;
	}

}
