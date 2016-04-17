package servlet.mvc.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Column(name = "dname")
	private String dname;
	
	@Id
	@Column(name = "dnumber")
	private int dnumber;
	
	@Column(name = "mgrssn")
	private String mgrssn;
	
	@Column(name = "mgrstartdate")
	private Date mgrstrtdate;
	
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getDnumber() {
		return dnumber;
	}
	public void setDnumber(int dnumber) {
		this.dnumber = dnumber;
	}
	public String getMgrssn() {
		return mgrssn;
	}
	public void setMgrssn(String mgrssn) {
		this.mgrssn = mgrssn;
	}
	public Date getMgrstrtdate() {
		return mgrstrtdate;
	}
	public void setMgrstrtdate(Date mgrstrtdate) {
		this.mgrstrtdate = mgrstrtdate;
	}
	
}
