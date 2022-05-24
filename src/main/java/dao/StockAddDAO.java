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

	public int AddBooks(int bookid, long isbn, String title, String arrivalDate, String remarks)

			throws DAOException {

		// SQL文の作成
		String sql = "INSERT INTO stock(book_id, isbn, title, arrival_date, remarks) VALUES(?, ?, ?, ?, ?)";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);)

		// 表に入れる項目
		{
			st.setInt(1, bookid);
			st.setLong(2, isbn);
			st.setString(3, title);
			st.setString(4, arrivalDate);
			st.setString(5, remarks);

			// SQLの実行
			int rows = st.executeUpdate();
			return rows;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");

		}
	}

}