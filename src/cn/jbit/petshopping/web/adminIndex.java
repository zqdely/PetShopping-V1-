package cn.jbit.petshopping.web;

import java.util.List;

import cn.jbit.petshopping.biz.OrderBiz;
import cn.jbit.petshopping.biz.UserinfoBiz;
import cn.jbit.petshopping.biz.impl.OrderBizImpl;
import cn.jbit.petshopping.biz.impl.UserinfoBizImpl;
import cn.jbit.petshopping.entity.Userinfo;

import com.opensymphony.xwork2.ActionSupport;

public class adminIndex extends ActionSupport {
	private int[] result;
	private int totalPageCount=1;//总页数
	private int pageSize=5;//一页显示多少条
	private int totalCount=0;//数据库总数量
	private int currpageNo=1;//页码
	private List<Userinfo> users;
	private UserinfoBiz ub=new UserinfoBizImpl();
	public List<Userinfo> getUsers() {
		
		return ub.adminindexpage(pageSize, currpageNo);
	}

	public void setUsers(List<Userinfo> users) {
		this.users = users;
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
		totalCount=ub.findTotalCount();
		this.totalCount = totalCount;
		
	}

	public int getCurrpageNo() {
		return currpageNo;
	}

	public void setCurrpageNo(int currpageNo) {
		this.currpageNo = currpageNo;
	}

	public int[] getResult() {
		return result;
	}

	public void setResult(int[] result) {
		this.result = result;
	}
	/**
	 * chart图标中添加的四个季度的数据
	 * @return
	 */
	/*public String chartinfo(){
		OrderBiz ob = new OrderBizImpl();
		result = ob.SellCount();	
		return SUCCESS;
	}*/
	
	public String page(){
		users=this.getUsers();
		totalCount=ub.findTotalCount();
		totalPageCount=this.totalCount%pageSize==0?
				(this.totalCount/pageSize):this.totalCount/pageSize+1;
		if(users.size()>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
