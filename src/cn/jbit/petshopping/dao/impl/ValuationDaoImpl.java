package cn.jbit.petshopping.dao.impl;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import cn.jbit.petshopping.dao.BaseHibernateDao;
import cn.jbit.petshopping.dao.ValuationDao;
import cn.jbit.petshopping.entity.Dog;
import cn.jbit.petshopping.entity.Valuation;

public class ValuationDaoImpl extends BaseHibernateDao implements ValuationDao {

	/**
	 * 添加评论（李凯）
	 */
	public void addValuation(Valuation valuation){
		Session session=super.getSession();
		Transaction tc=null;
		try {
			tc=session.beginTransaction();
			session.save(valuation);
			tc.commit();
		} catch (HibernateException e) {
			tc.rollback();
			e.printStackTrace();
		}
	}
	/**
	 * 根据ID查找评论(李凯)
	 */
	public Valuation findValuation(Integer id){
		Session session=super.getSession();
		Criteria cri=session.createCriteria(Valuation.class);
		cri.add(Restrictions.eq("id", id));
		return (Valuation) cri.uniqueResult();
	}
	
	/**
	 * 删除评论（李凯）
	 */
	public void deleteValuation(Valuation valuation){
		Session session=super.getSession();
		Transaction tc=null;
		try {
			tc=session.beginTransaction();
			session.delete(valuation);
			tc.commit();
		} catch (HibernateException e) {
			tc.rollback();
			e.printStackTrace();
		}
	}
	/**
	 * 分页查询数据（李凯）
	 * @return
	 */
	public List<Valuation> valuationspage(int pagesize,int pageindex){
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Valuation.class);
		cri.setFirstResult((pageindex-1)*pagesize);
		cri.setMaxResults(pagesize);
		return cri.list();
	}
	/**
	 * 宠物的总数量（李凯）
	 * 
	 */
	public int findTotalCount(){
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Valuation.class);
		cri.setProjection(Projections.count("id"));
		return (Integer)cri.uniqueResult();
	}
}
