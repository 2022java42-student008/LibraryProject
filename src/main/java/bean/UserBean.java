package bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserBean implements Serializable{
	private int iID;
	private String strName;
	private String post_no;
	private String address;
	private String tel;
	private String mail;
	private String birthday;
	private String join_date;
	private String secede_date;
	private String update_date;
	private SimpleDateFormat nomalFM;
	private SimpleDateFormat timeFM;
	
	public UserBean() {};
	public UserBean(int _iID, String _strName,long _post_no,String _address, String _tel, String _mail,Date _birthday , Date _join_date) 
	{
		nomalFM = new SimpleDateFormat("yyyy/MM/dd");
		timeFM = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.iID = _iID;
		this.strName = _strName;
		
		String strPost = String.valueOf(_post_no);
		
		for(int i = 0;i < 7 - strPost.length();i++)
		{
			strPost = "0" + strPost;
		}
		
		this.post_no = strPost;
		this.address = _address;
		this.tel = _tel;
		this.mail = _mail;
		this.birthday = nomalFM.format(_birthday);
		this.join_date = nomalFM.format(_join_date);
	};
	
	public UserBean(int _iID, String _strName,String _post_no,String _address, String _tel, String _mail,Date _birthday , Date _join_date) 
	{
		nomalFM = new SimpleDateFormat("yyyy/MM/dd");
		timeFM = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.iID = _iID;
		this.strName = _strName;
		this.post_no = _post_no;
		this.address = _address;
		this.tel = _tel;
		this.mail = _mail;
		this.birthday = nomalFM.format(_birthday);
		this.join_date = nomalFM.format(_join_date);
	};
	
	
	public int getiID() {return iID;}
	public void setiID(int iID) {this.iID = iID;}
	
	public String getStrName() {return strName;}
	public void setStrName(String strName) {this.strName = strName;}
	
	public String getPost_no() {return post_no;}
	public void setPost_no(String post_no) {this.post_no = post_no;}
	public void setPost_no(long post_no) {this.post_no = formatPostNO(post_no);}
	
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	
	public String getTel() {return tel;}
	public void setTel(String tel) {this.tel = tel;}
	
	public String getMail() {return mail;}
	public void setMail(String mail) {this.mail = mail;}
	
	public String getBirthday() {return birthday;}
	public void setBirthday(Date birthday) {this.birthday = nomalFM.format(birthday);}
	public void setBirthday(String birthday) {this.birthday = birthday;}
	
	public String getJoin_date() {return join_date;}
	public void setJoin_date(Date join_date) {this.join_date = nomalFM.format(join_date);}
	public void setJoin_date(String join_date) {this.join_date = join_date;}
	
	public String getSecede_date() {return secede_date;}
	public void setSecede_date(Date secede_date) {this.secede_date = nomalFM.format(secede_date);}
	public void setSecede_date(String secede_date) {this.secede_date = secede_date;}
	
	public String getUpdate_date() {return update_date;}
	public void setUpdate_date(Date update_date) {this.update_date = timeFM.format(update_date);}
	public void setUpdate_date(String update_date) {this.update_date = update_date;}
	
	
	String formatPostNO(long _postno)
	{
		String strPost = String.valueOf(_postno);
		for(int i = 0;i < 7 - strPost.length();i++)
		{
			strPost = "0" + strPost;
		}
		
		return strPost; 
	}
}
