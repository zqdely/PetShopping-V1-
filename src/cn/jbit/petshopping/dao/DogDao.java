package cn.jbit.petshopping.dao;

import java.util.List;

import cn.jbit.petshopping.entity.Dog;
import cn.jbit.petshopping.entity.Dogtype;
import cn.jbit.petshopping.entity.Userinfo;

public interface DogDao {
	/**
	 * ���������
	 */
	public int saveDog(Dog dog);
	
	/**
	 * ��ҳ��ѯ���ݣ����
	 * @return
	 */
	public List<Dog> dogspage(int pagesize,int pageindex);
	/**
	 * ����������������
	 * 
	 */
	public int findTotalCount();
	/**
	 * ����ID���ҹ��������
	 * @return
	 */
	public Dog findById(Integer id);
	/**
	 * ���ݹ������Ͳ����û���������
	 * @return
	 */
	public List<Dog> findByTypeId(Dogtype dogtype);
	
	/**
	 * �޸ĳ�����
	 */
	public int updateDog(Dog dog);
	
	/**
	 * ����IDɾ��������
	 */
	public void delete(Integer id);
	/**
	 * ��ѯ������Ʒ(��ӭ)
	 * @return
	 */
	public List<Dog> hotThreeDog();
}

