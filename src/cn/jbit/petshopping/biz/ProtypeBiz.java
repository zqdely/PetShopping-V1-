package cn.jbit.petshopping.biz;

import java.util.List;

import cn.jbit.petshopping.entity.Protype;

public interface ProtypeBiz {
	/**
	 * 用于查询所有商品种类（王博）
	 * @return
	 */
	public List<Protype> fingAll(); 
	/**
	 * 用于通过名字查询商品种类（王博）
	 * @return
	 */
	public Protype fingById(Integer protypeid);
	/**
	 * 添加商品种类（王博）
	 * @return
	 */
	public int save(Protype protype,String name);
}
