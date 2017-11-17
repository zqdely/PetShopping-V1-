package cn.jbit.petshopping.biz;

import java.util.List;

import cn.jbit.petshopping.entity.Dog;

public interface DogBiz {
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
	 * 根据ID查找用户（李凯）
	 * @return
	 */
	public Dog findById(Integer id);
	
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
	/**
     * 根据狗狗种类ID查找商品(王博)
     */
	public List<Dog> fingByTypeId(Integer typeid);
}
