package cn.jbit.petshopping.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Valuation entity. @author MyEclipse Persistence Tools
 */

public class Valuation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Dog dog;
	private Products products;
	private Userinfo userinfo;
	private String content;
	private Date createtime;

	// Constructors

	/** default constructor */
	public Valuation() {
	}

	/** minimal constructor */
	public Valuation(Userinfo userinfo, String content, Date createtime) {
		this.userinfo = userinfo;
		this.content = content;
		this.createtime = createtime;
	}

	/** full constructor */
	public Valuation(Dog dog, Products products, Userinfo userinfo,
			String content, Date createtime) {
		this.dog = dog;
		this.products = products;
		this.userinfo = userinfo;
		this.content = content;
		this.createtime = createtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dog getDog() {
		return this.dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}