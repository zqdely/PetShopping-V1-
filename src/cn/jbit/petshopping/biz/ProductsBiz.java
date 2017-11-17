package cn.jbit.petshopping.biz;

import java.util.List;

import cn.jbit.petshopping.entity.Products;

public interface ProductsBiz {
	/**
	 * 用于添加商品（王博）
	 * @return
	 */
	public int save(Products products); 
	/**
	 * 查找所有商品（王博）
	 * @return
	 */
	public List<Products> fingAll();
	/**
     * 根据商品ID查找商品
     */
	public Products fingById(Integer productid);
	/**
     * 根据商品种类ID查找商品
     */
	public List<Products> fingByTypeId(Integer protypeid);
	/**
	 *根据商品ID删除商品
	 */
	public int delete(Integer productid);
	/**
	 *修改商品
	 */
	public int update(Products products);
	/**
	 * 获取当前页要显示的数据（王博）
	 * pagesize 一页显示几条
	 * pageindex  第几页
	 * @return
	 */
	public List<Products> adminindexpage(int pagesize,int pageindex);
	/**
	 * 商品的总数量（王博）
	 * 
	 */
	public int findTotalCount();
	/**
	 * 查询销售量最大前六个商品(李迎)
	 * @return
	 */
	public List<Products> HotProduct();
	/**
	 * 更新销售数量+1&库存-1
	 * @param pro
	 * @return
	 */
	public int updatehotsell(Products pro);
}
