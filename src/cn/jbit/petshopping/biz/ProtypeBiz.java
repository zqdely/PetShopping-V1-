package cn.jbit.petshopping.biz;

import java.util.List;

import cn.jbit.petshopping.entity.Protype;

public interface ProtypeBiz {
	/**
	 * ���ڲ�ѯ������Ʒ���ࣨ������
	 * @return
	 */
	public List<Protype> fingAll(); 
	/**
	 * ����ͨ�����ֲ�ѯ��Ʒ���ࣨ������
	 * @return
	 */
	public Protype fingById(Integer protypeid);
	/**
	 * �����Ʒ���ࣨ������
	 * @return
	 */
	public int save(Protype protype,String name);
}
