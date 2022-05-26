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

	public int AddBooks(long isbn, String title, String arrivalDate, String remarks)

			throws DAOException {

		// SQL文の作成
		String sql = "INSERT INTO stock(isbn, title, arrival_date, remarks) VALUES(?, ?, ?, ?)";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);)

		// 表に入れる項目
		{
			
			st.setLong(1, isbn);
			st.setString(2, title);
			st.setDate(3, java.sql.Date.valueOf(arrivalDate));
			st.setString(4, remarks);

			// SQLの実行
			int rows = st.executeUpdate();
			return rows;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");

		}
	}

	public int AddDiscardDate(String discardDate)

			throws DAOException {

		// SQL文の作成
		String sql = "UPDATE stock SET remarks = ?";

		try (// データベースへの接続
				Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);)

		// 表に入れる項目
		{
			st.setDate(1, java.sql.Date.valueOf(discardDate));


			// SQLの実行
			int rows = st.executeUpdate();
			return rows;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");

		}
	}	
}