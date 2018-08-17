package model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HumanServlet
 */
@WebServlet("/HumanServlet")
public class HumanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HumanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストスコープに保存するインスタンス(JavaBeans)の生成
        Human human = new Human("山田太郎", 20);

        // リクエストスコープにインスタンスを保存
        request.setAttribute("human", human);

        // リクエストスコープからインスタンスを取得
        Human h = (Human)request.getAttribute("human");
        //getAttribute()メソッドの戻り値はオブジェクト型なので、任意の型にキャストして使用します。
        // JSPへフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/requestScopeSample.jsp");
            dispatcher.forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
