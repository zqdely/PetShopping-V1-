package cn.jbit.petshopping.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.sun.security.auth.UserPrincipal;

import cn.jbit.petshopping.dao.BaseHibernateDao;
import cn.jbit.petshopping.dao.UserinfoDao;
import cn.jbit.petshopping.entity.Userinfo;
import cn.jbit.petshopping.util.SendEmail;

public class UserinfoDaoImpl extends BaseHibernateDao implements UserinfoDao {

	public Userinfo userLoging(Userinfo user) {
		Session session = super.getSession();
		//采用动态数据查询实现用户登录
		Criteria criteria = session.createCriteria(Userinfo.class);
		if(user.getName()!=(null)){
			criteria.add(Restrictions.eq("name", user.getName()));
		}
		if(user.getEmail()!=(null)){
			criteria.add(Restrictions.eq("email", user.getEmail()));
		}
		criteria.add(Restrictions.eq("password", user.getPassword()));
		Userinfo users=null;
		try {
			users = (Userinfo) criteria.uniqueResult();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public int userRegister(Userinfo user) {
		Session session = super.getSession();
		Transaction tx = null;
		int num = 0;
		try {
			try {
				tx = session.beginTransaction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			num = (Integer) session.save(user);
			//邮件验证
			SendEmail.send(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		super.closeSession();
		return num;
	}
	
	public int activation(int num,String actionName){
		Session session = super.getSession();
		Transaction tx = null;
		int numback = 0;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("update Userinfo set activation=:activation where name=:name");
			query.setInteger("activation", num);
			query.setString("name", actionName);
			//返回表的主键
			numback = query.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return numback;
	}
	
	public int ResetPassword(String password,String email){
		Session session = super.getSession();
		Transaction tx = null;
		int numback = 0;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("update Userinfo set password=:password where email=:email");
			query.setString("password", password);
			query.setString("email", email);
			try {
				numback = query.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return numback;
	}

	public Userinfo EmailRestePwd(String email) {
		Session session = super.getSession();
		Query query = session.createQuery("from Userinfo where email=:email");
		query.setString("email", email);
		Userinfo userinf = (Userinfo) query.uniqueResult();
		return userinf;
	}

	public Userinfo nameFind(String name) {
		Session session = super.getSession();
		Query query = session.createQuery("from Userinfo where name=:name");
		query.setString("name", name);
		Userinfo userinf = (Userinfo) query.uniqueResult();
		return userinf;
	}

	public List<Userinfo> adminindexpage(int pagesize,int pageindex) {
		Session session = super.getSession();
		Query query = session.createQuery("from Userinfo");
		query.setMaxResults(pagesize);
		query.setFirstResult((pageindex-1)*pagesize);
		List<Userinfo> users = query.list();
		return users;
	}
	
	/**
	 * 用户的总数量（李凯）
	 * 
	 */
	public int findTotalCount(){
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Userinfo.class);
		cri.setProjection(Projections.count("id"));
		return (Integer)cri.uniqueResult();
	}
	/**
	 * 查询前六条数据（李迎）
	 */
	public List<Userinfo> sixperson() {
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Userinfo.class);
		cri.addOrder(Order.desc("id"));
		cri.setFirstResult(0);
		cri.setMaxResults(6);
		List<Userinfo> users = cri.list();
		return users;
	}
	/**
	 * 根据ID查找用户（李凯）
	 * @return
	 */
	public Userinfo findById(Integer id){
		Session session = super.getSession();
		Criteria cri=session.createCriteria(Userinfo.class);
		cri.add(Restrictions.eq("id", id));
		return (Userinfo) cri.uniqueResult();
	}
	
	/**
	 * 修改用户（李凯）
	 */
	public void updateUser(Userinfo user){
		Session session = super.getSession();
		Transaction tc=null;
		try {
			
			tc=session.beginTransaction();
			session.merge(user);
			tc.commit();
		} catch (HibernateException e) {
			tc.rollback();
			e.printStackTrace();
		}
	}
	/**
	 * 根据ID删除用户（李凯）
	 */
	public void delete(Integer id){
		Session session = super.getSession();
		Transaction tc=null;
		try {
			Userinfo user=(Userinfo) session.createCriteria(Userinfo.class).add(Restrictions.eq("id", id)).uniqueResult();
			tc=session.beginTransaction();
			session.delete(user);
			tc.commit();
		} catch (HibernateException e) {
			tc.rollback();
			e.printStackTrace();
		}
	}
}
