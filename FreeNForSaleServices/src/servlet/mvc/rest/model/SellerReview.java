package servlet.mvc.rest.model;// default package
// Generated Apr 17, 2016 3:22:53 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Sellerreview generated by hbm2java
 */
@Entity
@Table(name = "SellerReview", catalog = "FreeNForSale")
public class SellerReview implements java.io.Serializable {

	private int sellerId;
	private User userByUid;
	private User userByUid_1;
	private int rating;
	private String comment;

	public SellerReview() {
	}

	public SellerReview(User userByUid, User userByUid_1, int rating) {
		this.userByUid = userByUid;
		this.userByUid_1 = userByUid_1;
		this.rating = rating;
	}

	public SellerReview(User userByUid, User userByUid_1, int rating, String comment) {
		this.userByUid = userByUid;
		this.userByUid_1 = userByUid_1;
		this.rating = rating;
		this.comment = comment;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "userByUid"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "SellerId", unique = true, nullable = false)
	public int getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public User getUserByUid() {
		return this.userByUid;
	}

	public void setUserByUid(User userByUid) {
		this.userByUid = userByUid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UId", nullable = false)
	public User getUserByUid_1() {
		return this.userByUid_1;
	}

	public void setUserByUid_1(User userByUid_1) {
		this.userByUid_1 = userByUid_1;
	}

	@Column(name = "Rating", nullable = false)
	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Column(name = "Comment", length = 150)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}