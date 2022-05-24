package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockAddDAO {
	private String url = "jdbc:postgresql:sample";
	private String user = "student";
	private String pass = "himitu";

	public StockAddDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}

	}

	public int AddBooks(int bookid, long isbn, String title,  int code, String author,
			            String publisher, String publish_date, String arrivalDate, String remarks) 
					
			     throws DAOException {
		
		String sql = "###########";
		
		try (//データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);)
		     
		    //表に入れる項目
				 {
			st.setInt(1, bookid);
            st.setLong(2, isbn);
            st.setString(3, title);
            st.setInt(4, code);
            st.setString(5, author);
            st.setString(6, publisher);
            st.setString(7, publish_date);
            st.setString(8, arrivalDate);
            st.setString(9, remarks);
			
           //SQLの実行
            
            int rows = st.executeUpdate();
            return rows;
		    
		    }catch(SQLException e) {
		    	e.printStackTrace();
		    	throw new DAOException("レコードの操作に失敗しました。");
		    	
		    }
	}
}