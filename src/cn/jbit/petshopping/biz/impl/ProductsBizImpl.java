package cn.jbit.petshopping.biz.impl;

import java.util.List;

import cn.jbit.petshopping.biz.ProductsBiz;
import cn.jbit.petshopping.dao.ProductsDao;
import cn.jbit.petshopping.dao.ProtypeDao;
import cn.jbit.petshopping.dao.UserinfoDao;
import cn.jbit.petshopping.dao.impl.ProductsDaoImpl;
import cn.jbit.petshopping.dao.impl.ProtypeDaoImpl;
import cn.jbit.petshopping.dao.impl.UserinfoDaoImpl;
import cn.jbit.petshopping.entity.Products;
import cn.jbit.petshopping.entity.Protype;

public class ProductsBizImpl implements ProductsBiz{
	private ProductsDao pd=new ProductsDaoImpl();
	private ProtypeDao ptd=new ProtypeDaoImpl(); 
	/**
	 * 添加商品
	 */
	public int save(Products products) {
		int num=pd.save(products);
		return num;
	}
    /**
     * 查找所有商品
     */
	public List<Products> fingAll() {
		List<Products> products=pd.fingAll();
		return products;
	}
	/**
     * 根据商品ID查找商品
     */
	public Products fingById(Integer productid) {
		Products products=pd.fingById(productid);
		return products;
	}
	/**
     * 根据商品种类ID查找商品
     */
	public List<Products> fingByTypeId(Integer protypeid) {
		Protype protype=ptd.fingById(protypeid);
		List<Products> products=pd.fingByType(protype);
		return products;
	}
	/**
	 *根据商品ID删除商品
	 */
	public int delete(Integer productid){
		int num=pd.delete(productid);
		return num;
	}
	/**
	 *修改商品
	 */
	public int update(Products products){
		int num=pd.update(products);
		return num;
	}
	/**
	 * 获取当前页要显示的数据（王博）
	 * pagesize 一页显示几条
	 * pageindex  第几页
	 * @return
	 */
	public List<Products> adminindexpage(int pagesize, int pageindex) {
		ProductsDao pd= new ProductsDaoImpl();
		List<Products> products = pd.adminindexpage(pagesize, pageindex);
		return products;
	}
	/**
	 * 商品的总数量（王博）
	 * 
	 */
	public int findTotalCount() {
		ProductsDao pd= new ProductsDaoImpl();
		return pd.findTotalCount();
	}
	public List<Products> HotProduct() {
		ProductsDao pd = new ProductsDaoImpl();
		List<Products> pro = pd.HotProduct();
		return pro;
	}
	public int updatehotsell(Products pro) {
		ProductsDao pd = new ProductsDaoImpl();
		return pd.updatehotsell(pro);
	}
	

}
