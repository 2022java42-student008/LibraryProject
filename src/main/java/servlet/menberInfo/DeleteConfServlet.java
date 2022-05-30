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

import bean.BookBean;
import bean.RentalBean;
import bean.UserBean;
import dao.BookDAO;
import dao.DAOException;

@WebServlet("/DeleteConfServlet")
public class DeleteConfServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		
		UserBean user = (UserBean)session.getAttribute("menberInfo");
		@SuppressWarnings("unchecked")
		List<RentalBean> rentalList = (List<RentalBean>)session.getAttribute("rentalInfo");
		List<BookBean> books = new ArrayList<BookBean>();
		boolean canDelete = true;
		
		try {
			//廃棄済みかどうか検索
			BookDAO bookDAO = new BookDAO();
			for(int i = 0; i < rentalList.size();i++) 
			{
				books.add(((List<BookBean>)bookDAO.findBooks(rentalList.get(i).getiBookID())).get(0));
				//廃棄済みか貸出中なら
				if(books.get(i).getDiscardDate() != null || books.get(i).getDiscardDate() != "" || 
						rentalList.get(i).getdFixedDate() == null || rentalList.get(i).getdFixedDate() == "")
				{
					canDelete = false;
				}
			}
			
			//退会済みかどうか
			if(user.getSecede_date() == null)
			{
				canDelete = false;
			}
			
			session.setAttribute("canDelete", canDelete);
			gotoPage(request,response,"menberInfo/DeleteUser.jsp");
			return;
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
