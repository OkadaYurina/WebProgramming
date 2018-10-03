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

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("userInfo") == null){

		response.sendRedirect("LoginServlet");
		return;

		}
		//フォワードを使用すると、処理を他のサーブレットクラスやJSPファイルに移すことが出来ます。
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CreateUser.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        // リクエストパラメータの文字コードを指定
        request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
        // getParameter()メソッドに、
        // CreateUserのformでnameに指定したリクエストパラメータの名前を引数にすることでパラメータが取得できます。
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String passwordConf = request.getParameter("password2");
		String username = request.getParameter("username");
		String birthday = request.getParameter("birthday");



		//TODO:パスワードと確認パスワードが異なる場合、エラーメッセージを表示

		if(!(passwordConf.equals(password))) {
			request.setAttribute("errMsg1", "入力された内容は正しくありません");
			request.setAttribute("loginId", loginId);
			request.setAttribute("username", username);
			request.setAttribute("birthday", birthday);

			// jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CreateUser.jsp");
			dispatcher.forward(request, response);
			return;

		}

		// Daoに飛びます
		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		UserDao userDao = new UserDao();
		boolean flg = userDao.SignUpUser(loginId, username,birthday,password);

		if(!(flg == true)) {
			request.setAttribute("errMsg2", "入力された内容は正しくありません");
			request.setAttribute("loginId", loginId);
			request.setAttribute("username", username);
			request.setAttribute("birthday", birthday);

			// jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CreateUser.jsp");
			dispatcher.forward(request, response);
			return;
		}



		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("UserListServlet");

	}
}
