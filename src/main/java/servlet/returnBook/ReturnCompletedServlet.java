package servlet.returnBook;

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

import bean.RentalBean;
import bean.UserBean;
import dao.DAOException;
import dao.RentalDAO;

@WebServlet("/ReturnCompletedServlet")
public class ReturnCompletedServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		//返却
		if (action.equals("comp")) {
			try {
				HttpSession session = request.getSession(false);
				RentalDAO dao = new RentalDAO();
				@SuppressWarnings("unchecked")
				List<RentalBean> beans = (List<RentalBean>) session.getAttribute("rental");
				System.out.println(beans);
				for (RentalBean bean : beans) 
				{
					dao.ReturnCompletedInfo(bean.getiRentalID());
				}
				
				//ユーザ情報の再検索
				UserBean user = (UserBean) session.getAttribute("menberInfo");
				try {
					//レンタル情報を更新しメニューへ
					List<RentalBean> rental = new ArrayList<RentalBean>();
					RentalDAO rentalDAO = new RentalDAO();
					rental = rentalDAO.ListUserRentalInfo(user.getiID());
					session.setAttribute("rentalInfo", rental);
					RequestDispatcher rd = request.getRequestDispatcher("ReturnCompleted.html");
			        rd.forward(request, response);
					return;
				} catch (DAOException e) {
					e.printStackTrace();
					request.setAttribute("message", "内部エラーが発生しました。");
					RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
					rd.forward(request, response);
					return;
				}

				
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	}

}
