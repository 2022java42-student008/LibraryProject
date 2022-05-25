package servlet.returnBook;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.RentalBean;
import dao.DAOException;
import dao.RentalDAO;

@WebServlet("/ReturnCompletedServlet")
public class ReturnCompletedServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//	   try {
//	    HttpSession session = request.getSession(false);
//	    @SuppressWarnings("unchecked")
//		List<RentalBean> bean  = (List<RentalBean>)session.getAttribute("rentalInfo");
//	    for(RentalBean beans: bean) 
//    	{
//    	
//    		bean.add(beans.get((beans)));
//    	}
//	    RentalDAO dao = new RentalDAO();
//	    int list = dao.ReturnCompletedInfo(bean.get(0).getiRentalID());
//	    
//	    
//	    		
//	   }catch (DAOException e) {
//		   
//	   }
//	   
//        RequestDispatcher rd = request.getRequestDispatcher("/./ReturnDiscriminant.jsp");
//        rd.forward(request, response);

		String action = request.getParameter("action");

		if (action.equals("comp")) {
			try {
				HttpSession session = request.getSession(false);
				RentalDAO dao = new RentalDAO();
				@SuppressWarnings("unchecked")
				List<RentalBean> beans = (List<RentalBean>) session.getAttribute("rental");
				System.out.println(beans);
				for (RentalBean bean : beans) {
					dao.ReturnCompletedInfo(bean.iRenatalID);
				}
				RequestDispatcher rd = request.getRequestDispatcher("ReturnCompleted.html");
		        rd.forward(request, response);
				
			} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	}

}
