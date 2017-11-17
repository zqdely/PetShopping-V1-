package cn.jbit.petshopping.dao;

import java.util.List;

import cn.jbit.petshopping.entity.Orders;
import cn.jbit.petshopping.entity.Userinfo;
public interface OrderDao {
	/**
	 * 统计销售量（需要手动输入季度时间范围）
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	@Deprecated
	public int SellCount(String starttime,String endtime);
	/**
	 * 添加订单(李迎)
	 * @return
	 */
	public int saveorder(Orders order);
	/**
	 * 删除订单（李迎）
	 * @return
	 */
	public int deleteorder(Orders order);
	/**
	 * 根据id删除订单
	 * @param id
	 */
	public void deleteorder(Integer id);
	/**
	 * 查询订单（李迎）
	 * @return
	 */
	public List<Orders> selectorder(Userinfo users);
	/**
	 * 修改订单（李迎）
	 * @return
	 */
	public int updateorder(Orders order);

	
	/**
	 * 分页查询数据（李凯）
	 * @return
	 */
	public List<Orders> orderspage(int pagesize,int pageindex,Userinfo user);

	/**
	 * 统计购物车商品数量(李迎)
	 * @return
	 */
	public int proCount(Userinfo userinfo);
	/**
	 * 统计购物车总金额(李迎)
	 * @return
	 */
	public Double cartMoneyAll(Userinfo userinfo);
	/**
	 * 根据id查询订单
	 * @return
	 */
	public Orders findGoodById(Integer id);
	
	/**
	 * 用户订单的总数量（李凯）
	 * 
	 */
	public int findTotalCount(Userinfo user);
	/**
	 * 提交订单，修改订单的买家状态(李迎)
	 * @return
	 */
	public int submitOrdersUpdateId(int id);
}
