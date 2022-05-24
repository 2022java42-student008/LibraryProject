package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bean.UserBean;

public class UserDAO {
	//URL、ユーザ名、パスワード準備
	private String url = "jdbc:postgresql:sample";
	private String user ="student";
	private String pass ="himitu";
	
	public UserDAO() throws DAOException
	{
		try 
		{
			//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException("JDBCドライバの登録に失敗しました。");
			
		}
	}
	
	//会員を取得する
	public UserBean GetUser(String _strMail) throws DAOException
	{
		UserBean retBean = null;
		String sql = "SELECT * FROM user_table WHERE mail = ?";
		
		try (
				Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement ps = con.prepareStatement(sql);){
				ps.setString(1, _strMail);
				
				try {
					ResultSet rs = ps.executeQuery();
					
					if(rs.next())
					{
						retBean = new UserBean(rs.getInt("user_id"),rs.getString("name"),
								rs.getLong("post_no"),rs.getString("address"),rs.getString("tel"),
								rs.getString("mail"),rs.getDate("birthday"),new Date());
						
						if(rs.getDate("secede_date") != null)
						{
							retBean.setSecode_date(rs.getDate("secede_date"));
						}
						if(rs.getDate("update_date") != null)
						{
							retBean.setSecode_date(rs.getDate("update_date"));
						}
					}
				}catch(SQLException e) {
					e.printStackTrace();
					throw new DAOException("エラー");
				}
			}catch(SQLException e) {
				e.printStackTrace();
				throw new DAOException("エラー");
			}
		
		return retBean;
	}
	
	//会員を追加する
	public boolean bAddUser(UserBean _user) throws DAOException
	{
		boolean bRet = false;
		
		//先にシーケンス情報を取得
		int sequence = 0;
		String sql = "SELECT nextval('user_sequence')";
		
		try(				Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement ps = con.prepareStatement(sql);)
		{
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				sequence = rs.getInt(1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException("エラー");
		}
		
		//追加
		 sql = "INSERT INTO user_table VALUES (?,?,?,?,?,?,?,?)";
		
		try (
				Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement ps = con.prepareStatement(sql);)
		{
			Date date = new Date();
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			ps.setInt(1, sequence);
			ps.setString(2, _user.getStrName());
			ps.setLong(3, _user.getPost_no());
			ps.setString(4, _user.getAddress());
			ps.setString(5, _user.getTel());
			ps.setString(6, _user.getTel());
			ps.setString(7, _user.getMail());
			
			//StringからsqlDateにフォーマット
			java.sql.Date sqlDate = java.sql.Date.valueOf(_user.getBirthday());
			ps.setDate(7, sqlDate);
			
			//javaDateを変換
			sqlDate = new java.sql.Date(date.getTime());
			ps.setDate(8, sqlDate);
			
			int n = ps.executeUpdate();
			
			if(n == 1)
			{
				bRet = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException("エラー");
		}
		return bRet;
	}
	
	//会員情報を変更する
	public boolean changeUserInfo(UserBean _user) throws DAOException
	{
		boolean bRet = false;
		
		String sql = "UPDATE user_table SET name = ? , post_no = ? , address = ? , tel = ? , mail = ? , birthday = ? , update_date = CURRENT_TIMESTAMP WHERE user_id = ?";
		
		try (
				Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement ps = con.prepareStatement(sql);)
		{
			ps.setString(1, _user.getStrName());
			ps.setLong(2, _user.getPost_no());
			ps.setString(3, _user.getAddress());
			ps.setString(4, _user.getTel());
			ps.setString(5, _user.getMail());
			
			//StringからsqlDateにフォーマット
			java.sql.Date sqlDate = java.sql.Date.valueOf(_user.getBirthday());
			ps.setDate(6,sqlDate);
			
			ps.setInt(7, _user.getiID());
			int n = ps.executeUpdate();
			
			if(n == 1)
			{
				bRet = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException("エラー");
		}
		return bRet;
	}
	

}
