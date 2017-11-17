package cn.jbit.petshopping.dao;

import java.util.List;

import cn.jbit.petshopping.entity.Dogtype;

public interface DogTypeDao {
	/**
	 * 查找所有宠物种类（李凯）
	 */
	public List<Dogtype> findAllType();
	
	/**
	 * 根据ID查找宠物种类(李凯)
	 */
	public Dogtype findTypeById(Integer typeid);
	
	/**
	 * 添加宠物种类（李凯）
	 */
	public void addDogType(Dogtype type);
	
	/**
	 * 根据宠物种类名字查找宠物（李凯）
	 * 
	 */
	public Dogtype findDogType(String typeName);
	/**
	 * 更新dogtype的hotsell（热卖数量：李迎）
	 * @param dt
	 * @return
	 */
	public int updateId(Dogtype dt);
}
