package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BookBean;
import bean.StockAddBean;
import dao.BookDAO;
import dao.DAOException;

@WebServlet("/StockDeleteServlet")
public class StockDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// パラメータの解析
		String action = request.getParameter("action");
		String BookID = request.getParameter("BookID");

		try {

			// 検索後、登録した内容を表示する処理(StockConfで使う)

			if (action.equals("conf")) {

				StockAddBean info1 = new StockAddBean();

				HttpSession session = request.getSession();
				String reason = request.getParameter("DeleteReason");
				session.setAttribute("reason", reason);
				RequestDispatcher rd = request.getRequestDispatcher("stock/StockDeleteConf2.jsp");
				rd.forward(request, response);

				return;
			}

			// BookIDから本を探す(findBookメソッド in BookDAO)

			if (action.equals("search")) {
				if (BookID == null || BookID.length() == 0) {
					response.sendRedirect(request.getHeader("REFERER"));
					return;
				}
				int IDForSearch = Integer.parseInt(BookID);

				try {
					BookDAO dao = new BookDAO();
					List<BookBean> list = dao.findBooks(IDForSearch);
					request.setAttribute("searchResult", list);

					HttpSession session = request.getSession();
					session.setAttribute("searchResult", list);
					RequestDispatcher rd = request.getRequestDispatcher("stock/StockDeleteConf.jsp");
					rd.forward(request, response);
					return;
				} catch (DAOException e) {
					e.printStackTrace();
					request.setAttribute("message", "内部エラーが発生しました。");
					response.sendRedirect(request.getHeader("REFERER"));
					return;
				}
			}

		} catch (NumberFormatException n) {
			n.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("stock/StockDelete.jsp");
			rd.forward(request, response);
			return;

		}

		if (action.equals("inputRemark")) {
			// 入力した削除理由をセッションに入れる

			HttpSession session = request.getSession();
			String reason = request.getParameter("DeleteReason");
			session.setAttribute("reason", reason);
			RequestDispatcher rd = request.getRequestDispatcher("stock/StockDeleteConf2.jsp");
			rd.forward(request, response);
		}

		if (action.equals("DeleteComp")) {
			HttpSession session = request.getSession();
			String reason = (String)session.getAttribute("reason");

			try {
				BookDAO dao = new BookDAO();
				dao.BookDelete(reason);

				RequestDispatcher rd = request.getRequestDispatcher("stock/StockDeleteComp.jsp");
				rd.forward(request, response);
			} catch (DAOException e) {
				e.printStackTrace();
				request.setAttribute("message", "内部エラーが発生しました。");
				response.sendRedirect(request.getHeader("REFERER"));
				return;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
