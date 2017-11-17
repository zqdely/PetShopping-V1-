package cn.jbit.petshopping.web;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.jbit.petshopping.biz.OrderBiz;
import cn.jbit.petshopping.biz.ValuationBiz;
import cn.jbit.petshopping.biz.impl.OrderBizImpl;
import cn.jbit.petshopping.biz.impl.ValuationBizImpl;
import cn.jbit.petshopping.entity.Orders;
import cn.jbit.petshopping.entity.Valuation;

import com.opensymphony.xwork2.ActionSupport;

public class ValuationAction extends ActionSupport {
	private Integer orderid;
	private Orders order;
	private Valuation valuation;
	private OrderBiz ob=new OrderBizImpl();
	private ValuationBiz vb=new ValuationBizImpl();
	private int totalPageCount=1;//总页数
	private int pageSize=5;//一页显示多少条
	private int totalCount=0;//数据库总数量
	private int currpageNo=1;//页码
	private List<Valuation> valuations;
	private Integer id;
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

	public List<Valuation> getValuations() {
		return valuations;
	}

	public void setValuations(List<Valuation> valuations) {
		this.valuations = valuations;
	}

	public Valuation getValuation() {
		return valuation;
	}

	public void setValuation(Valuation valuation) {
		this.valuation = valuation;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	
	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String findOrder(){
		order=ob.findGoodById(orderid);
		if(order!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}
	
	public String addValuation(){
		if(valuation.getContent()==""||valuation.getContent()==null){
			return INPUT;
		}else{
			order=ob.findGoodById(orderid);
			Date date=new Date();
			valuation.setCreatetime(date);
			valuation.setUserinfo(order.getUserinfo());
			valuation.setDog(order.getDog());
			valuation.setProducts(order.getProducts());
			vb.addValuation(valuation);
			return SUCCESS;
		}
		
	}
	
	public String findValuations(){
		valuations=vb.valuationspage(pageSize, currpageNo);
		totalCount=vb.findTotalCount();
		totalPageCount=this.totalCount%pageSize==0?
				(this.totalCount/pageSize):this.totalCount/pageSize+1;
		if(valuations.size()>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String delete(){
		vb.deleteValuation(id);
		return SUCCESS;
	}
}
