package bean;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class RentalBean implements Serializable{
	private int iRentalID;
	private int iUserID;
	private int iBookID;
	private long isbn;
	private String title;
	private String dRentalDate;
	private String dFixedDate;
	private String dReturnDate;
	private String strRemarks;
	private SimpleDateFormat fm;
	
	public RentalBean(){}
	public RentalBean(int _iRenatalID,int _iUserID, int _iBookID,Date _dRentalDate,Date _dFixedDate, String _strRemarks)
	{
		fm = new SimpleDateFormat("yyyy/MM/dd");
		iRentalID = _iRenatalID;
		iUserID = _iUserID;
		iBookID = _iBookID;
		
		dRentalDate = fm.format(_dRentalDate);
		dFixedDate = fm.format(_dFixedDate);
		strRemarks = _strRemarks;
	}
	public RentalBean(int _iRenatalID,int _iUserID, int _iBookID,Date _dRentalDate,Date _dFixedDate)
	{
		fm = new SimpleDateFormat("yyyy/MM/dd");
		iRentalID = _iRenatalID;
		iUserID = _iUserID;
		iBookID = _iBookID;
		dRentalDate = fm.format(_dRentalDate);
		dFixedDate = fm.format(_dFixedDate);
	}
	public RentalBean(int _iRenatalID,int _iUserID, int _iBookID,Date _dRentalDate,Date _dFixedDate, Date _dReturnDate,String _strRemarks)
	{
		fm = new SimpleDateFormat("yyyy/MM/dd");
		iRentalID = _iRenatalID;
		iUserID = _iUserID;
		iBookID = _iBookID;
		dRentalDate = fm.format(_dRentalDate);
		dFixedDate = fm.format(_dFixedDate);
		dReturnDate = fm.format(_dReturnDate);
		strRemarks = _strRemarks;
	}
	
	public RentalBean(int _iBookID, long _isbn, String _title,Date _dRentalDate,Date _dFixedDate)
	{
		fm = new SimpleDateFormat("yyyy/MM/dd");
		iBookID = _iBookID;
		isbn = _isbn;
		title = _title;
		dRentalDate = fm.format(_dRentalDate);
		dFixedDate = fm.format(_dFixedDate);
	}
	
	
	public int getiRentalID() {return iRentalID;}
	public void setiRentalID(int iRentalID) {this.iRentalID = iRentalID;}
	
	public int getiUserID() {return iUserID;}
	public void setiUserID(int iUserID) { this.iUserID = iUserID;}
	
	public int getiBookID() {return iBookID;}
	public void setiBookID(int iBookID) {this.iBookID = iBookID;}
	
	public long getIsbn() {return isbn;}
	public void setIsbn(int isbn) {this.isbn = isbn;}
	
//	public String getTitle() {return title;}
//	public void setTitle(Date title) {this.title = fm.format(title);}
	
	public String getdRentalDate() {return dRentalDate;}
	public void setdRentalDate(Date dRentalDate) {this.dRentalDate = fm.format(dRentalDate);}
	
	public String getdFixedDate() {return dFixedDate;}
	public void setdFixedDate(Date dFixedDate) {this.dFixedDate = fm.format(dFixedDate);}
	
	public String getdReturnDate() {return dReturnDate;}
	public void setdReturnDate(Date dReturnDate) {this.dReturnDate = fm.format(dReturnDate);}
	
	public String getStrRemarks() {return strRemarks;}
	public void setStrRemarks(String strRemarks) {this.strRemarks = strRemarks;}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
