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

@WebServlet("/ChangeUserInfoConf")
public class ChangeUserInfoConf extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		//リクエストから取得
		String strName = (String)request.getParameter("inputName");
		String strPost = (String)request.getParameter("inputPost");
		String strAddress = (String)request.getParameter("inputAddress");
		String strTel = (String)request.getParameter("inputTel");
		String strMail = (String)request.getParameter("inputMail");
		String strBirthday = (String)request.getParameter("inputBirthday");
		
		//セッションから取得
		HttpSession session = request.getSession(false);
		UserBean sessionUser = (UserBean)(session.getAttribute("menberInfo"));
		UserBean user = new UserBean();
		user.setiID(sessionUser.getiID());
		user.setStrName(sessionUser.getStrName());
		user.setPost_no(sessionUser.getPost_no());
		user.setAddress(sessionUser.getAddress());
		user.setTel(sessionUser.getTel());
		user.setMail(sessionUser.getMail());
		user.setBirthday(sessionUser.getBirthday());
		user.setJoin_date(sessionUser.getJoin_date());
		user.setSecede_date(sessionUser.getSecede_date());
		user.setUpdate_date(sessionUser.getUpdate_date());
		
		//比較して挿入
		if(!(strName == null || strName.length() == 0))
		{
			user.setStrName(strName);
		}
		
		if(!(strPost == null || strPost== ""))
		{
			user.setPost_no(Long.parseLong(strPost));
		}
		
		if(!(strAddress == null || strAddress.length() == 0))
		{
			user.setAddress(strAddress);
		}
		
		if(!(strTel == null || strTel.length() == 0))
		{
			user.setTel(strTel);
		}
		
		if(!(strMail == null || strMail.length() == 0))
		{
			user.setMail(strMail);
			try {
				UserDAO userDAO = new UserDAO();
				
				//すでにあるメールアドレスなので戻る
				if(userDAO.GetUser(strMail) !=  null)
				{
					session.setAttribute("ChangeMessage", "すでに登録しているメールアドレスです");
					response.sendRedirect(request.getHeader("REFERER"));
					return;
				}
			} catch (DAOException e) {
				e.printStackTrace();
				request.setAttribute("message", "内部エラーが発生しました。");
				RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
				rd.forward(request, response);
				return;
			}
		}
		
		if(!(strBirthday == null || strBirthday.length() == 0))
		{
			user.setBirthday(strBirthday);
		}
		
		session.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("menberInfo/ChangeUserConf.jsp");
		rd.forward(request, response);
		
	}
	
	protected void dpGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
