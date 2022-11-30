package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class LoginUserDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:h2:tcp://localhost/~/test";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public Account findByLogin(Login login) {
		Account account = null;
		
		//データベース接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {
			
			//select文を準備
			String sql = "SELECT USER_ID, NAME, PW "
					+ "ACCOUNT WHERE USER_ID = ? AND PW = ?";
			    
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPw());
			
			//SELECT文を実行し取得
			ResultSet rs = pStmt.executeQuery();
					
			//一致したユーザが存在した場合
			if (rs.next()) {
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PW");
				String name = rs.getString("NAME");
				account = new Account(userId, name, pw);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}

}
