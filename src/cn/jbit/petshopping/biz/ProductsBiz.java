package cn.jbit.petshopping.biz;

import java.util.List;

import cn.jbit.petshopping.entity.Products;

public interface ProductsBiz {
	/**
	 * ���������Ʒ��������
	 * @return
	 */
	public int save(Products products); 
	/**
	 * ����������Ʒ��������
	 * @return
	 */
	public List<Products> fingAll();
	/**
     * ������ƷID������Ʒ
     */
	public Products fingById(Integer productid);
	/**
     * ������Ʒ����ID������Ʒ
     */
	public List<Products> fingByTypeId(Integer protypeid);
	/**
	 *������ƷIDɾ����Ʒ
	 */
	public int delete(Integer productid);
	/**
	 *�޸���Ʒ
	 */
	public int update(Products products);
	/**
	 * ��ȡ��ǰҳҪ��ʾ�����ݣ�������
	 * pagesize һҳ��ʾ����
	 * pageindex  �ڼ�ҳ
	 * @return
	 */
	public List<Products> adminindexpage(int pagesize,int pageindex);
	/**
	 * ��Ʒ����������������
	 * 
	 */
	public int findTotalCount();
	/**
	 * ��ѯ���������ǰ������Ʒ(��ӭ)
	 * @return
	 */
	public List<Products> HotProduct();
	/**
	 * ������������+1&���-1
	 * @param pro
	 * @return
	 */
	public int updatehotsell(Products pro);
}
