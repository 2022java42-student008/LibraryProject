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

		try {

			// if (action.equals("DiscardDateAdd")) {

			// モデルのDAOを生成
			// StockAddDAO dao = new StockAddDAO();

			// 削除してもいいか確認したら削除完了画面(StockDeleteComp)へ

			// HttpSession session = request.getSession();
			// StockAddBean bookinfo1 = (StockAddBean) session.getAttribute("bookinfo1");

			// String discardDate = bookinfo1.getDiscardDate();

			// dao.AddDiscardDate(discardDate);

			// RequestDispatcher rd =
			// request.getRequestDispatcher("stock/StockDeleteComp.jsp");
			// rd.forward(request, response);
			// return;

			// }

			// 検索後、登録した内容を表示する処理(StockConfで使う)

			if (action.equals("conf")) {

				int BookID = Integer.parseInt(request.getParameter("BookID"));

				StockAddBean info1 = new StockAddBean();

				HttpSession session = request.getSession();
				session.setAttribute("bookinfo1", info1);

				RequestDispatcher rd = request.getRequestDispatcher("stock/StockDeleteConf.jsp");
				rd.forward(request, response);

			}

			// BookIDから本を探す(findBookメソッド in BookDAO)

			String BookID = request.getParameter("BookID");

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

			} catch (DAOException e) {
				e.printStackTrace();
				request.setAttribute("message", "内部エラーが発生しました。");

			}

			response.sendRedirect(request.getHeader("REFERER"));

		} catch (NumberFormatException n) {
			n.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("stock/StockDelete.jsp");
			rd.forward(request, response);

		}

		// 入力した削除理由をセッションに入れる

		HttpSession session = request.getSession();
		String reason = request.getParameter("DeleteReason");
		session.setAttribute("reason", reason);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
