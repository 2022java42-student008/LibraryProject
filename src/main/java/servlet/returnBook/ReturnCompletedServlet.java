package servlet.returnBook;

import java.io.IOException;

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
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
	   try {
	    HttpSession session = request.getSession(false);
        Integer num1 = (Integer)session.getAttribute("rentalInfo");
	    RentalBean bean = (RentalBean)session.getAttribute("iRentalID");
	    RentalDAO dao = new RentalDAO();
	    
	   }catch (DAOException e) {
		   
	   }
	   
        RequestDispatcher rd = request.getRequestDispatcher("/./ReturnDiscriminant.jsp");
        rd.forward(request, response);
 
 }


}
