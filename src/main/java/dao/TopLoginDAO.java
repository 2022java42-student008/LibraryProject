package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopLoginDAO{
	//URL、ユーザ名、パスワード準備
	private String url = "jdbc:postgresql:sample";
	private String user ="student";
	private String pass ="himitu";
	
	public TopLoginDAO() throws DAOException
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
	
	//ログインできたかどうか返す
	public boolean isLogin(int _sID ,String _sPass)throws DAOException
	{
		boolean bRet =false;
		//SQL文の作成
		String sql = "SELECT * FROM manager WHERE manager_id = ? AND password = ?";
		
		try (
			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, _sID);
			ps.setString(2, _sPass);
			
			try {
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					bRet = true;
				}
			}catch(SQLException e) {
				e.printStackTrace();
				throw new DAOException("エラー");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DAOException("エラー");
		}
		
		return bRet;
	}
}
