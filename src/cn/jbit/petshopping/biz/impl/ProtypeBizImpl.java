package cn.jbit.petshopping.biz.impl;

import java.util.List;

import cn.jbit.petshopping.biz.ProtypeBiz;
import cn.jbit.petshopping.dao.ProtypeDao;
import cn.jbit.petshopping.dao.impl.ProtypeDaoImpl;
import cn.jbit.petshopping.entity.Protype;

public class ProtypeBizImpl implements ProtypeBiz{
	private ProtypeDao pd=new ProtypeDaoImpl();
	/**
	 * ���ڲ�ѯ������Ʒ���ࣨ������
	 * @return
	 */
	public List<Protype> fingAll() {
		List<Protype> protype = pd.fingAll();
		return protype;
	}
	/**
	 * ����ͨ�����ֲ�ѯ��Ʒ���ࣨ������
	 * @return
	 */
	public Protype fingById(Integer protypeid) {
		Protype protype=pd.fingById(protypeid);
		return protype;
	}/**
	 * �����Ʒ���ࣨ������
	 * @return
	 */
	public int save(Protype protype,String name){
		Protype ptype=pd.fingByName(name);
		int num;
		if(ptype==null){
			num=pd.save(protype);
		}else{
			num=-1;
		}
		return num;
	}

}
