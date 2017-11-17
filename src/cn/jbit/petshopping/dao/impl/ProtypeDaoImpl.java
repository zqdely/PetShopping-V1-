package cn.jbit.petshopping.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.jbit.petshopping.dao.BaseHibernateDao;
import cn.jbit.petshopping.dao.ProtypeDao;
import cn.jbit.petshopping.entity.Protype;

public class ProtypeDaoImpl extends BaseHibernateDao  implements ProtypeDao {
	/**
	 * ���ڲ�ѯ������Ʒ���ࣨ������
	 * @return
	 */
	public List<Protype> fingAll() {
		Session session = super.getSession();
		Query query = session.createQuery("from Protype");
		List<Protype> protype = query.list();
		return protype;
	}
	/**
	 * ����ͨ����Ʒ����ID��ѯ��Ʒ���ࣨ������
	 * @return
	 */
	public Protype fingById(Integer protypeid) {
		Session session = super.getSession();
		Query query = session.createQuery("from Protype where protypeid=:protypeid");
		query.setInteger("protypeid", protypeid);
		Protype protype = (Protype) query.uniqueResult();
		return protype;
	}
	public int delete(Protype protype) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int update(Protype protype) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * �����Ʒ���ࣨ������
	 * @return
	 */
	public int save(Protype protype){
		Session session = super.getSession();
		Transaction tx = null;
		int num = 0;
		try {
			tx = session.beginTransaction();
			session.save(protype);
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
	 * ����ͨ����Ʒ�������ֲ�ѯ��������
	 * @return
	 */
	public Protype fingByName(String name){
		Session session = super.getSession();
		Query query = session.createQuery("from Protype where protypename=:protypename");
		query.setString("protypename", name);
		Protype protype = (Protype) query.uniqueResult();
		return protype;
	}

}
