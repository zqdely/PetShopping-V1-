package cn.jbit.petshopping.web;

import java.util.List;
import java.util.Map;

import cn.jbit.petshopping.biz.OrderBiz;
import cn.jbit.petshopping.biz.UserinfoBiz;
import cn.jbit.petshopping.biz.impl.OrderBizImpl;
import cn.jbit.petshopping.biz.impl.UserinfoBizImpl;
import cn.jbit.petshopping.entity.Orders;
import cn.jbit.petshopping.entity.Userinfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	private List<Orders> orders;
	private Integer id;
	private OrderBiz ob=new OrderBizImpl();
	private int totalPageCount=1;//总页数
	private int pageSize=5;//一页显示多少条
	private int totalCount=0;//数据库总数量
	private int currpageNo=1;//页码
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		this.totalCount = totalCount;
	}

	public int getCurrpageNo() {
		return currpageNo;
	}

	public void setCurrpageNo(int currpageNo) {
		this.currpageNo = currpageNo;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	public String findOrders(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		orders=ob.orderspage(pageSize, currpageNo,(Userinfo)session.get("userinfo"));
		totalCount=ob.findTotalCount((Userinfo)session.get("userinfo"));
		totalPageCount=this.totalCount%pageSize==0?
				(this.totalCount/pageSize):this.totalCount/pageSize+1;
		return SUCCESS;
	}
	
	public String delete(){
		ob.deleteorder(id);
		return SUCCESS;
	}
}
