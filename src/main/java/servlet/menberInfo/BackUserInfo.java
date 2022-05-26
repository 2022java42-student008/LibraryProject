package servlet.menberInfo;

import java.io.IOException;

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
		
		String strName = null;
		String strPost = null;
		String strAddress = null;
		String strTel = null;
		String strMail = null;
		String strBirthday = null;
		
		//更新した情報のみ設定
		if(!(sessionUser.getStrName().equals(user.getStrName())))
		{
			strName = user.getStrName();
		}
		if(!(sessionUser.getPost_no() == (user.getPost_no())))
		{
			strPost = String.valueOf(user.getPost_no());
		}
		if(!(sessionUser.getAddress().equals(user.getAddress())))
		{
			strAddress = user.getAddress();
		}
		if(!(sessionUser.getTel().equals(user.getTel())))
		{
			strTel = user.getTel();
		}
		if(!(sessionUser.getMail().equals(user.getMail())))
		{
			strMail = user.getMail();
		}
		if(!(sessionUser.getBirthday().equals(user.getBirthday())))
		{
			strBirthday = user.getBirthday();
		}
		
		//もう一度セッションに送る
		session.setAttribute("inputName", strName);
		session.setAttribute("inputPost", strPost);
		session.setAttribute("inputAddress", strAddress);
		session.setAttribute("inputTel", strTel);
		session.setAttribute("inputMail", strMail);
		session.setAttribute("inputBirthday", strBirthday);
		
		response.sendRedirect("/LibraryProject/menberInfo/ChangeUserInfo.jsp");
	}

}
