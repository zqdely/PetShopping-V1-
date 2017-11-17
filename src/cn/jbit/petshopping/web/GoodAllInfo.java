package cn.jbit.petshopping.web;

import java.util.Map;

import cn.jbit.petshopping.biz.DogBiz;
import cn.jbit.petshopping.biz.impl.DogBizImpl;
import cn.jbit.petshopping.dao.ProductsDao;
import cn.jbit.petshopping.dao.impl.ProductsDaoImpl;
import cn.jbit.petshopping.entity.Dog;
import cn.jbit.petshopping.entity.Products;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GoodAllInfo extends ActionSupport {
	private Products products;
	private int productid;
	private Dog dog;
	private String type;

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
	
	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public String GoodInfo(){
		//创建session，保存类型
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("type", type);
		if(type.equals("dog")){
			DogBiz db = new DogBizImpl();
			dog = db.findById(productid);
			if(dog!=null){
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			ProductsDao pd = new ProductsDaoImpl();
			products = pd.fingById(productid);
			if(products.getName()!=null){
				return SUCCESS;
			}else{
				return ERROR;
			}
		}
		
		
	}
}
