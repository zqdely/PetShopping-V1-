package cn.jbit.petshopping.web;

import java.util.List;

import cn.jbit.petshopping.biz.DogBiz;
import cn.jbit.petshopping.biz.ProductsBiz;
import cn.jbit.petshopping.biz.impl.DogBizImpl;
import cn.jbit.petshopping.biz.impl.ProductsBizImpl;
import cn.jbit.petshopping.entity.Dog;
import cn.jbit.petshopping.entity.Products;

import com.opensymphony.xwork2.ActionSupport;

public class UserIndex extends ActionSupport {
	private List<Products> product;
	private List<Dog> dog;
	private String info;
	public List<Products> getProduct() {
		return product;
	}
	public void setProduct(List<Products> product) {
		this.product = product;
	}
	public List<Dog> getDog() {
		return dog;
	}
	public void setDog(List<Dog> dog) {
		this.dog = dog;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * 查询最新的6条产品和最新的三条狗狗
	 * @return
	 */
	public String loadDate(){
		DogBiz dd = new DogBizImpl();
	 	dog = dd.hotThreeDog();
	 	ProductsBiz pb = new ProductsBizImpl();
	 	product = pb.HotProduct();
	 	if(dog.size()!=0&&product.size()!=0)
	 		return SUCCESS;
	 	else{
	 		info = "页面加载错误，请联系管理员";
	 		return ERROR;
	 	}
	 	
	}
}
