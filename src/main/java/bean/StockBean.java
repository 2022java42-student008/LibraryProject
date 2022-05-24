package bean;

import java.io.Serializable;

public class StockBean implements Serializable {
	int book_id;
	long isbn;
	String title;
	String arrival_date;
	String discar_date;
	String remarks;
	
	
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArrival_date() {
		return arrival_date;
	}
	public void setArrival_date(String arrival_date) {
		this.arrival_date = arrival_date;
	}
	public String getDiscar_date() {
		return discar_date;
	}
	public void setDiscar_date(String discar_date) {
		this.discar_date = discar_date;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
