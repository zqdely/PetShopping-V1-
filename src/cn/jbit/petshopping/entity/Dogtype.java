package cn.jbit.petshopping.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Dogtype entity. @author MyEclipse Persistence Tools
 */

public class Dogtype implements java.io.Serializable {

	// Fields

	private Integer typeid;
	private String typename;
	private Integer hotsell;
	private Set dogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Dogtype() {
	}

	/** full constructor */
	public Dogtype(String typename, Set dogs) {
		this.typename = typename;
		this.dogs = dogs;
	}

	// Property accessors

	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Set getDogs() {
		return this.dogs;
	}

	public void setDogs(Set dogs) {
		this.dogs = dogs;
	}

	public Integer getHotsell() {
		return hotsell;
	}

	public void setHotsell(Integer hotsell) {
		this.hotsell = hotsell;
	}
	
}