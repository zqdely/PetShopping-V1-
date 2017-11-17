package cn.jbit.petshopping.dao;

import java.util.List;

import cn.jbit.petshopping.entity.Products;
import cn.jbit.petshopping.entity.Protype;

public interface ProductsDao {
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
     * ������Ʒ���Ͳ�����Ʒ
     */
	public List<Products> fingByType(Protype protype);
	/**
	 *������ƷIDɾ����Ʒ
	 */
	public int delete(Integer productid);
	/**
	 *�޸���Ʒ��Ϣ
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
	 * ��ѯ���������ǰ������Ʒ����ӭ��
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
