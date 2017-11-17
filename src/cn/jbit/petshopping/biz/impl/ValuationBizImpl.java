package cn.jbit.petshopping.biz.impl;

import java.util.List;

import cn.jbit.petshopping.biz.ValuationBiz;
import cn.jbit.petshopping.dao.ValuationDao;
import cn.jbit.petshopping.dao.impl.ValuationDaoImpl;
import cn.jbit.petshopping.entity.Valuation;

public class ValuationBizImpl implements ValuationBiz {
	private ValuationDao vd=new ValuationDaoImpl();
	/**
	 * ������ۣ����
	 */
	public void addValuation(Valuation valuation){
		vd.addValuation(valuation);
	}
	/**
	 * ����IDɾ�����ۣ����
	 */
	public void deleteValuation(Integer id){
		vd.deleteValuation(vd.findValuation(id));
	}
	
	/**
	 * ��ҳ��ѯ���ݣ����
	 * @return
	 */
	public List<Valuation> valuationspage(int pagesize,int pageindex){
		return vd.valuationspage(pagesize, pageindex);
	}
	/**
	 * ����������������
	 * 
	 */
	public int findTotalCount(){
		return vd.findTotalCount();
	}
}
