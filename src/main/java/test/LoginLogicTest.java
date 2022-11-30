package test;

import model.Login;
import model.LoginLogic;

public class LoginLogicTest {
	public static void main(String[] args) {
		testExecute1();  //ログイン成功
		testExecute2();  //ログイン失敗
	}
	public static void testExecute1() {
		Login login = new Login("ami", "1234");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if(result) {
			System.out.println("testExecute1:成功");
		} else {
			System.out.println("testExecute1:失敗");
		}
	}
	public static void testExecute2() {
		Login login = new Login("ami", "12345");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if(!result) {
		  System.out.println("testExecute2:成功");
		} else {
		  System.out.println("testExecute2:失敗");
		}
	}

}
