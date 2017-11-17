package cn.jbit.petshopping.biz;

import java.util.List;

import cn.jbit.petshopping.entity.Dog;

public interface DogBiz {
	/**
	 * ���������
	 */
	public int saveDog(Dog dog);
	
	/**
	 * ��ҳ��ѯ���ݣ����
	 * @return
	 */
	public List<Dog> dogspage(int pagesize,int pageindex);
	/**
	 * ����������������
	 * 
	 */
	public int findTotalCount();
	/**
	 * ����ID�����û������
	 * @return
	 */
	public Dog findById(Integer id);
	
	/**
	 * �޸ĳ�����
	 */
	public int updateDog(Dog dog);
	
	/**
	 * ����IDɾ��������
	 */
	public void delete(Integer id);
	/**
	 * ��ѯ������Ʒ(��ӭ)
	 * @return
	 */
	public List<Dog> hotThreeDog();
	/**
     * ���ݹ�������ID������Ʒ(����)
     */
	public List<Dog> fingByTypeId(Integer typeid);
}
