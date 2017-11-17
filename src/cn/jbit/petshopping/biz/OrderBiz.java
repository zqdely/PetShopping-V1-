package cn.jbit.petshopping.biz;

import java.util.List;

import cn.jbit.petshopping.entity.Orders;
import cn.jbit.petshopping.entity.Userinfo;

public interface OrderBiz {
	/**
	 * ͳ��������(����int����)
	 * @return
	 */
	@Deprecated
	public int[] SellCount();
	/**
	 * ��Ӷ���(��ӭ)
	 * @return
	 */
	public int saveorder(Orders order);

	
	/**
	 * ��ѯ���������
	 * @return
	 */
	public List<Orders> selectorder();
	
	/**
	 * ɾ�����������
	 * @return
	 */
	public void deleteorder(Integer id);
	
	/**
	 * ��ҳ��ѯ�û����������
	 * @return
	 */
	public List<Orders> orderspage(int pagesize,int pageindex,Userinfo user);
	
	/**
	 * �û������������������
	 * 
	 */
	public int findTotalCount(Userinfo user);

	/**
	 * ɾ����������ӭ��
	 * @return
	 */
	public int deleteorder(Orders order);
	/**
	 * ��ѯ��������ӭ��
	 * @return
	 */
	public List<Orders> selectorder(Userinfo users);
	/**
	 * �޸Ķ�������ӭ��
	 * @return
	 */
	public int updateorder(Orders order);
	/**
	 * ͳ�ƹ��ﳵ��Ʒ����(��ӭ)
	 * @return
	 */
	public int proCount(Userinfo userinfo);
	/**
	 * ͳ�ƹ��ﳵ�ܽ��(��ӭ)
	 * @return
	 */
	public Double cartMoneyAll(Userinfo userinfo);
	/**
	 * ����id��ѯ����
	 * @return
	 */
	public Orders findGoodById(Integer id);
	/**
	 * �ύ�������޸Ķ��������״̬(��ӭ)
	 * @return
	 */
	public int submitOrdersUpdateId(int id);
}
