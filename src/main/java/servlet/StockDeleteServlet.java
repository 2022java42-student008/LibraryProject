package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StockBean;
import dao.DAOException;
import dao.StockDAO;

/**
 * Servlet implementation class LendBookServlet
 */
@WebServlet("/StockDeleteServlet")
public class StockDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("seach")) {

			String[] Bookinfo = request.getParameterValues("BookID");
			ArrayList<String> ids = new ArrayList<String>();
			for (String id : Bookinfo) {
				if (id.length() != 0) {
					ids.add(id);
				}
			}
			try {
				StockDAO dao = new StockDAO();
				List<StockBean> list = dao.findBooks(ids);
				if (list == null || list.size() == 0) {
					System.out.print("資料IDがありません");
				}

				HttpSession session = request.getSession();
				session.setAttribute("books", list);
				RequestDispatcher rd = request.getRequestDispatcher("/lendingBook/StockDeleteConf.jsp");
				rd.forward(request, response);
				return;
			} catch (DAOException e) {
				e.printStackTrace();
				request.setAttribute("message", "内部エラーが発生しました。");
				RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
				rd.forward(request, response);
				return;
			}
		
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
