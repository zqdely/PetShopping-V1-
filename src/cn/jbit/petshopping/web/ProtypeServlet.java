package cn.jbit.petshopping.web;

import cn.jbit.petshopping.biz.ProtypeBiz;
import cn.jbit.petshopping.biz.impl.ProtypeBizImpl;
import cn.jbit.petshopping.entity.Protype;

import com.opensymphony.xwork2.ActionSupport;

public class ProtypeServlet extends ActionSupport{
    private Protype protype;
    private String message;
    private ProtypeBiz ptb=new ProtypeBizImpl();
	public Protype getProtype() {
		return protype;
	}

	public void setProtype(Protype protype) {
		this.protype = protype;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 添加商品种类
	 * @return
	 */
    public String save(){
    	if(protype.getProtypename()==null || protype.getProtypename().equals("")){
    		message="内容不能为空！";
    		return INPUT;
    	}else{
    		int num=ptb.save(protype, protype.getProtypename());
    		if(num==-1){
    			message="给种类已有！";
				return INPUT;
			}else{
				message="添加成功！";
				return SUCCESS;
			}
    			
    	}
    }
}
