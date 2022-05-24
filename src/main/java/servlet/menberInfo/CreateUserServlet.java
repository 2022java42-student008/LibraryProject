package servlet.menberInfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.DAOException;
import dao.UserDAO;

@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDAO userDAO;
		UserBean user;
		
		try {
			userDAO = new UserDAO();
			user = new UserBean();
			user.setStrName(request.getParameter("name"));
			user.setPost_no(Long.parseLong(request.getParameter("post")));
			user.setAddress(request.getParameter("address"));
			user.setTel(request.getParameter("tel"));
			user.setMail(request.getParameter("mail"));
			user.setBirthday(request.getParameter("birthday"));
			if(userDAO.bAddUser(user))
			{
				//request.setAttribute("user",user);
				gotoPage(request,response,"menberInfo/CreateUserComp.html");
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
