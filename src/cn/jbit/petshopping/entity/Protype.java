package cn.jbit.petshopping.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Protype entity. @author MyEclipse Persistence Tools
 */

public class Protype implements java.io.Serializable {

	// Fields

	private Integer protypeid;
	private String protypename;
	private Set productses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Protype() {
	}

	/** minimal constructor */
	public Protype(String protypename) {
		this.protypename = protypename;
	}

	/** full constructor */
	public Protype(String protypename, Set productses) {
		this.protypename = protypename;
		this.productses = productses;
	}

	// Property accessors

	public Integer getProtypeid() {
		return this.protypeid;
	}

	public void setProtypeid(Integer protypeid) {
		this.protypeid = protypeid;
	}

	public String getProtypename() {
		return this.protypename;
	}

	public void setProtypename(String protypename) {
		this.protypename = protypename;
	}

	public Set getProductses() {
		return this.productses;
	}

	public void setProductses(Set productses) {
		this.productses = productses;
	}

}