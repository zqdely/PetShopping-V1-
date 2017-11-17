package cn.jbit.petshopping.dao;

import java.util.List;

import cn.jbit.petshopping.entity.Dogtype;

public interface DogTypeDao {
	/**
	 * �������г������ࣨ���
	 */
	public List<Dogtype> findAllType();
	
	/**
	 * ����ID���ҳ�������(�)
	 */
	public Dogtype findTypeById(Integer typeid);
	
	/**
	 * ��ӳ������ࣨ���
	 */
	public void addDogType(Dogtype type);
	
	/**
	 * ���ݳ����������ֲ��ҳ�����
	 * 
	 */
	public Dogtype findDogType(String typeName);
	/**
	 * ����dogtype��hotsell��������������ӭ��
	 * @param dt
	 * @return
	 */
	public int updateId(Dogtype dt);
}
