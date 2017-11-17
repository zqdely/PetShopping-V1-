package cn.jbit.petshopping.biz.impl;

import java.util.List;

import cn.jbit.petshopping.biz.DogBiz;
import cn.jbit.petshopping.dao.DogDao;
import cn.jbit.petshopping.dao.DogTypeDao;
import cn.jbit.petshopping.dao.impl.DogDaoImpl;
import cn.jbit.petshopping.dao.impl.DogTypeDaoImpl;
import cn.jbit.petshopping.entity.Dog;
import cn.jbit.petshopping.entity.Dogtype;

public class DogBizImpl implements DogBiz {
	private DogDao dd=new DogDaoImpl();
	private DogTypeDao dtd=new DogTypeDaoImpl();
	/**
	 * 保存宠物（李凯）
	 */
	public int saveDog(Dog dog){
		int num=dd.saveDog(dog);
		return num;
	}
	/**
	 * 分页查询数据（李凯）
	 * @return
	 */
	public List<Dog> dogspage(int pagesize,int pageindex){
		return dd.dogspage(pagesize, pageindex);
	}
	/**
	 * 宠物的总数量（李凯）
	 * 
	 */
	public int findTotalCount(){
		return dd.findTotalCount();
	}
	/**
	 * 根据ID查找用户（李凯）
	 * @return
	 */
	public Dog findById(Integer id){
		return dd.findById(id);
	}
	
	/**
	 * 修改宠物（李凯）
	 */
	public int updateDog(Dog dog){
		int num=dd.updateDog(dog);
		return num;
	}
	
	/**
	 * 根据ID删除宠物（李凯）
	 */
	public void delete(Integer id){
		dd.delete(id);
	}
	/**
	 * 查询狗狗新品(李迎)
	 */
	public List<Dog> hotThreeDog() {
		List<Dog> dog = dd.hotThreeDog();
		return dog;
	}
	/**
     * 根据狗狗种类ID查找商品(王博)
     */
	public List<Dog> fingByTypeId(Integer typeid){
		Dogtype dogtype=dtd.findTypeById(typeid);
		List<Dog> dog=dd.findByTypeId(dogtype);
		return dog;
	}
}
