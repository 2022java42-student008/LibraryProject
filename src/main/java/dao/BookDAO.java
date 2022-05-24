package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.BookBean;

public class BookDAO {
	private String url = "jdbc:postgresql:sample";
	private String user = "student";
	private String pass = "himitu";

	public BookDAO () throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}
		
	}
	public List<BookBean> findBooks(String[] condition) throws DAOException {
		String sql = "SELECT * FROM inventory WHERE isbn IN (" + String.join(",",condition) + ")";
		try (
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
				List<BookBean> list = new ArrayList<BookBean>();
				while (rs.next()) {
					long isbn = rs.getLong("isbn");
					String title = rs.getString("title");
					int code = rs.getInt("code");
					String author = rs.getNString("author");
					String publisher = rs.getString("publisher");
					String publish_date = rs.getString("publish_date");
					BookBean bean = new BookBean();
					bean.setIsbn(isbn);
					bean.setTitle(title);
					bean.setCode(code);
					bean.setAuthor(author);
					bean.setPublisher(publisher);
					bean.setPublishDate(publish_date);
					list.add(bean);
				} 
				return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
	
}
