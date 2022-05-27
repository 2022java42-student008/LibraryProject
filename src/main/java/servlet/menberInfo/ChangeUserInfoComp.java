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
@WebServlet("/ChangeUserInfoComp")
public class ChangeUserInfoComp extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		UserBean user = (UserBean)session.getAttribute("user");
		
		user.setBirthday((user.getBirthday().replace('/','-')));
		try {
			UserDAO userDAO = new UserDAO();
			if(userDAO.changeUserInfo(user))
			{
				
				session.invalidate();
				gotoPage(request,response,"menberInfo/ChangeUserComp.html");
				return;
			}
			else
			{
				response.sendRedirect(request.getHeader("REFERER"));
			}
		}catch(DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "エラー：SQLエラー1");
			gotoPage(request,response,"/errInternal.jsp");
			return;
		}
		
	
	}

	
	private void gotoPage(HttpServletRequest request, HttpServletResponse response,String page) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
