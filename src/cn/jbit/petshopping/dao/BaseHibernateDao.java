package cn.jbit.petshopping.dao;

import org.hibernate.Session;

import cn.jbit.petshopping.util.HibernateSessionFactory;

public class BaseHibernateDao {
	/**
	 * 
	 * @return
	 */
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
	/**
	 * ¹Ø±Õsession
	 */
	public void closeSession(){
		HibernateSessionFactory.closeSession();
	}
}
