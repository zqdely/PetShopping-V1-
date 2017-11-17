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
	 * 添加商品（王博）
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
	 * 查找所有商品（王博）
	 * @return
	 */
	public List<Products> fingAll(){
		Session session = super.getSession();
		Query query = session.createQuery("from Products");
		List<Products> products = query.list();
		return products;
	}
	/**
     * 根据商品ID查找商品
     */
	public Products fingById(Integer productid) {
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Products.class)
				.add(Restrictions.eq("productid", productid));
		Products products = (Products) cri.uniqueResult();
		return products;
	}
	/**
     * 根据商品类型查找商品
     */
	public List<Products> fingByType(Protype protype){
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Products.class)
				.add(Restrictions.eq("protype", protype));
		List<Products> products = (List<Products>) cri.list();
		return products;
	}
	/**
	 * 根据商品ID删除商品
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
	 *修改商品信息
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
	 * 分页显示数据
	 * 获取当前页要显示的数据（王博）
	 * pagesize 一页显示几条
	 * pageindex  第几页
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
	 * 商品的总数量（王博）
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
