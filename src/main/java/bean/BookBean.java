package bean;

import java.io.Serializable;

public class BookBean implements Serializable {
	 int book_id;
	 long isbn;
	 String title;
	 int code;
	 String author;
	 String publisher;
	 String publishDate;
	 String arrivalDate;
	 String discardDate;
	 String remarks;
	
	//資料ID
	public long getbook_id() {
		return book_id;
	}
	public void setbook_id(int book_id) {
		this.book_id = book_id;
	}
	
	
	//ISBN
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	
	
	//資料名
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	//分類コード
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	//著者
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	//出版社
	public String getPublisher() {
		return publisher;
	}	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	//出版日
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	
	
	//入荷年月日
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivaldate) {
		this.arrivalDate = arrivaldate;
	}
	
	
	//削除年月日
	public String getDiscardDate() {
		return discardDate;
	}
	public void setDiscardDate(String discardDate) {
		this.discardDate = discardDate;
	}
	
	
	//備考
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
