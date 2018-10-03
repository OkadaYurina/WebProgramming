package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//フォワードを使用すると、処理を他のサーブレットクラスやJSPファイルに移すことが出来ます。
		HttpSession session = request.getSession();

		if (session.getAttribute("userInfo") == null){

		response.sendRedirect("LoginServlet");
		return;
		}
		String id = request.getParameter("id");

		request.setCharacterEncoding("UTF-8");

		UserDao userDao = new UserDao();
		User userDate = userDao.UserDetail(id);

		request.setAttribute("userDate",userDate);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
		dispatcher.forward(request, response);

		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータの文字コードを指定
        request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
        // getParameter()メソッドに、
        // UserUpdateのformでnameに指定したリクエストパラメータの名前を引数にすることでパラメータが取得できます。

		String id = request.getParameter("id");
		UserDao userDao = new UserDao();
		User userDate = userDao.UserDetail(id);
		String loginId = userDate.getLoginId();
		String password = request.getParameter("password");
		String passwordConf = request.getParameter("password2");
		String username = request.getParameter("username");
		String birthday = request.getParameter("birthday");


		if(!(passwordConf.equals(password))) {
			request.setAttribute("errMsg1", "入力された内容は正しくありません");
			request.setAttribute("userDate",userDate);

			// jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request, response);
			return;

		}

		// Daoに飛びます
		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		boolean flg = userDao.UserUpdate(loginId, username,birthday,password,passwordConf);
		if(!(flg == true)) {
			request.setAttribute("errMsg2", "入力された内容は正しくありません");
			request.setAttribute("userDate",userDate);

			// jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		userDate = userDao.UserDetail(id);

		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("UserListServlet");

	}
}