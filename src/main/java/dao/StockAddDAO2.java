package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockAddDAO2 {
	private String url = "jdbc:postgresql:sample";
	private String user = "student";
	private String pass = "himitu";

	public StockAddDAO2() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}

	}
	
	public int AddBooks(long isbn, String title, int code, String author, String publisher, String publish_date)

			throws DAOException {

		// SQL文の作成
		String sql = "INSERT INTO inventory(isbn, title, code, author, publisher, publish_date) VALUES(?, ?, ?, ?, ?, ?)";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);)

		// 表に入れる項目
		{
			st.setLong(1, isbn);
			st.setString(2, title);
			st.setInt(3, code);
			st.setString(4, author);
			st.setString(5, publisher);
			st.setDate(6, java.sql.Date.valueOf(publish_date));

			// SQLの実行
			int rows = st.executeUpdate();
			return rows;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");

		}
	}
}