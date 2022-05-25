package bean;

import java.io.Serializable;

public class StockAddBean implements Serializable {
	long isbn;
	String title;
	String arrivalDate;
	String remarks;
	
	

	//ISBN
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	
	//title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	//arrival_date
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrival_date) {
		this.arrivalDate = arrival_date;
	}
	
	//remarks
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
