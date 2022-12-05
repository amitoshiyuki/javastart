package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
	    throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/login.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
	    throws ServletException, IOException {
	    //リクエストパラメータ取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		
		//ログイン処理実行
		Login login = new Login(userId, pass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		
		//ログイン処理の分岐
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId  );
			session.setAttribute("pass", pass  );
			
			//追加
			request.setAttribute("name", name );
			
			//フォワード
			RequestDispatcher dispatcher =
				request.getRequestDispatcher("/loginOK.jsp");
			dispatcher.forward(request,response);
		} else {
			response.sendRedirect("/webtest/LoginServlet");
		}
	}

}
