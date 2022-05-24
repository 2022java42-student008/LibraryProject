package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RentalBookDAO {

	private String url = "jdbc:postgresql:sample";
	private String user = "student";
	private String pass = "himitu";

	public RentalBookDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}

	}

	public int addrentalBook(int user_id, int book_id, String rental_date, String fixed_date, String return_date,
			String remarks) throws DAOException {
		String sql = "INSERT INTO reltal(user_id, book_id, rental_date, fixed_date, return_date,remarks) VALUES (?,?,?,?,?,?)";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, user_id);
			st.setLong(2, book_id);
			st.setString(3, rental_date);
			st.setString(4, fixed_date);
			st.setString(5, return_date);
			st.setString(6, remarks);
			int rows = st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
}
