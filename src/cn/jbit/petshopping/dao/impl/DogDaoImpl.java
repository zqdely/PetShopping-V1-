package cn.jbit.petshopping.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import cn.jbit.petshopping.dao.BaseHibernateDao;
import cn.jbit.petshopping.dao.DogDao;
import cn.jbit.petshopping.entity.Dog;
import cn.jbit.petshopping.entity.Dogtype;
import cn.jbit.petshopping.entity.Products;
import cn.jbit.petshopping.entity.Userinfo;

public class DogDaoImpl extends BaseHibernateDao implements DogDao {

	/**
	 * ���������
	 */
	public int saveDog(Dog dog){
		Session session=super.getSession();
		Transaction tc=null;
		int num=0;
		try {
			tc=session.beginTransaction();
			session.save(dog);
			tc.commit();
			num=1;
		} catch (HibernateException e) {
			tc.rollback();
			e.printStackTrace();
		}
		return num;
	}
	/**
	 * ��ҳ��ѯ���ݣ����
	 * @return
	 */
	public List<Dog> dogspage(int pagesize,int pageindex){
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Dog.class);
		cri.setFirstResult((pageindex-1)*pagesize);
		cri.setMaxResults(pagesize);
		return cri.list();
	}
	/**
	 * ����������������
	 * 
	 */
	public int findTotalCount(){
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Dog.class);
		cri.setProjection(Projections.count("id"));
		return (Integer)cri.uniqueResult();
	}
	/**
	 * ����ID�����û������
	 * @return
	 */
	public Dog findById(Integer id){
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Dog.class);
		cri.add(Restrictions.eq("id", id));
		return (Dog) cri.uniqueResult();
	}
	/**
	 * ���ݹ������Ͳ����û���������
	 * @return
	 */
	public List<Dog> findByTypeId(Dogtype dogtype){
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Dog.class);
		cri.add(Restrictions.eq("dogtype", dogtype));
		return (List<Dog>) cri.list();
	}
	/**
	 * �޸ĳ�����
	 */
	public int updateDog(Dog dog){
		Session session = super.getSession();
		Transaction tx = null;
		int num = 0;
		try {
			tx = session.beginTransaction();
			session.merge(dog);
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
	 * ����IDɾ��������
	 */
	public void delete(Integer id){
		Session session = super.getSession();
		Transaction tc=null;
		try {
			Dog dog=(Dog) session.createCriteria(Dog.class).add(Restrictions.eq("id", id)).uniqueResult();
			tc=session.beginTransaction();
			session.delete(dog);
			tc.commit();
		} catch (HibernateException e) {
			tc.rollback();
			e.printStackTrace();
		}
	}
	public List<Dog> hotThreeDog() {
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Dog.class);
		cri.addOrder(Order.desc("dogid"));
		cri.setFirstResult(0);
		cri.setMaxResults(3);
		List<Dog> dog = cri.list();
		return dog;
	}
}
