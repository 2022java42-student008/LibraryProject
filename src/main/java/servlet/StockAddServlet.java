package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StockAddBean;
import bean.StockAddBean2;
import dao.StockAddDAO;
import dao.StockAddDAO2;
import dao.DAOException;

@WebServlet("/StockAddServlet")
public class StockAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
			//パラメータの解析
			String action = request.getParameter("action");
		    //モデルのDAOを生成
			StockAddDAO dao = new StockAddDAO();
	
			
	   //stockに資料を登録する処理
		if(action.equals("add")) {
			
			int bookid = Integer.parseInt(request.getParameter("bookid"));
			long isbn = Long.parseLong(request.getParameter("isbn"));
			String title = request.getParameter("title");
			String arrivalDate = request.getParameter("arrivalDate");
			String remarks = request.getParameter("remarks");
			int code = Integer.parseInt(request.getParameter("code"));
			String author = request.getParameter("author");
			String publisher = request.getParameter("publisher");
			String publish_date = request.getParameter("publish_date");
			
			
			dao.AddBooks(bookid, isbn, title, arrivalDate, remarks, code, author, publisher, publish_date)
		
		 //追加後、登録した内容を表示
		   
		}

	   
		