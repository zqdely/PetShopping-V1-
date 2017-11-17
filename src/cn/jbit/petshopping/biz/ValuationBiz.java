package cn.jbit.petshopping.biz;

import java.util.List;

import cn.jbit.petshopping.entity.Valuation;

public interface ValuationBiz {
	/**
	 * 添加评论（李凯）
	 */
	public void addValuation(Valuation valuation);
	
	/**
	 * 根据ID删除评论（李凯）
	 */
	public void deleteValuation(Integer id);
	
	/**
	 * 分页查询数据（李凯）
	 * @return
	 */
	public List<Valuation> valuationspage(int pagesize,int pageindex);
	/**
	 * 宠物的总数量（李凯）
	 * 
	 */
	public int findTotalCount();
}
