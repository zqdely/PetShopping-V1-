package cn.jbit.petshopping.web;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import cn.jbit.petshopping.biz.DogBiz;
import cn.jbit.petshopping.biz.DogTypeBiz;
import cn.jbit.petshopping.biz.OrderBiz;
import cn.jbit.petshopping.biz.ProductsBiz;
import cn.jbit.petshopping.biz.impl.DogBizImpl;
import cn.jbit.petshopping.biz.impl.DogTypeBizImpl;
import cn.jbit.petshopping.biz.impl.OrderBizImpl;
import cn.jbit.petshopping.biz.impl.ProductsBizImpl;
import cn.jbit.petshopping.entity.Dog;
import cn.jbit.petshopping.entity.Dogtype;
import cn.jbit.petshopping.entity.Orders;
import cn.jbit.petshopping.entity.Products;
import cn.jbit.petshopping.entity.Protype;
import cn.jbit.petshopping.entity.Userinfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Cart extends ActionSupport {
	//��ʽ�����ݣ����10,000.00
	DecimalFormat a = new DecimalFormat("#,##0.00");
	
	private Dog dog = new Dog();
	private Products products = new Products();
	private Userinfo users = new Userinfo();
	private Orders orders = new Orders();
	private int id;
	private String type;
	//���������
	private int quantitynum;
	private List<Orders> orderList;
	private String info;
	//��������
	private Integer ordersNum;
	private Double ordersMoney;
	//����json���ݵ�ҳ�׵Ĺ��ﳵ
	private Map<String, String> result = new HashMap<String, String>();
	//��������ʾ��ʾ��Ϣ
	private InputStream inputStream;
	//���¶�������ʱ��ʹ�õ�
	private String allnum;
	//��������ʱ��check
	private List<String> checkedName;
	
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public Userinfo getUsers() {
		return users;
	}
	public void setUsers(Userinfo users) {
		this.users = users;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantitynum() {
		return quantitynum;
	}
	public void setQuantitynum(int quantitynum) {
		this.quantitynum = quantitynum;
	}
	public List<Orders> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getOrdersNum() {
		return ordersNum;
	}
	public void setOrdersNum(Integer ordersNum) {
		this.ordersNum = ordersNum;
	}
	public Double getOrdersMoney() {
		return ordersMoney;
	}
	public void setOrdersMoney(Double ordersMoney) {
		this.ordersMoney = ordersMoney;
	}
	public Map<String, String> getResult() {
		return result;
	}
	public void setResult(Map<String, String> result) {
		this.result = result;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getAllnum() {
		return allnum;
	}
	public void setAllnum(String allnum) {
		this.allnum = allnum;
	}
	public List<String> getCheckedName() {
		return checkedName;
	}
	public void setCheckedName(List<String> checkedName) {
		this.checkedName = checkedName;
	}
	/**
	 * ��ӵ����ﳵ����ӭ��
	 * @return
	 */
	public String addOrders(){
		
		//����session����ȡ�û��Ƿ��¼
		Map<String, Object> session = ActionContext.getContext().getSession();
		Userinfo users = (Userinfo) session.get("userinfo");
		if(users==null){
			return LOGIN;
		}else{
			if(type.equals("dog")){
				DogBiz db = new DogBizImpl();
				dog = db.findById(id);
				orders.setDog(dog);
				orders.setTotalprice(quantitynum*(dog.getPrice()));
			}else if(type.equals("product")){
				ProductsBiz pb = new ProductsBizImpl();
				products = pb.fingById(id);
				orders.setProducts(products);
				orders.setTotalprice(quantitynum*(products.getPrice()));
			}else{
				orders.setTotalprice(0D);
			}
			Date now = new Date();
			orders.setCreatime(now);
			orders.setSellcount(quantitynum);
			orders.setUserinfo(users);
			OrderBiz db = new OrderBizImpl();
			int num = db.saveorder(orders);
			if(num>0){
				return SUCCESS;
			}else{
				return ERROR;
			}
			
		}
		
	}
	/**
	 * ��ѯ��Ʒ�����б���ӭ��
	 * @return
	 */
	public String cartList(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		Userinfo users = (Userinfo) session.get("userinfo");
		OrderBiz ob = new OrderBizImpl();
		orderList = ob.selectorder(users);
		if(orders!=null){
			return SUCCESS;
		}else if(orders==null&&users!=null){
			info="���ﳵ�տյģ��Ͻ�ȥ�����";
			return SUCCESS;
		}else{
			return LOGIN;
		}
		
	}
	/**
	 * ���ﳵͼ����Ϣ����ӭ��
	 * @return
	 */
	public String cartinfo(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		Userinfo users = (Userinfo) session.get("userinfo");
		if(users==null){
			return LOGIN;
		}else{
			OrderBiz ob = new OrderBizImpl();
			orderList = ob.selectorder(users);
			ordersMoney = ob.cartMoneyAll(users);
			ordersNum = ob.proCount(users);
			if(ordersMoney==null&&ordersNum==0){
				result.put("money", "");
				result.put("goodNum", "����û�й�����Ʒ");
			}else{
				result.put("money", a.format(ordersMoney));
				result.put("goodNum", String.valueOf(ordersNum));
			}
			return SUCCESS;
		}
	}
	/**
	 * ɾ����Ʒ��������ӭ��
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String deleteGood() throws UnsupportedEncodingException{
		OrderBiz ob = new OrderBizImpl();
		orders = ob.findGoodById(id);
		int jud = ob.deleteorder(orders);
		String pageInfo = null;
		if(jud==0){
			pageInfo = "<script type='text/javascript'>if(confirm('����ɾ��ʧ�ܣ����ع��ﳵ��')){location.href='cartlist.action';}else{location.href='userPage/index.jsp';}</script>";
		}else{
			pageInfo = "<script type='text/javascript'>if(confirm('�ɹ�ɾ�����������ع��ﳵ��')){location.href='cartlist.action';}else{location.href='userPage/index.jsp';}</script>";
		}
		inputStream = new ByteArrayInputStream(pageInfo.getBytes("utf-8"));
		return SUCCESS;
	}
	/**
	 * ������Ʒ�۸���ӭ��
	 * @return
	 */
	public String updateGoodInfo(){
		OrderBiz ob = new OrderBizImpl();
		orders = ob.findGoodById(id);
		orders.setTotalprice(Double.valueOf(allnum));
		orders.setSellcount(quantitynum);
		int num = ob.updateorder(orders);
		if(num!=0){
			String n = a.format(Double.valueOf(allnum));
			result.put("info", n);
			return SUCCESS;
		}else{
			result.put("info", "0");
			return INPUT;
		}
	}
	/**
	 * ѡ�񶩵���Ϣ��ʾ����ӭ��
	 * @return
	 */
	public String submitOrders(){
		if(checkedName!=null){
			String[] check = checkedName.get(0).split(",");
			Double allTotl = 0.0;
			Integer numOrders = 0;
			for(int i=0;i<check.length;i++){
				OrderBiz ob = new OrderBizImpl();
				int ido = Integer.valueOf(check[i]);
				orders = ob.findGoodById(ido);
				allTotl = allTotl + orders.getTotalprice();
				numOrders=numOrders+orders.getSellcount();
			}
			result.put("allTotl", a.format(allTotl).toString());
			result.put("numOrders", numOrders.toString());
			return SUCCESS;
		}else {
			return INPUT;
		}
		
	}
	/**
	 * ���ɶ���
	 * @return
	 */
	public String submitGoods(){
		if(checkedName!=null){
			orderList = new ArrayList<Orders>();
			ordersMoney = 0.0;
			for(int i=0;i<checkedName.size();i++){
				OrderBiz ob = new OrderBizImpl();
				orders = ob.findGoodById(Integer.valueOf(checkedName.get(i)));
				orderList.add(orders);
				quantitynum = quantitynum+orders.getSellcount();
				ordersMoney = ordersMoney+orders.getTotalprice();
			}
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	/**
	 * �ύ�������޸Ķ��������״̬
	 * @return
	 */
	public String submitOrdersUpdateid(){
		OrderBiz ob = new OrderBizImpl();
		DogTypeBiz dtb = new DogTypeBizImpl();
		ProductsBiz pb = new ProductsBizImpl();
		if(checkedName!=null){
			int jud = 0;
			for(int i=0;i<checkedName.size();i++){
				jud = jud+ob.submitOrdersUpdateId(Integer.valueOf(checkedName.get(i)));
				orders = ob.findGoodById(Integer.valueOf(checkedName.get(i)));
				if(orders.getDog()!=null){
					//���¹�����������+1
					Dogtype dt = orders.getDog().getDogtype();
					dt.setHotsell(dt.getHotsell()+1);
					dtb.updateId(dt);
				}else{
					//������Ʒ��������+1&�������-1
					Products pt = orders.getProducts();
					pt.setProsellcount(pt.getProsellcount()+1);
					pt.setProcount(pt.getProcount()-1);
					pb.updatehotsell(pt);
				}
				
			}
			if(jud==checkedName.size()){
				String pageInfo = "<script type='text/javascript'>if(confirm('����ȷ�ϳɹ������ع��ﳵ��')){location.href='cartlist.action';}else{location.href='userPage/index.jsp';}</script>";
				try {
					inputStream = new ByteArrayInputStream(pageInfo.getBytes("utf-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			return SUCCESS;
		}
	}
}
