package cn.jbit.petshopping.biz.impl;

import java.util.List;

import cn.jbit.petshopping.biz.OrderBiz;
import cn.jbit.petshopping.dao.OrderDao;
import cn.jbit.petshopping.dao.impl.OrderDaoImpl;
import cn.jbit.petshopping.entity.Orders;
import cn.jbit.petshopping.entity.Userinfo;

public class OrderBizImpl implements OrderBiz {

	private OrderDao od = new OrderDaoImpl();
	@Deprecated
	public int[] SellCount() {
		OrderDao od = new OrderDaoImpl();
		//����3��-5��
		int firstQuarter = od.SellCount("2015-03-1", "2015-05-31");
		//�ļ�6��-8��
		int secondQuarter = od.SellCount("2015-06-1", "2015-08-31");
		//�＾9��-11��
		int threeQuarter = od.SellCount("2015-09-1", "2015-11-30");
		//����12��-2��
		int fourQuarter = od.SellCount("2015-12-1", "2015-02-28");
		int[] quarterDate = {firstQuarter,secondQuarter,threeQuarter,fourQuarter};
		return quarterDate;
	}

	public int saveorder(Orders order) {

		int num = od.saveorder(order);
		return num;
	}
	/**
	 * ��ѯ���������
	 * @return
	 */
	public List<Orders> selectorder(Userinfo user){
		return od.selectorder(user);
	}
	
	/**
	 * ɾ�����������
	 * @return
	 */
	public void deleteorder(Integer id){
		od.deleteorder(id);
	}
	
	/**
	 * ��ҳ��ѯ���ݣ����
	 * @return
	 */
	public List<Orders> orderspage(int pagesize,int pageindex,Userinfo user){
		return od.orderspage(pagesize, pageindex,user);
	}
	public int deleteorder(Orders order) {
		// TODO Auto-generated method stub
		return od.deleteorder(order);
	}

	public int updateorder(Orders order) {
		// TODO Auto-generated method stub
		return od.updateorder(order);
	}

	public int proCount(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return od.proCount(userinfo);
	}

	public Double cartMoneyAll(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return od.cartMoneyAll(userinfo);
	}

	public Orders findGoodById(Integer id) {
		return od.findGoodById(id);
	}

	public List<Orders> selectorder() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * �û������������������
	 * 
	 */
	public int findTotalCount(Userinfo user){
		return od.findTotalCount(user);
	}

	public int submitOrdersUpdateId(int id) {
		// TODO Auto-generated method stub
		return od.submitOrdersUpdateId(id);
	}

}
