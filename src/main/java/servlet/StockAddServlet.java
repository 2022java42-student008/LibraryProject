package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StockAddBean;
import bean.StockAddBean2;
import dao.BookDAO;
import dao.DAOException;
import dao.StockAddDAO;
import dao.StockAddDAO2;

@WebServlet("/StockAddServlet")
public class StockAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// パラメータの解析
		String action = request.getParameter("action");

		try {

			if (action.equals("add")) {

				// モデルのDAOを生成
				StockAddDAO dao = new StockAddDAO();
				StockAddDAO2 dao2 = new StockAddDAO2();
				BookDAO bookdao = new BookDAO();

				// 登録したら登録完了画面へ
				HttpSession session = request.getSession();
				StockAddBean bookinfo1 = (StockAddBean) session.getAttribute("bookinfo1");
				StockAddBean2 bookinfo2 = (StockAddBean2) session.getAttribute("bookinfo2");

				long isbn = bookinfo1.getIsbn();
				String title = bookinfo1.getTitle();
				String arrivalDate = bookinfo1.getArrivalDate();
				String remarks = bookinfo1.getRemarks();
				int code = bookinfo2.getCode();
				String author = bookinfo2.getAuthor();
				String publisher = bookinfo2.getPublisher();
				String publish_date = bookinfo2.getPublishDate();

				dao.AddBooks(isbn, title, arrivalDate, remarks);
				if(!(bookdao.isFindInventry(isbn)))
				{
					dao2.AddBooks(isbn, title, code, author, publisher, publish_date);
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("stock/StockAddComp.jsp");
				rd.forward(request, response);
				return;

			}

			// 追加後、登録した内容を表示

			if (action.equals("conf")) {

				long isbn = Long.parseLong(request.getParameter("ISBN"));
				String title = request.getParameter("title");
				String arrivalDate = request.getParameter("arrivalDate");
				String remarks = request.getParameter("remarks");
				int code = Integer.parseInt(request.getParameter("code"));
				String author = request.getParameter("author");
				String publisher = request.getParameter("publisher");
				String publish_date = request.getParameter("publish_date");

				StockAddBean info1 = new StockAddBean();
				StockAddBean2 info2 = new StockAddBean2();

				info1.setIsbn(isbn);
				info1.setTitle(title);
				info1.setArrivalDate(arrivalDate);
				info1.setRemarks(remarks);

				info2.setIsbn(isbn);
				info2.setTitle(title);
				info2.setCode(code);
				info2.setAuthor(author);
				info2.setPublisher(publisher);
				info2.setPublishDate(publish_date);

				HttpSession session = request.getSession();
				session.setAttribute("bookinfo1", info1);
				session.setAttribute("bookinfo2", info2);

				RequestDispatcher rd = request.getRequestDispatcher("stock/StockAddConf.jsp");
				rd.forward(request, response);

			}

		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);

		} catch (NumberFormatException n) {
			n.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("stock/StockAdd.jsp");
			rd.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
