package bean;

import java.io.Serializable;

public class StockAddBean2 implements Serializable {
	
	 long isbn;
	 String title;
	 int code;
	 String author;
	 String publisher;
	 String publishDate;
	 
	
	
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
}
