package cn.jbit.petshopping.biz.impl;

import java.util.List;

import cn.jbit.petshopping.biz.ValuationBiz;
import cn.jbit.petshopping.dao.ValuationDao;
import cn.jbit.petshopping.dao.impl.ValuationDaoImpl;
import cn.jbit.petshopping.entity.Valuation;

public class ValuationBizImpl implements ValuationBiz {
	private ValuationDao vd=new ValuationDaoImpl();
	/**
	 * 添加评论（李凯）
	 */
	public void addValuation(Valuation valuation){
		vd.addValuation(valuation);
	}
	/**
	 * 根据ID删除评论（李凯）
	 */
	public void deleteValuation(Integer id){
		vd.deleteValuation(vd.findValuation(id));
	}
	
	/**
	 * 分页查询数据（李凯）
	 * @return
	 */
	public List<Valuation> valuationspage(int pagesize,int pageindex){
		return vd.valuationspage(pagesize, pageindex);
	}
	/**
	 * 宠物的总数量（李凯）
	 * 
	 */
	public int findTotalCount(){
		return vd.findTotalCount();
	}
}
