package cn.jbit.petshopping.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer id;
	private Dog dog;
	private Products products;
	private Userinfo userinfo;
	private Date creatime;
	private Double totalprice;
	private Integer sellcount;
	private Integer sellerconfirm;
	private Integer buyerconfirm;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(Date creatime, Double totalprice) {
		this.creatime = creatime;
		this.totalprice = totalprice;
	}

	/** full constructor */
	public Orders(Integer id, Dog dog, Products products, Userinfo userinfo,
			Date creatime, Double totalprice, Integer sellcount,
			Integer sellerconfirm, Integer buyerconfirm) {
		super();
		this.id = id;
		this.dog = dog;
		this.products = products;
		this.userinfo = userinfo;
		this.creatime = creatime;
		this.totalprice = totalprice;
		this.sellcount = sellcount;
		this.sellerconfirm = sellerconfirm;
		this.buyerconfirm = buyerconfirm;
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

	public Date getCreatime() {
		return this.creatime;
	}

	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}

	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public Integer getSellcount() {
		return sellcount;
	}

	public void setSellcount(Integer sellcount) {
		this.sellcount = sellcount;
	}

	public Integer getSellerconfirm() {
		if(sellerconfirm!=null){
			return sellerconfirm;
		}else{
			return 0;
		}
		
	}

	public void setSellerconfirm(Integer sellerconfirm) {
		this.sellerconfirm = sellerconfirm;
	}

	public Integer getBuyerconfirm() {
		if(buyerconfirm!=null){
			return buyerconfirm;
		}else{
			return 0;
		}
		
	}

	public void setBuyerconfirm(Integer buyerconfirm) {
		this.buyerconfirm = buyerconfirm;
	}
	
}