package cn.jbit.petshopping.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.jbit.petshopping.dao.BaseHibernateDao;
import cn.jbit.petshopping.dao.DogTypeDao;
import cn.jbit.petshopping.entity.Dogtype;

public class DogTypeDaoImpl extends BaseHibernateDao implements DogTypeDao {
	/**
	 * �������г������ࣨ���
	 */
	public List<Dogtype> findAllType() {
		Session session=super.getSession();
		Criteria cri=session.createCriteria(Dogtype.class);
		return cri.list();
	}
	/**
	 * ����ID���ҳ�������
	 */
	public Dogtype findTypeById(Integer typeid){
		Session session=super.getSession();
		Criteria cri=session.createCriteria(Dogtype.class);
		return (Dogtype) cri.add(Restrictions.eq("typeid", typeid)).uniqueResult();
	}
	
	/**
	 * ��ӳ������ࣨ���
	 */
	public void addDogType(Dogtype type){
		Session session=super.getSession();
		Transaction tc=null;
		try {
			tc=session.beginTransaction();
			session.save(type);
			tc.commit();
		} catch (HibernateException e) {
			tc.rollback();
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ݳ����������ֲ��ҳ�����
	 * 
	 */
	public Dogtype findDogType(String typeName){
		Session session=super.getSession();
		Criteria cri=session.createCriteria(Dogtype.class);
		return (Dogtype) cri.add(Restrictions.eq("typename", typeName)).uniqueResult();
	}
	public int updateId(Dogtype dt) {
		Session session=super.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(dt);
			tx.commit();
			return 1;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			return 0;
		}

	}
}
