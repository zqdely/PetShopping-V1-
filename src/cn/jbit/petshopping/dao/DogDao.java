package cn.jbit.petshopping.dao;

import java.util.List;

import cn.jbit.petshopping.entity.Dog;
import cn.jbit.petshopping.entity.Dogtype;
import cn.jbit.petshopping.entity.Userinfo;

public interface DogDao {
	/**
	 * 保存宠物（李凯）
	 */
	public int saveDog(Dog dog);
	
	/**
	 * 分页查询数据（李凯）
	 * @return
	 */
	public List<Dog> dogspage(int pagesize,int pageindex);
	/**
	 * 宠物的总数量（李凯）
	 * 
	 */
	public int findTotalCount();
	/**
	 * 根据ID查找狗狗（李凯）
	 * @return
	 */
	public Dog findById(Integer id);
	/**
	 * 根据狗的类型查找用户（王博）
	 * @return
	 */
	public List<Dog> findByTypeId(Dogtype dogtype);
	
	/**
	 * 修改宠物（李凯）
	 */
	public int updateDog(Dog dog);
	
	/**
	 * 根据ID删除宠物（李凯）
	 */
	public void delete(Integer id);
	/**
	 * 查询狗狗新品(李迎)
	 * @return
	 */
	public List<Dog> hotThreeDog();
}

