package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StockBean;
import dao.DAOException;
import dao.RentalBookDAO;

@WebServlet("/RentalBookServlet")
public class RentalBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<StockBean> list = (List<StockBean>)session.getAttribute("books");
				
		try {
			
			String action = request.getParameter("action");
			RentalBookDAO dao = new RentalBookDAO(); 
			// rentaldate 追加
			if (action.equals("rentaldate")) 
			{
				int book_id = Integer.parseInt(request.getParameter("book_id"));
				long isbn = Long.parseLong("isbn");
				String title = request.getParameter("title");
				//リクエストスコープに入れｔJSPへフォワード
				gotoPage(request,response, "/LendComp.jsp");
			} 
			else 
			{
			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request,response, "/errInternal.jsp");
		}
		
	}
	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
