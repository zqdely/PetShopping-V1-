package cn.jbit.petshopping.web;

import java.util.List;

import cn.jbit.petshopping.biz.ProductsBiz;
import cn.jbit.petshopping.biz.impl.ProductsBizImpl;
import cn.jbit.petshopping.entity.Products;

import com.opensymphony.xwork2.ActionSupport;

public class ProductsIndex extends ActionSupport {
	private int totalPageCount=1;//总页数
	private int pageSize=5;//一页显示多少条
	private int totalCount=0;//数据库总数量
	private int currpageNo=1;//页码
	private List<Products> products;
	private ProductsBiz pb=new ProductsBizImpl();
	public List<Products> getProducts() {
		return pb.adminindexpage(pageSize, currpageNo);
	}

	public void setUsers(List<Products> products) {
		this.products = products;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
		
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		totalCount=pb.findTotalCount();
		this.totalCount = totalCount;
		
	}

	public int getCurrpageNo() {
		return currpageNo;
	}

	public void setCurrpageNo(int currpageNo) {
		this.currpageNo = currpageNo;
	}

	
	public String page(){
		products=this.getProducts();
		totalCount=pb.findTotalCount();
		totalPageCount=this.totalCount%pageSize==0?
				(this.totalCount/pageSize):this.totalCount/pageSize+1;
		if(products.size()>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
