package cn.jbit.petshopping.dao;

import java.util.List;

import cn.jbit.petshopping.entity.Protype;

public interface ProtypeDao {
	/**
	 * ���ڲ�ѯ������Ʒ���ࣨ������
	 * @return
	 */
	public List<Protype> fingAll(); 
	/**
	 * ����ͨ����Ʒ����ID��ѯ��������
	 * @return
	 */
	public Protype fingById(Integer protypeid);
	/**
	 * �����Ʒ���ࣨ������
	 * @return
	 */
	public int save(Protype protype);
	/**
	 * ����ͨ����Ʒ�������ֲ�ѯ��������
	 * @return
	 */
	public Protype fingByName(String name);
	/**
	 * ɾ����Ʒ���ࣨ������
	 * @return
	 */
	//public int delete(Protype protype);
	/**
	 * �޸���Ʒ���ࣨ������
	 * @return
	 */
	//public int update(Protype protype);
}
