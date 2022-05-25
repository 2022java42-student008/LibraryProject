package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.RentalBean;

public class RentalDAO {
	// URL、ユーザ名、パスワード準備
	private String url = "jdbc:postgresql:sample";
	private String user = "student";
	private String pass = "himitu";

	public RentalDAO() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}
	}

	// 貸出情報を取得
	public List<RentalBean> ListUserRentalInfo(int _userID) throws DAOException {
		List<RentalBean> listRental = new ArrayList<RentalBean>();
		// listRental.add(new RentalBean())
		String sql = "SELECT * FROM rental INNER JOIN stock ON rental.book_id = stock.book_id WHERE rental.user_id = ? AND return_date IS NULL";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, _userID);

			try {
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					listRental.add(new RentalBean(rs.getInt("book_id"), rs.getLong("isbn"), rs.getString("title"),
							rs.getDate("rental_date"), rs.getDate("fixed_date")));
					listRental.get(listRental.size() - 1).setiRentalID(rs.getInt("rental_id"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("エラー");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("エラー");
		}

		return listRental;
	}

	public void ReturnCompletedInfo(int _iRenatalID) throws DAOException {

		// listRental.add(new RentalBean())
		String sql = "UPDATE rental SET return_date=current_date WHERE rental_id=?";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, _iRenatalID);

<<<<<<< Updated upstream
			ps.executeUpdate();
			
=======
			while (rs.next()) {
				int user_id = rs.getInt("user_id");
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				Date rental_date = rs.getDate("rental_date");
				Date fixed_date = rs.getDate("fixed_date");
				Date return_date = rs.getDate("return_date");
				String remarks = rs.getString("remarks");
//				System.out.println(user_id+book_id+title+rental_date+fixed_date+return_date+remarks);
				RentalBean bean = new RentalBean();
				bean.setiUserID(user_id);
				bean.setiBookID(book_id);
				bean.setTitle(title);
				bean.setdRentalDate(rental_date);
				bean.setdFixedDate(fixed_date);
				bean.setdReturnDate(return_date);
				bean.setStrRemarks(remarks);
				listRental.add(bean);
			}
			return listRental;
>>>>>>> Stashed changes
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("エラー");
		}

	}
}
