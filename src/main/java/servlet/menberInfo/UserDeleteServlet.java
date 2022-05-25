package servlet.menberInfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.DAOException;
import dao.UserDAO;

@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		UserBean user = (UserBean)session.getAttribute("menberInfo");
		try {
			UserDAO userDAO = new UserDAO();
			userDAO.deleteUser(user.getiID());
			gotoPage(request,response,"menberInfo/DeleteUserComp.jsp");
		}catch(DAOException e){
			e.printStackTrace();
			request.setAttribute("message", "エラー：SQLエラー1");
			gotoPage(request,response,"/errInternal.jsp");
		}
	}
	
	private void gotoPage(HttpServletRequest request, HttpServletResponse response,String page) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
