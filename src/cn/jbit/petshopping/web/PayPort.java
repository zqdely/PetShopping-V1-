package cn.jbit.petshopping.web;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
/**
 * Ԥ����֧���˿�
 * @author lenovo
 *
 */
public class PayPort extends ActionSupport {
	//����ǰ̨���͵Ķ���id
	private List<String> checkedName;
	//��������ʾ��ʾ��Ϣ
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
			/*String pageInfo = "<script type='text/javascript'>alert('֧���ɹ���');</script>";
			try {
				inputStream = new ByteArrayInputStream(pageInfo.getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			return SUCCESS;
		}else{
			/*String pageInfo = "<script type='text/javascript'>if(confirm('��û��ѡ����Ʒ�����ع��ﳵ��')){location.href='cartlist.action';}else{location.href='cartlist.action';}</script>";
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
