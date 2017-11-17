package cn.jbit.petshopping.web;


import java.util.List;

import cn.jbit.petshopping.biz.DogBiz;
import cn.jbit.petshopping.biz.ProductsBiz;
import cn.jbit.petshopping.biz.impl.DogBizImpl;
import cn.jbit.petshopping.biz.impl.ProductsBizImpl;
import cn.jbit.petshopping.entity.Dog;
import cn.jbit.petshopping.entity.Products;

import com.opensymphony.xwork2.ActionSupport;

public class DogOrProductsAction extends ActionSupport{
	private Integer ptypeid; //接收JSP页面传来的ID值
	private Integer dtypeid;
	private List<Dog> dogs;
	private List<Products> products;
	private ProductsBiz pb=new ProductsBizImpl();
	private DogBiz db=new DogBizImpl();
		
	public Integer getPtypeid() {
		return ptypeid;
	}

	public void setPtypeid(Integer ptypeid) {
		this.ptypeid = ptypeid;
	}

	public Integer getDtypeid() {
		return dtypeid;
	}

	public void setDtypeid(Integer dtypeid) {
		this.dtypeid = dtypeid;
	}
    
	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	/**
	 * 根据商品类型id查询商品信息显示在输入框（王博）
	 * @return
	 */
	public String fingByType(){
		if(ptypeid==null && dtypeid==null){
			return INPUT;
		}else if(ptypeid==null){
			dogs=db.fingByTypeId(dtypeid);
			if(dogs!=null){
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			products=pb.fingByTypeId(ptypeid);
			if(products!=null){
				return SUCCESS;
			}else{
				return ERROR;
			}
		}
		
	}
}

