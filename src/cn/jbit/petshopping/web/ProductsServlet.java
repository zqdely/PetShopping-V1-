package cn.jbit.petshopping.web;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.jbit.petshopping.biz.ProductsBiz;
import cn.jbit.petshopping.biz.ProtypeBiz;
import cn.jbit.petshopping.biz.impl.ProductsBizImpl;
import cn.jbit.petshopping.biz.impl.ProtypeBizImpl;
import cn.jbit.petshopping.entity.Products;
import cn.jbit.petshopping.entity.Protype;

import com.opensymphony.xwork2.ActionSupport;

public class ProductsServlet extends ActionSupport{
	private Integer pdid; //接收JSP页面传来的ID值
	private String picture; //接收JSP页面传来的图图片地址值
	private Integer typeid;
	private	Products products;
	private	Integer protypeid;
	private	File	uploadFile;
	private	String	uploadFileContentType;
	private	String	uploadFileFileName;
	private	String	savePath;
	private ProductsBiz pb=new ProductsBizImpl();
	private ProtypeBiz ptb=new ProtypeBizImpl();
	
	
    
	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getPdid() {
		return pdid;
	}

	public void setPdid(Integer pdid) {
		this.pdid = pdid;
	}

	public Integer getProtypeid() {
		return protypeid;
	}

	public void setProtypeid(Integer protypeid) {
		this.protypeid = protypeid;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}


	public String getUploadFileFileName() {
		return uploadFileFileName;
	}


	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}


	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		savePath = ServletActionContext.getServletContext().getRealPath(savePath);
		this.savePath = savePath;
	}
	
	public	String	upload(){
		FileInputStream	fi = null;
		FileOutputStream fo = null;
		try {
			byte[] buf = new byte[1024];
			fi = new FileInputStream(uploadFile);
			fo = new FileOutputStream(savePath + "\\" + uploadFileFileName);
			int len = 0;
			while((len = fi.read(buf)) != -1){
				fo.write(buf, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(fi != null){
					fi.close();
				}
				if(fo != null){
					fo.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return SUCCESS;
	}
	/**
	 * 添加商品
	 * @return
	 */
	public String save(){
		if(products==null){
			return INPUT;
		}else if(protypeid==null || protypeid==0){
			return INPUT;
		}else{			
			products.setPicture(uploadFileFileName);
			Protype protype=ptb.fingById(protypeid);
			products.setProtype(protype);
			products.setProsellcount(0);
			int num=pb.save(products);
			if(num!=0){
				return SUCCESS;
			}else{
				return ERROR;
			}
		}	
	}
	
	/**
	 * 根据id查询商品信息显示在输入框（王博）
	 * @return
	 */
	public String fingById(){
		products=pb.fingById(pdid);
		if(products!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	/**
	 * 修改商品信息
	 * @return
	 */
	public String updateProducts(){
		if(products==null || pdid==null){
			return INPUT;
		}else{
			String str=null;
			if(uploadFileFileName==null ||uploadFileFileName.equals(picture)){
				str=null;
			}else{
				str=this.upload();
			}
			if(str==null){
				products.setPicture(picture);
			}else{
				products.setPicture(uploadFileFileName);
			}
			Protype protype=null;
			if(protypeid==0 || protypeid==null){
				protype=ptb.fingById(typeid);
			}else{
				protype=ptb.fingById(protypeid);
			}
			products.setProductid(pdid);
			products.setProtype(protype);
			int num=pb.update(products);
			if(num!=0){
				return SUCCESS;
			}else{
				return INPUT;
			}
			
		}
	}
	/**
	 * 删除商品
	 * @return
	 */
	public String delete(){
		int num=pb.delete(pdid);
		if(num!=0){
			return SUCCESS;
		}else{
			return INPUT;
		}		
	}
	/**
	 * 根据商品类型id查询商品信息显示在输入框（王博）
	 * @return
	 */
	public String fingByTpe(){
		List<Products> products=pb.fingByTypeId(protypeid);
		if(products!=null){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}

