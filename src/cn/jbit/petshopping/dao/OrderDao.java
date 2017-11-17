package cn.jbit.petshopping.dao;

import java.util.List;

import cn.jbit.petshopping.entity.Orders;
import cn.jbit.petshopping.entity.Userinfo;
public interface OrderDao {
	/**
	 * ͳ������������Ҫ�ֶ����뼾��ʱ�䷶Χ��
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	@Deprecated
	public int SellCount(String starttime,String endtime);
	/**
	 * ��Ӷ���(��ӭ)
	 * @return
	 */
	public int saveorder(Orders order);
	/**
	 * ɾ����������ӭ��
	 * @return
	 */
	public int deleteorder(Orders order);
	/**
	 * ����idɾ������
	 * @param id
	 */
	public void deleteorder(Integer id);
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
	 * ��ҳ��ѯ���ݣ����
	 * @return
	 */
	public List<Orders> orderspage(int pagesize,int pageindex,Userinfo user);

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
	 * �û������������������
	 * 
	 */
	public int findTotalCount(Userinfo user);
	/**
	 * �ύ�������޸Ķ��������״̬(��ӭ)
	 * @return
	 */
	public int submitOrdersUpdateId(int id);
}
