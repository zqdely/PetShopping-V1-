package cn.jbit.petshopping.web;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.struts2.ServletActionContext;

import cn.jbit.petshopping.biz.DogBiz;
import cn.jbit.petshopping.biz.DogTypeBiz;
import cn.jbit.petshopping.biz.impl.DogBizImpl;
import cn.jbit.petshopping.biz.impl.DogTypeBizImpl;
import cn.jbit.petshopping.entity.Dog;
import cn.jbit.petshopping.entity.Dogtype;

import com.opensymphony.xwork2.ActionSupport;

public class DogAction extends ActionSupport{

	private Dogtype type;
	private Integer dogid;
	private Integer did;
	private String picture; //接收JSP页面传来的图图片地址值
	private Integer dogtypeid;
	private	Dog	dog;
	private String brithday;
	private Integer typeid;
	private	File	myFile;
	private	String	myFileContentType;
	private	String	myFileFileName;
	private	String	savePath;
	private DogBiz db=new DogBizImpl();
	private DogTypeBiz dtb=new DogTypeBizImpl();
	private String message;
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public	String	upload(){
		FileInputStream	fi = null;
		FileOutputStream fo = null;
		try {
			byte[] buf = new byte[1024];
			fi = new FileInputStream(myFile);
			fo = new FileOutputStream(savePath + "\\" + myFileFileName);
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
	
    
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public Integer getDogtypeid() {
		return dogtypeid;
	}


	public Dogtype getType() {
		return type;
	}


	public void setType(Dogtype type) {
		this.type = type;
	}



	public void setDogtypeid(Integer dogtypeid) {
		this.dogtypeid = dogtypeid;
	}



	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public DogBiz getDb() {
		return db;
	}


	public void setDb(DogBiz db) {
		this.db = db;
	}


	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		savePath = ServletActionContext.getServletContext().getRealPath(savePath);
		this.savePath = savePath;
	}
		
	public String getBrithday() {
		return brithday;
	}

	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}

	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	
	public String saveDog(){
		if(dog==null){
			return INPUT;
		}else if(typeid==null||typeid==0){
			return INPUT;
		}else{
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			Date da=null;
			try {
				da =date.parse(brithday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Dogtype type=dtb.findTypeById(typeid);
			dog.setPicture(myFileFileName);
			dog.setDogtype(type);
			dog.setBrithday(da);
			int num=db.saveDog(dog);
			if(num!=0){
				return SUCCESS;
			}else{
				return ERROR;
			}
		}
			
		
	}
	
	public String updateDog(){
		if(dog==null || did==null){
			return INPUT;
		}else{
			String str=null;
			if(myFileFileName==null ||myFileFileName.equals(picture)){
				str=null;
			}else{
				str=this.upload();
			}
			if(str==null){
				dog.setPicture(picture);
			}else{
				dog.setPicture(myFileFileName);
			}
			Dogtype dogtype=null;
			if(typeid==0 || typeid==null){
				dogtype=dtb.findTypeById(dogtypeid);
			}else{
				dogtype=dtb.findTypeById(typeid);
			}
			SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd");
			Date da=null;
			try {
				da =date.parse(brithday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			dog.setBrithday(da);
			dog.setDogid(did);
			dog.setDogtype(dogtype);
			int num=db.updateDog(dog);
			if(num!=0){
				return SUCCESS;
			}else{
				return INPUT;
			}
			
		}
	}

	public String addDogType(){
		if(type==null ||type.getTypename().equals("")){
			message="内容不能为空";
			return INPUT;
		}else if(dtb.findDogType(type.getTypename())!=null){
			message="该种类已有，请添加其它种类！";
			return INPUT;
		}else{
			type.setHotsell(0);
			dtb.addDogType(type);
			message="添加成功，可以继续添加！";
			return SUCCESS;
		}
	}

}

