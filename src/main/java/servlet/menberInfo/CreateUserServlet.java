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

@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDAO userDAO;
		HttpSession session = request.getSession();
		UserBean user = (UserBean)session.getAttribute("CreateUser");
		
		
		try {
			userDAO = new UserDAO();
			if(userDAO.bAddUser(user))
			{
				gotoPage(request,response,"menberInfo/CreateUserComp.html");
				return;
			}
		}catch(DAOException e){
			e.printStackTrace();
			request.setAttribute("message", "エラー：SQLエラー1");
			gotoPage(request,response,"/errInternal.jsp");		
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}
	
	private void gotoPage(HttpServletRequest request, HttpServletResponse response,String page) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
