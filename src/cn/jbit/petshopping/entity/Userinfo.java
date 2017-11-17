package cn.jbit.petshopping.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import cn.jbit.petshopping.util.MD5Secret;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private String email;
	private String address;
	private String phone;
	private String sex;
	private Integer isadmin;
	private Integer activation;
	private Set valuations = new HashSet(0);
	private Set orderses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String name, String password, String email, Integer isadmin) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.isadmin = isadmin;
	}

	/** full constructor */
	public Userinfo(String name, String password, String email, String address,
			String phone, String sex, Integer isadmin, Integer activation,
			Set valuations, Set orderses) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.sex = sex;
		this.isadmin = isadmin;
		this.activation = activation;
		this.valuations = valuations;
		this.orderses = orderses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		if(password.toString().length()==32){
			 this.password = password;
		}else{
			//调用加密函数
	        this.password = MD5Secret.string2MD5(password);
		}
	    	
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getIsadmin() {
		if(isadmin == null){
			return 0;
		}else{
			return this.isadmin;
		}
	}

	public void setIsadmin(Integer isadmin) {
		this.isadmin = isadmin;
	}

	public Integer getActivation() {
		if(activation == null){
			return 0;
		}else{
			return this.activation;
		}	
	}

	public void setActivation(Integer activation) {
		this.activation = activation;
	}

	public Set getValuations() {
		return this.valuations;
	}

	public void setValuations(Set valuations) {
		this.valuations = valuations;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

}