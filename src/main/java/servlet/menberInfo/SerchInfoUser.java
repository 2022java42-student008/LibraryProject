package servlet.menberInfo;

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
import dao.UserDAO;

@WebServlet("/SerchInfoUser")
public class SerchInfoUser extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.setAttribute("sertch", request.getParameter("sertch"));
		
		String menberMail = request.getParameter("menberMail");
		
		
		UserBean user = null;
		List<RentalBean> rental = new ArrayList<RentalBean>();
		
		if(menberMail == null || menberMail.length() == 0)
		{
			response.sendRedirect(request.getHeader("REFERER"));
			return;
		}
		
		//会員を探す
		try
		{
			UserDAO userDAO = new UserDAO();
			user = userDAO.GetUser(menberMail);
		}catch(DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "エラー：SQLエラー1");
			gotoPage(request,response,"/errInternal.jsp");
			return;
		}
		
		if(user == null)
		{			
			response.sendRedirect(request.getHeader("REFERER"));
			return;
		}
			
		
		// 借りている本を探す
		try {
			RentalDAO rentalDAO = new RentalDAO();
			rental = rentalDAO.ListUserRentalInfo(user.getiID());
		}catch(DAOException e){
			e.printStackTrace();
			request.setAttribute("message", "エラー：SQLエラー2");
			gotoPage(request,response,"/errInternal.jsp");
			return;
		}
		
		
			
		
		session.setAttribute("menberInfo", user);
		session.setAttribute("rentalInfo", rental);
		
		response.sendRedirect(request.getHeader("REFERER"));
	}
	
	private void gotoPage(HttpServletRequest request, HttpServletResponse response,String page) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
