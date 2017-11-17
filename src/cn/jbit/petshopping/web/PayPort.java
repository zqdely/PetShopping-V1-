package cn.jbit.petshopping.web;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 预留的支付端口
 * @author lenovo
 *
 */
public class PayPort extends ActionSupport {
	//接收前台发送的订单id
	private List<String> checkedName;
	//流类型显示提示信息
	private InputStream inputStream;
	
	public List<String> getCheckedName() {
		return checkedName;
	}

	public void setCheckedName(List<String> checkedName) {
		this.checkedName = checkedName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String execute(){
		if(checkedName!=null){
			/*String pageInfo = "<script type='text/javascript'>alert('支付成功！');</script>";
			try {
				inputStream = new ByteArrayInputStream(pageInfo.getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			return SUCCESS;
		}else{
			/*String pageInfo = "<script type='text/javascript'>if(confirm('您没有选择商品！返回购物车？')){location.href='cartlist.action';}else{location.href='cartlist.action';}</script>";
			try {
				inputStream = new ByteArrayInputStream(pageInfo.getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			return INPUT;
		}
	}
}
