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
import dao.BookDAO;
import dao.DAOException;

/**
 * Servlet implementation class LendBookServlet
 */
@WebServlet("/StockDeleteServlet")
public class StockDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("search")) {

			try {
				int Bookinfo = Integer.parseInt(request.getParameter("BookID"));
				BookDAO dao = new BookDAO();
				List<BookBean> list = dao.findBooks(Bookinfo);

				if (list == null || list.size() == 0) {
					System.out.print("資料IDがありません");
				}

				HttpSession session = request.getSession();
				session.setAttribute("searchBook", list);
				RequestDispatcher rd = request.getRequestDispatcher("/stock/StockDeleteConf.jsp");
				rd.forward(request, response);
				return;
			} catch (DAOException e) {
				e.printStackTrace();
				request.setAttribute("message", "内部エラーが発生しました。");
				RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
				rd.forward(request, response);
				return;

			} catch (NumberFormatException n) {
				n.printStackTrace();
				request.setAttribute("message", "内部エラーが発生しました。");
				RequestDispatcher rd = request.getRequestDispatcher("stock/StockDelete.jsp");
				rd.forward(request, response);

			}
		}

		if(action.equals("delete")) {
			HttpSession session = request.getSession();
			List<BookBean> list= (List<BookBean>)session.getAttribute("searchBook");
			dao.deleteByBookID =(); 
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
