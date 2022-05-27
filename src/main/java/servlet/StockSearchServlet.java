package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BookBean;
import dao.BookDAO;
import dao.DAOException;

@WebServlet("/StockSearchServlet")
public class StockSearchServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String BookID = request.getParameter("BookID");
		
		if (BookID == null || BookID.length() == 0) {
			response.sendRedirect(request.getHeader("REFERER"));
			return;
		}
        int IDForSearch = Integer.parseInt(BookID);

		

		try {
			BookDAO dao = new BookDAO();
			List<BookBean> list = dao.findBooks(IDForSearch);
			BookBean bookBean = new BookBean();
			List<Integer> bookIDList = new ArrayList<Integer>();
			if(list.size() ==1)
			{
				bookBean = list.get(0);
				
				//ISBNを検索
				bookIDList = dao.liFindBookIDFromISBN(bookBean.getIsbn());
			}
			request.setAttribute("searchResult", bookBean);
			HttpSession session = request.getSession();
			session.setAttribute("searchResult", bookBean);
			session.setAttribute("bookIDs", bookIDList);

		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");

		}
		
		response.sendRedirect(request.getHeader("REFERER"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}
}