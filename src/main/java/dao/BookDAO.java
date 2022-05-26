package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.BookBean;
import bean.StockBean;

public class BookDAO {
	private String url = "jdbc:postgresql:sample";
	private String user = "student";
	private String pass = "himitu";

	public BookDAO() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
		}

	}

	public List<BookBean> findBooks(int bookid) throws DAOException {
		String sql = "SELECT * FROM stock LEFT OUTER JOIN inventory ON stock.isbn = inventory.isbn WHERE book_id =?";
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, bookid);
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			ResultSet rs = st.executeQuery();
			List<BookBean> list = new ArrayList<BookBean>();
			while (rs.next()) {

				int book_id = rs.getInt("book_id");
				long isbn = rs.getLong("isbn");
				String title = rs.getString("title");
				int code = rs.getInt("code");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String publish_date = rs.getString("publish_date");
				String arrivalDate = rs.getString("arrival_date");
				Date discardDate = rs.getDate("discard_date");
				String remarks = rs.getString("remarks");
				BookBean bean = new BookBean();
				bean.setbook_id(book_id);
				bean.setIsbn(isbn);
				bean.setTitle(title);
				bean.setCode(code);
				bean.setAuthor(author);
				bean.setPublisher(publisher);
				bean.setPublishDate(publish_date);
				bean.setArrivalDate(arrivalDate);
				if(discardDate != null)
				{
					bean.setDiscardDate(fmt.format(discardDate));
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

	public void addrental(List<StockBean> list, int user_id) throws DAOException {
		String sql = "INSERT INTO rental(user_id, book_id, rental_date, fixed_date) VALUES (?,?,CURRENT_DATE,?)";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			for (StockBean stock : list) {
				String returnDate = null;
				if (fixedDate(stock.getBook_id())) {
					LocalDate date = LocalDate.now();
					// 新作なので本日から10日後
					returnDate = date.plusDays(10).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					;
				} else {
					// 新作ではないので、本日から15日後
					LocalDate date = LocalDate.now();
					// 新作なので本日から10日後
					returnDate = date.plusDays(15).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

				}

				st.setInt(1, user_id);
				st.setLong(2, stock.getBook_id());
				st.setDate(3, java.sql.Date.valueOf(returnDate));
				st.executeUpdate();
			}
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
	
	public void BookDelete(String DeleteReason) throws DAOException {
		String sql = "UPDATE stock SET remarks = ?";
	
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, DeleteReason);
			st.executeUpdate();
			
			 
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
	}
		
	}

