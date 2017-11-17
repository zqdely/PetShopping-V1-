package cn.jbit.petshopping.dao;

import java.util.List;

import cn.jbit.petshopping.entity.Protype;

public interface ProtypeDao {
	/**
	 * 用于查询所有商品种类（王博）
	 * @return
	 */
	public List<Protype> fingAll(); 
	/**
	 * 用于通过商品种类ID查询（王博）
	 * @return
	 */
	public Protype fingById(Integer protypeid);
	/**
	 * 添加商品种类（王博）
	 * @return
	 */
	public int save(Protype protype);
	/**
	 * 用于通过商品种类名字查询（王博）
	 * @return
	 */
	public Protype fingByName(String name);
	/**
	 * 删处商品种类（王博）
	 * @return
	 */
	//public int delete(Protype protype);
	/**
	 * 修改商品种类（王博）
	 * @return
	 */
	//public int update(Protype protype);
}
