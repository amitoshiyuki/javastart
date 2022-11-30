package bean;

import java.io.Serializable;

public class LoginUserBean implements Serializable{
	
	// フィールド宣言
	private String login_user_id;
	private String login_user_pw;
	private String login_user_name;
	private int login_user_flg;
	
	// ゲッターとセッターの作成(ユーザID)
	public String getLogin_user_id() {
		return login_user_id;
		}
	public void setLogin_user_id(String userid) {
		this.login_user_id = userid;
		}

	// ゲッターとセッターの作成（パスワード）
	public String getLogin_user_pw() {
		return login_user_pw;
		}
	public void setLogin_user_pw(String userpw) {
		this.login_user_pw = userpw;
		}
	
	// ゲッターとセッターの作成（ユーザ名）
	public String getLogin_user_name() {
		return login_user_name;
		}
	public void setLogin_user_name(String username) {
		this.login_user_name = username;
		}

	// ゲッターとセッターの作成（ユーザフラグ）
	public int getLogin_user_flg() {
		return login_user_flg;
		}
	public void setLogin_user_flg(int userflg) {
		this.login_user_flg = userflg;
		}
	
	
}
