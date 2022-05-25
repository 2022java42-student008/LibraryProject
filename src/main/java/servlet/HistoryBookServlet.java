package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RentalBean;
import dao.DAOException;
import dao.RentalDAO;

@WebServlet("/HistoryBookServlet")
public class HistoryBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equals("history")) {
			String text = request.getParameter("search");
			if (text == null) {
				try {

					RentalDAO dao = new RentalDAO();
					List<RentalBean> listRental = dao.ListAllRentalInfo();
					// Listをリクエストスコープに入れてjspへフォワードする
					request.setAttribute("history", listRental);
					RequestDispatcher rd = request.getRequestDispatcher("/LendHistory.jsp");
					rd.forward(request, response);

				} catch (DAOException e) {
					e.printStackTrace();
					request.setAttribute("message", "内部エラーが発生しました。");
					RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
					rd.forward(request, response);
					return;
				}
			}

		}

	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
