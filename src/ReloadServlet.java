

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReloadServlet
 */
@WebServlet("/Reload")
public class ReloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//各スコープのインスタンスの取得※リクエストスコープは取得不要
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();

		//各スコープからアクセス回数の取得
		Integer requestAccess = (Integer)request.getAttribute("request_access");
		Integer sessionAccess = (Integer)session.getAttribute("session_access");
		Integer applicationAccess = (Integer)application.getAttribute("application_access");

		//nullチェック
		if( requestAccess == null){
			requestAccess = 0;
		}
		if( sessionAccess == null){
			sessionAccess = 0;
		}
		if( applicationAccess == null){
			applicationAccess = 0;
		}


		//アクセス回数のインクリメント
		requestAccess++;
		sessionAccess++;
		applicationAccess++;

		//各スコープへインスタンスの格納
		request.setAttribute("request_access", requestAccess);
		session.setAttribute("session_access", sessionAccess);
		application.setAttribute("application_access", applicationAccess);

		String view = "/WEB-INF/view/result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
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
