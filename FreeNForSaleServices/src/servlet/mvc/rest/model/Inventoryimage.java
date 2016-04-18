package servlet.mvc.rest.model;// default package
// Generated Apr 17, 2016 3:22:53 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Inventoryimage generated by hbm2java
 */
@Entity
@Table(name = "inventoryimage", catalog = "freenforsale")
public class Inventoryimage implements java.io.Serializable {

	private InventoryimageId id;
	private Inventory inventory;
	private String image;
	private boolean rank;

	public Inventoryimage() {
	}

	public Inventoryimage(InventoryimageId id, Inventory inventory, String image, boolean rank) {
		this.id = id;
		this.inventory = inventory;
		this.image = image;
		this.rank = rank;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "itemId", column = @Column(name = "ItemId", nullable = false)),
			@AttributeOverride(name = "imageId", column = @Column(name = "ImageId", nullable = false)) })
	public InventoryimageId getId() {
		return this.id;
	}

	public void setId(InventoryimageId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ItemId", nullable = false, insertable = false, updatable = false)
	public Inventory getInventory() {
		return this.inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@Column(name = "Image", nullable = false, length = 100)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "Rank", nullable = false)
	public boolean isRank() {
		return this.rank;
	}

	public void setRank(boolean rank) {
		this.rank = rank;
	}

}
