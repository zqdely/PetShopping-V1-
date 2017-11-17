package cn.jbit.petshopping.dao.impl;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import cn.jbit.petshopping.dao.BaseHibernateDao;
import cn.jbit.petshopping.dao.OrderDao;
import cn.jbit.petshopping.entity.Dog;
import cn.jbit.petshopping.entity.Orders;
import cn.jbit.petshopping.entity.Userinfo;
import cn.jbit.petshopping.util.DateFormat;

public class OrderDaoImpl extends BaseHibernateDao implements OrderDao {
	@Deprecated
	public int SellCount(String starttime,String endtime) {
		Session session = super.getSession();
		Criteria criteria = session.createCriteria("select count(creatime) from Orders");
			criteria.add(Restrictions.between("creatime", starttime, endtime));
		int num = (Integer) criteria.uniqueResult();
		return num;
	}

	public int saveorder(Orders order) {
		Session session = super.getSession();
		Transaction tx = null;
		int num = 0;
		try {
			tx = session.beginTransaction();
			num = (Integer) session.save(order);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
		}
		return num;
	}

	public int deleteorder(Orders order) {
		Session session = super.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(order);
			tx.commit();
			return 1;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			return 0;
		}
	}
	public void deleteorder(Integer id) {
		Session session = super.getSession();
		Transaction tx = null;
		int num = 0;
		try {
			tx = session.beginTransaction();
			Criteria cri=session.createCriteria(Orders.class);
			cri.add(Restrictions.eq("id", id));
			Orders order=(Orders) cri.uniqueResult();
			session.delete(order);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
		}
	}


	public List<Orders> selectorder() {
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Orders.class);
		return cri.list();
	}

	public List<Orders> selectorder(Userinfo users) {
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Orders.class);
		cri.add(Restrictions.eq("userinfo", users));
		cri.add(Restrictions.eq("buyerconfirm", 0));
		List<Orders> orders = cri.list();
		return orders;
	}

	public int updateorder(Orders order) {
		Session session = super.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.merge(order);
			tx.commit();
			return 1;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 分页查询数据（李凯）
	 * @return
	 */
	public List<Orders> orderspage(int pagesize,int pageindex,Userinfo user){
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Orders.class);
		cri.add(Restrictions.eq("userinfo", user));
		cri.setMaxResults(pagesize);
		cri.setFirstResult((pageindex-1)*pagesize);
		return cri.list();
	}
	public int proCount(Userinfo userinfo) {
		Session session = super.getSession();
		Criteria ciri = session.createCriteria(Orders.class);
		ciri.setProjection(Projections.count("sellcount"));
		ciri.add(Restrictions.eq("userinfo", userinfo));
		ciri.add(Restrictions.eq("buyerconfirm", 0));
		int count = (Integer) ciri.uniqueResult();
		return count;
	}

	public Double cartMoneyAll(Userinfo userinfo) {
		Session session = super.getSession();
		Criteria ciri = session.createCriteria(Orders.class);
		ciri.setProjection(Projections.sum("totalprice"));
		ciri.add(Restrictions.eq("userinfo", userinfo));
		ciri.add(Restrictions.eq("buyerconfirm", 0));
		Double money = (Double) ciri.uniqueResult();
		return money;
	}
	/**
	 * 用户订单的总数量（李凯）
	 * 
	 */
	public int findTotalCount(Userinfo user){
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Orders.class);
		cri.add(Restrictions.eq("userinfo", user));
		cri.setProjection(Projections.count("id"));
		return (Integer) cri.uniqueResult();
	}
	public Orders findGoodById(Integer id) {
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Orders.class);
		cri.add(Restrictions.eq("id", id));
		return (Orders) cri.uniqueResult();
	}

	public int submitOrdersUpdateId(int id) {
		Session session = super.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Orders order = (Orders) session.get(Orders.class, id);
			order.setBuyerconfirm(1);
			session.merge(order);
			tx.commit();
			return 1;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			return 0;
		}
	}

}
