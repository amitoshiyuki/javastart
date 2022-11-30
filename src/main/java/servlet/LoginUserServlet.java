package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoginUserBean;
import dao.LoginUserDAO;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// ログイン画面へ遷移
    	RequestDispatcher rd = request.getRequestDispatcher("/userlogin.jsp");
    	rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Jspのフォーム画面からログイン対象ユーザIDとパスワードを取得
		request.setCharacterEncoding("UTF-8");
		String input_userID = request.getParameter("userid");
		String input_userPW = request.getParameter("userpw");
		
		try{
			// Beanクラスのインスタンス
			LoginUserBean input_user = new LoginUserBean();
			
			// Beanクラスに入力したユーザIDとパスワードをセットする
			input_user.setLogin_user_id(input_userID);
			input_user.setLogin_user_pw(input_userPW);
			
			// リスト＜Beanクラス＞に検索結果を格納する
			ArrayList<LoginUserBean> user_list = LoginUserDAO.getInstance().SelectLoginUser(input_user);
			
			// ユーザ情報なしもしくは複数件の場合はログイン画面に戻る
			if (user_list == null || user_list.size() != 1){
				// ログインフラグを立てる（0：OK、1：NG）
				LoginUserBean result = new LoginUserBean();	
				result.setLogin_user_flg(1);
				// ログイン画面に返す
				request.setAttribute("result", result);
				request.getRequestDispatcher("/userlogin.jsp").forward(request, response);
			} else {
				// ログインユーザ用にBeanクラスをインスタンス
				LoginUserBean result_user = new LoginUserBean();
				
				// ユーザIDとユーザ名のみ新たにBeanクラスに格納する
				result_user.setLogin_user_id(user_list.get(0).getLogin_user_id());
				result_user.setLogin_user_name(user_list.get(0).getLogin_user_name());
				
				// ログインOK画面に返す
				HttpSession session = request.getSession();
				session.setAttribute("result_user", result_user);
				request.getRequestDispatcher("/userloginOK.jsp").forward(request, response);
				
			}
			
		}catch(Exception e){
			//何らかの理由で失敗したらエラーページにエラー文を渡して表示。
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}

}
