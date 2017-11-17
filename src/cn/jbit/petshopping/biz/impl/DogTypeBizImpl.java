package cn.jbit.petshopping.biz.impl;

import java.util.List;

import cn.jbit.petshopping.biz.DogTypeBiz;
import cn.jbit.petshopping.dao.DogTypeDao;
import cn.jbit.petshopping.dao.impl.DogTypeDaoImpl;
import cn.jbit.petshopping.entity.Dogtype;

public class DogTypeBizImpl implements DogTypeBiz {
	private DogTypeDao dd=new DogTypeDaoImpl();
	/**
	 * 查找所有宠物种类（李凯）
	 */
	public List<Dogtype> findAllType(){
		return dd.findAllType();
	}
	/**
	 * 根据ID查找宠物种类(李凯)
	 */
	public Dogtype findTypeById(Integer typeid){
		return dd.findTypeById(typeid);
	}
	
	/**
	 * 添加宠物种类（李凯）
	 */
	public void addDogType(Dogtype type){
		dd.addDogType(type);
	}
	
	/**
	 * 根据宠物种类名字查找宠物（李凯）
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
