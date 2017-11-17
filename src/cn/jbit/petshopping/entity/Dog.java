package cn.jbit.petshopping.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Dog entity. @author MyEclipse Persistence Tools
 */

public class Dog implements java.io.Serializable {

	// Fields

	private Integer dogid;
	private Dogtype dogtype;
	private String dogname;
	private Double price;
	private Date brithday;
	private String picture;
	private String intro;
	private String info;
	private Set orderses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Dog() {
	}

	/** minimal constructor */
	public Dog(Dogtype dogtype, String dogname, Double price,
			Date brithday, String picture) {
		this.dogtype = dogtype;
		this.dogname = dogname;
		this.price = price;
		this.brithday = brithday;
		this.picture = picture;
	}

	/** full constructor */
	public Dog(Dogtype dogtype, String dogname, Double price,
			Date brithday, String picture, String intro, String info,
			Set orderses) {
		this.dogtype = dogtype;
		this.dogname = dogname;
		this.price = price;
		this.brithday = brithday;
		this.picture = picture;
		this.intro = intro;
		this.info = info;
		this.orderses = orderses;
	}

	// Property accessors

	public Integer getDogid() {
		return this.dogid;
	}

	public void setDogid(Integer dogid) {
		this.dogid = dogid;
	}

	public Dogtype getDogtype() {
		return this.dogtype;
	}

	public void setDogtype(Dogtype dogtype) {
		this.dogtype = dogtype;
	}

	public String getDogname() {
		return this.dogname;
	}

	public void setDogname(String dogname) {
		this.dogname = dogname;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getBrithday() {
		return this.brithday;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
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


}