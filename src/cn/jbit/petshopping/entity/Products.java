package cn.jbit.petshopping.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Products entity. @author MyEclipse Persistence Tools
 */

public class Products implements java.io.Serializable {

	// Fields

	private Integer productid;
	private Protype protype;
	private String name;
	private Double price;
	private String picture;
	private String intro;
	private String info;
	private Integer prosellcount;
	private Integer procount;
	private Set orderses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Products() {
	}

	/** minimal constructor */
	public Products(Protype protype, String name, Double price,
			String picture, String intro, String info) {
		this.protype = protype;
		this.name = name;
		this.price = price;
		this.picture = picture;
		this.intro = intro;
		this.info = info;
	}

	/** full constructor */
	public Products(Protype protype, String name, Double price,
			String picture, String intro, String info, Set orderses) {
		this.protype = protype;
		this.name = name;
		this.price = price;
		this.picture = picture;
		this.intro = intro;
		this.info = info;
		this.orderses = orderses;
	}

	// Property accessors

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Protype getProtype() {
		return this.protype;
	}

	public void setProtype(Protype protype) {
		this.protype = protype;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	public Integer getProsellcount() {
		return prosellcount;
	}

	public void setProsellcount(Integer prosellcount) {
		this.prosellcount = prosellcount;
	}

	public Integer getProcount() {
		return procount;
	}

	public void setProcount(Integer procount) {
		this.procount = procount;
	}

}