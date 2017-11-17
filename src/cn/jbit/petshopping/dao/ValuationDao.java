package cn.jbit.petshopping.dao;

import java.util.List;

import cn.jbit.petshopping.entity.Dog;
import cn.jbit.petshopping.entity.Userinfo;
import cn.jbit.petshopping.entity.Valuation;

public interface ValuationDao {
	/**
	 * ������ۣ����
	 */
	public void addValuation(Valuation valuation);
	
	/**
	 * ����ID��������(�)
	 */
	public Valuation findValuation(Integer id);
	
	/**
	 * ɾ�����ۣ����
	 */
	public void deleteValuation(Valuation valuation);
	
	/**
	 * ��ҳ��ѯ���ݣ����
	 * @return
	 */
	public List<Valuation> valuationspage(int pagesize,int pageindex);
	/**
	 * ����������������
	 * 
	 */
	public int findTotalCount();
}

