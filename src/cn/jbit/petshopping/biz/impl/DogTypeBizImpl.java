package cn.jbit.petshopping.biz.impl;

import java.util.List;

import cn.jbit.petshopping.biz.DogTypeBiz;
import cn.jbit.petshopping.dao.DogTypeDao;
import cn.jbit.petshopping.dao.impl.DogTypeDaoImpl;
import cn.jbit.petshopping.entity.Dogtype;

public class DogTypeBizImpl implements DogTypeBiz {
	private DogTypeDao dd=new DogTypeDaoImpl();
	/**
	 * �������г������ࣨ���
	 */
	public List<Dogtype> findAllType(){
		return dd.findAllType();
	}
	/**
	 * ����ID���ҳ�������(�)
	 */
	public Dogtype findTypeById(Integer typeid){
		return dd.findTypeById(typeid);
	}
	
	/**
	 * ��ӳ������ࣨ���
	 */
	public void addDogType(Dogtype type){
		dd.addDogType(type);
	}
	
	/**
	 * ���ݳ����������ֲ��ҳ�����
	 * 
	 */
	public Dogtype findDogType(String typeName){
		return dd.findDogType(typeName);
	}
	public int updateId(Dogtype dt) {
		// TODO Auto-generated method stub
		return dd.updateId(dt);
	}
}
