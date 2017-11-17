package cn.jbit.petshopping.dao;

import java.util.List;

import cn.jbit.petshopping.entity.Dog;
import cn.jbit.petshopping.entity.Userinfo;
import cn.jbit.petshopping.entity.Valuation;

public interface ValuationDao {
	/**
	 * 添加评论（李凯）
	 */
	public void addValuation(Valuation valuation);
	
	/**
	 * 根据ID查找评论(李凯)
	 */
	public Valuation findValuation(Integer id);
	
	/**
	 * 删除评论（李凯）
	 */
	public void deleteValuation(Valuation valuation);
	
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

