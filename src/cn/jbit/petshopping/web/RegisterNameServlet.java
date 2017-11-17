package cn.jbit.petshopping.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Response;

import net.sf.json.JSONObject;
import cn.jbit.petshopping.biz.UserinfoBiz;
import cn.jbit.petshopping.biz.impl.UserinfoBizImpl;
import cn.jbit.petshopping.entity.Userinfo;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterNameServlet extends ActionSupport {
	private String name;
	private String email;
	//json���ؽ����Ϣ
	private Map<String, String> result = new HashMap<String, String>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Map<String, String> getResult() {
		return result;
	}
	public void setResult(Map<String, String> result) {
		this.result = result;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * �û������&&������֤
	 * @return
	 */
	public String registerNameJud(){
		UserinfoBiz uib = new UserinfoBizImpl();
		if(name!=null){
			Userinfo users = uib.nameFind(name);
			if(users!=null){
				result.put("info", "�û���������");
			}else{
				result.put("info", "�û�������");
			}
		}else{
			Userinfo users = uib.EmailRestePwd(email);
			if(users!=null){
				result.put("emailinfo", "�����Ѿ�ע�ᣡ");
			}else{
				result.put("emailinfo", "�������");
			}
		}
		return SUCCESS;
	}
}

