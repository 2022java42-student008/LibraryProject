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
import bean.UserBean;
import dao.BookDAO;
import dao.DAOException;
import dao.StockDAO;

@WebServlet("/LendBookServlet")
public class LendBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("seach")) {

			String[] lends = request.getParameterValues("lend");
			ArrayList<String> ids = new ArrayList<String>();
			for (String id : lends) {
				if (id.length() != 0) {
					ids.add(id);
				}
			}
			try {
				StockDAO dao = new StockDAO();
				List<StockBean> list = dao.findBooks(ids);
				
				if (list == null || list.size() == 0) {
					System.out.print("ないよ");
				}

				HttpSession session = request.getSession();
				session.setAttribute("books", list);
				RequestDispatcher rd = request.getRequestDispatcher("/lendingBook/LendConf.jsp");
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
		if (action.equals("rentaldate")) {
			HttpSession session = request.getSession();
			List<StockBean> list = (List<StockBean>) session.getAttribute("books");
			UserBean user = (UserBean) session.getAttribute("menberInfo");
			try {
				BookDAO dao = new BookDAO();
				dao.addrental(list, user.getiID());
				RequestDispatcher rd = request.getRequestDispatcher("/lendingBook/LendComp.jsp");
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
