package cn.jbit.petshopping.biz;

import java.util.List;

import cn.jbit.petshopping.entity.Valuation;

public interface ValuationBiz {
	/**
	 * ������ۣ����
	 */
	public void addValuation(Valuation valuation);
	
	/**
	 * ����IDɾ�����ۣ����
	 */
	public void deleteValuation(Integer id);
	
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
