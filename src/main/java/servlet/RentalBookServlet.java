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

import bean.RentalBean;
import bean.UserBean;
import dao.DAOException;
import dao.RentalDAO;

@WebServlet("/RentalBookServlet")
public class RentalBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
				
			String action = request.getParameter("action");
			// rentaldate 追加
			if (action.equals("rentaldate")) 
			{
				try {
					HttpSession session = request.getSession();
					UserBean user = (UserBean) session.getAttribute("menberInfo");
					//レンタル情報を更新しメニューへ
					List<RentalBean> rental = new ArrayList<RentalBean>();
					RentalDAO rentalDAO = new RentalDAO();
					rental = rentalDAO.ListUserRentalInfo(user.getiID());
					session.setAttribute("rentalInfo", rental);
				}catch(DAOException e){
					e.printStackTrace();
					request.setAttribute("message", "エラー：SQLエラー2");
					gotoPage(request,response,"/errInternal.jsp");
					return;
				}
				
				//リクエストスコープに入れｔJSPへフォワード
				gotoPage(request,response, "/LendComp.jsp");
			} 
	}
	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
