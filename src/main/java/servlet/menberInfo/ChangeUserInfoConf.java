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

@WebServlet("/ChangeUserInfoConf")
public class ChangeUserInfoConf extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//リクエストから取得
		String strName = (String)request.getParameter("inputName");
		String strPost = (String)request.getParameter("inputPost");
		String strAddress = (String)request.getParameter("inputAddress");
		String strTel = (String)request.getParameter("inputTel");
		String strMail = (String)request.getParameter("inputMail");
		String strBirthday = (String)request.getParameter("inputBirthday");
		
		//セッションから取得
		HttpSession session = request.getSession(false);
		
		UserBean user = (UserBean)session.getAttribute("menberInfo");
		
		//比較して挿入
		if(!(strName == null || strName.length() == 0))
		{
			user.setStrName(strName);
		}
		
		if(!(strPost == null || strPost.length() == 0))
		{
			user.setPost_no(Long.parseLong(strBirthday));
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
		}
		
		if(!(strBirthday == null || strBirthday.length() == 0))
		{
			user.setBirthday(strBirthday);
		}
		
		session.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("menberInfo/ChangeUserConf.jsp");
		rd.forward(request, response);
		
	}

}
