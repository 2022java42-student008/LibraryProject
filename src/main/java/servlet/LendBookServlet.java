package servlet;

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
import bean.StockBean;
import bean.UserBean;
import dao.BookDAO;
import dao.DAOException;
import dao.RentalDAO;
import dao.StockDAO;

@WebServlet("/LendBookServlet")
public class LendBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		if (action.equals("seach")) 
		{

			String[] lends = request.getParameterValues("lend");
			ArrayList<String> ids = new ArrayList<String>();
			
			//入力されているか
			boolean bInputdte = false;
			
			for (String id : lends) 
			{
				if (id.length() != 0) 
				{
					ids.add(id);
					bInputdte = true;
				}
			}
			
			//入力なしなので
			if(bInputdte == false)
			{
				response.sendRedirect(request.getHeader("REFERER"));
				return;
			}
			
			try {
				StockDAO dao = new StockDAO();
				BookDAO bookDAO = new BookDAO();
				
				//借りる予定の本情報（返却日時）
				List<StockBean> list = dao.findBooks(ids);
				
				List<StockBean> sendStockList = new ArrayList<StockBean>();
				List<BookBean> sendBookList =  new ArrayList<BookBean>();
				
				//借りる予定分
				for(int i = 0;i < list.size();i++)
				{
					//借りる本の資料情報
					BookBean book = bookDAO.findBooks(list.get(i).getBook_id()).get(0);
					RentalDAO rentalDAO = new RentalDAO();
					if(book.getDiscardDate() == null || book.getDiscardDate() == "" || book.getDiscardDate().length() == 0)
					{
						if(rentalDAO.nowRentalBookFromID(list.get(i).getBook_id()))
						{
							sendStockList.add(list.get(i));
							sendBookList.add(book);
						}
					}
				}
				
				//借りられる本はないので戻る
				if(sendStockList.size() == 0)
				{
					response.sendRedirect(request.getHeader("REFERER"));
					return;
				}

				HttpSession session = request.getSession();
				session.setAttribute("books", sendStockList);
				session.setAttribute("discarBook", sendBookList);

				RequestDispatcher rd = request.getRequestDispatcher("/lendingBook/LendConf.jsp");
				rd.forward(request, response);
				return;
			} catch (DAOException e) {
				e.printStackTrace();
				request.setAttribute("message", "内部エラーが発生しました。");
				RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
				rd.forward(request, response);
				return;
			}
		}
		
		//借りる処理
		if (action.equals("rentaldate")) {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			List<StockBean> list = (List<StockBean>) session.getAttribute("books");
			UserBean user = (UserBean) session.getAttribute("menberInfo");
			try {
				BookDAO dao = new BookDAO();
				dao.addrental(list, user.getiID());
				
				//レンタル情報を更新しメニューへ
				List<RentalBean> rental = new ArrayList<RentalBean>();
				RentalDAO rentalDAO = new RentalDAO();
				rental = rentalDAO.ListUserRentalInfo(user.getiID());
				session.setAttribute("rentalInfo", rental);
				
				RequestDispatcher rd = request.getRequestDispatcher("/lendingBook/LendComp.jsp");
				rd.forward(request, response);
				return;
			} catch (DAOException e) {
				e.printStackTrace();
				request.setAttribute("message", "内部エラーが発生しました。");
				RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
				rd.forward(request, response);
				return;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
