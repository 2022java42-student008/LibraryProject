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

/**
 * Servlet implementation class BackUserInfo
 */
@WebServlet("/BackUserInfo")
public class BackUserInfo extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		UserBean sessionUser = (UserBean)(session.getAttribute("menberInfo"));
		UserBean user = (UserBean)(session.getAttribute("user"));
		
		//セッションから取得
		String strName = (String)request.getParameter("inputName");
		String strPost = (String)request.getParameter("inputPost");
		String strAddress = (String)request.getParameter("inputAddress");
		String strTel = (String)request.getParameter("inputTel");
		String strMail = (String)request.getParameter("inputMail");
		String strBirthday = (String)request.getParameter("inputBirthday");
		
		//もう一度リクエストに送る
		request.setAttribute("inputName", strName);
		request.setAttribute("inputPost", strPost);
		request.setAttribute("inputAddress", strAddress);
		request.setAttribute("inputTel", strTel);
		request.setAttribute("inputMail", strMail);
		request.setAttribute("inputBirthday", strBirthday);
		
		RequestDispatcher rd = request.getRequestDispatcher("ChangeUserInfo");
		rd.forward(request, response);
	}

}
