package cn.jbit.petshopping.web;





import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.jbit.petshopping.biz.DogBiz;
import cn.jbit.petshopping.biz.DogTypeBiz;
import cn.jbit.petshopping.biz.UserinfoBiz;
import cn.jbit.petshopping.biz.impl.DogBizImpl;
import cn.jbit.petshopping.biz.impl.DogTypeBizImpl;
import cn.jbit.petshopping.biz.impl.UserinfoBizImpl;
import cn.jbit.petshopping.entity.Dog;
import cn.jbit.petshopping.entity.Dogtype;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateDogAction extends ActionSupport{
	private Integer id;
	private Dog dog;
	private int totalPageCount=1;//总页数
	private int pageSize=5;//一页显示多少条
	private int totalCount=0;//数据库总数量
	private int currpageNo=1;//页码
	private List<Dog> dogs;
	private DogBiz db=new DogBizImpl();
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
		totalCount=db.findTotalCount();
		this.totalCount = totalCount;
	}
	public int getCurrpageNo() {
		return currpageNo;
	}
	public void setCurrpageNo(int currpageNo) {
		this.currpageNo = currpageNo;
	}
	public List<Dog> getDogs() {
		return db.dogspage(pageSize, currpageNo);
	}
	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}
	
	public String dogsPage(){
		dogs=this.getDogs();
		totalCount=db.findTotalCount();
		totalPageCount=this.totalCount%pageSize==0?
				(this.totalCount/pageSize):this.totalCount/pageSize+1;
		if(dogs.size()>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String updatedog(){
		dog=db.findById(id);
		return SUCCESS;
	}
	
	public String delete(){
		db.delete(id);
		return SUCCESS;
	}
}

