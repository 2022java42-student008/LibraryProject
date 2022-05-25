package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import bean.StockBean;

public class StockDAO {
	private String url = "jdbc:postgresql:sample";
	private String user = "student";
	private String pass = "himitu";

	public StockDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}

	}

	public List<StockBean> findBooks(ArrayList<String> condition) throws DAOException {
		String sql = "SELECT book_id, isbn, title, TO_CHAR(arrival_date, 'YYYY/MM/DD') AS arrival_date, TO_CHAR(discard_date, 'YYYY/MM/DD') AS discard_date, remarks FROM stock WHERE book_id IN ("
				+ String.join(",", condition) + ")";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<StockBean> list = new ArrayList<StockBean>();
			while (rs.next()) {
				// データベースから取得
				int book_id = rs.getInt("book_id");
				long ibsn = rs.getLong("isbn");
				String title = rs.getString("title");
				String arrival_date = rs.getString("arrival_date");
				String remarks = rs.getString("remarks");

				// 情報を入れる
				StockBean bean = new StockBean();
				bean.setBook_id(book_id);
				bean.setIsbn(ibsn);
				bean.setTitle(title);
				bean.setArrival_date(arrival_date);

				// 予定日を挿入
				if (fixedDate(book_id)) {
					LocalDate date = LocalDate.now();
					// 新作なので本日から10日後
<<<<<<< Updated upstream
					String returnDate =  date.plusDays(10).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));;
					bean.setDiscar_date(returnDate);
				}
				else
				{
					// 新作ではないので、本日から10日後
					LocalDate date = LocalDate.now();
					// 新作ではないので本日から10日後
					String returnDate =  date.plusDays(15).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));;
=======
					String returnDate = date.plusDays(10).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
					;
					bean.setDiscar_date(returnDate);
				} else {
					// 新作ではないので、本日から15日後
					LocalDate date = LocalDate.now();
					// 新作なので本日から10日後
					String returnDate = date.plusDays(15).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
					;
>>>>>>> Stashed changes
					bean.setDiscar_date(returnDate);
				}

				bean.setRemarks(remarks);
				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}

	public boolean fixedDate(int book_id) throws DAOException {
		String sql = "SELECT " + "  CASE " + "      WHEN arrival_date + interval '30 day' >= CURRENT_DATE THEN 1 "
				+ "      ELSE 2 " + "    END AS type,"
				+ "    TO_CHAR(arrival_date + interval '10 day', 'YYYY-MM-DD') AS  new_lend_date, "
				+ "    TO_CHAR(arrival_date + interval '15 day', 'YYYY-MM-DD') AS old_lend_date " + "FROM stock "
				+ "WHERE book_id = ? ";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, book_id);
			try (ResultSet rs = st.executeQuery();) {
				int type = 0;
				String new_lend_date = "";
				String old_lend_date = "";
				boolean fixedDate;
				while (rs.next()) {
					type = rs.getInt("type");
					old_lend_date = rs.getString("old_lend_date");
					new_lend_date = rs.getString("new_lend_date");
				}
				if (type == 1) {
					fixedDate = true;
				} else {
					fixedDate = false;
				}
				return fixedDate;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
}
