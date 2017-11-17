package cn.jbit.petshopping.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import cn.jbit.petshopping.dao.BaseHibernateDao;
import cn.jbit.petshopping.dao.ProductsDao;
import cn.jbit.petshopping.entity.Products;
import cn.jbit.petshopping.entity.Protype;
import cn.jbit.petshopping.entity.Userinfo;

public class ProductsDaoImpl extends BaseHibernateDao implements ProductsDao{
	/**
	 * �����Ʒ��������
	 * @return
	 */
	public int save(Products products) {
		Session session = super.getSession();
		Transaction tx = null;
		int num = 0;
		try {
			tx = session.beginTransaction();
			session.save(products);
			tx.commit();
			num=1;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		super.closeSession();
		return num;
	}
	/**
	 * ����������Ʒ��������
	 * @return
	 */
	public List<Products> fingAll(){
		Session session = super.getSession();
		Query query = session.createQuery("from Products");
		List<Products> products = query.list();
		return products;
	}
	/**
     * ������ƷID������Ʒ
     */
	public Products fingById(Integer productid) {
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Products.class)
				.add(Restrictions.eq("productid", productid));
		Products products = (Products) cri.uniqueResult();
		return products;
	}
	/**
     * ������Ʒ���Ͳ�����Ʒ
     */
	public List<Products> fingByType(Protype protype){
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Products.class)
				.add(Restrictions.eq("protype", protype));
		List<Products> products = (List<Products>) cri.list();
		return products;
	}
	/**
	 * ������ƷIDɾ����Ʒ
	 */
	public int delete(Integer productid){
		Session session = super.getSession();
		Transaction tx = null;
		int num = 0;
		try {
			tx = session.beginTransaction();
			Products products=this.fingById(productid);
			session.delete(products);
			tx.commit();
			num=1;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		super.closeSession();
		return num;
	}
	/**
	 *�޸���Ʒ��Ϣ
	 */
	public int update(Products products){
		Session session = super.getSession();
		Transaction tx = null;
		int num = 0;
		try {
			tx = session.beginTransaction();
			session.merge(products);
			tx.commit();
			num=1;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		super.closeSession();
		return num;
	}
	/**
	 * ��ҳ��ʾ����
	 * ��ȡ��ǰҳҪ��ʾ�����ݣ�������
	 * pagesize һҳ��ʾ����
	 * pageindex  �ڼ�ҳ
	 * @return
	 */
	public List<Products> adminindexpage(int pagesize, int pageindex) {
		Session session = super.getSession();
		Query query = session.createQuery("from Products");
		query.setMaxResults(pagesize);
		query.setFirstResult((pageindex-1)*pagesize);
		List<Products> products = query.list();
		return products;
	}
	/**
	 * ��Ʒ����������������
	 * 
	 */
	public int findTotalCount(){
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Products.class);
		cri.setProjection(Projections.count("productid"));
		return (Integer)cri.uniqueResult();
	}
	public List<Products> HotProduct() {
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Products.class);
		cri.addOrder(Order.desc("procount"));
		cri.setFirstResult(0);
		cri.setMaxResults(6);
		List<Products> pro = cri.list();
		return pro;
	}
	public int updatehotsell(Products pro) {
		Session session = super.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(pro);
			tx.commit();
			return 1;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			return 0;
		}
	}
	
}
