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
	 * ���������
	 */
	public int saveDog(Dog dog){
		int num=dd.saveDog(dog);
		return num;
	}
	/**
	 * ��ҳ��ѯ���ݣ����
	 * @return
	 */
	public List<Dog> dogspage(int pagesize,int pageindex){
		return dd.dogspage(pagesize, pageindex);
	}
	/**
	 * ����������������
	 * 
	 */
	public int findTotalCount(){
		return dd.findTotalCount();
	}
	/**
	 * ����ID�����û������
	 * @return
	 */
	public Dog findById(Integer id){
		return dd.findById(id);
	}
	
	/**
	 * �޸ĳ�����
	 */
	public int updateDog(Dog dog){
		int num=dd.updateDog(dog);
		return num;
	}
	
	/**
	 * ����IDɾ��������
	 */
	public void delete(Integer id){
		dd.delete(id);
	}
	/**
	 * ��ѯ������Ʒ(��ӭ)
	 */
	public List<Dog> hotThreeDog() {
		List<Dog> dog = dd.hotThreeDog();
		return dog;
	}
	/**
     * ���ݹ�������ID������Ʒ(����)
     */
	public List<Dog> fingByTypeId(Integer typeid){
		Dogtype dogtype=dtd.findTypeById(typeid);
		List<Dog> dog=dd.findByTypeId(dogtype);
		return dog;
	}
}
