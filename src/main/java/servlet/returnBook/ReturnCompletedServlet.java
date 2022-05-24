package servlet.returnBook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReturnCompletedServlet")
public class ReturnCompletedServlet extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
	    String sql = "UPDATE rental SET return_date='CURRENT_DAT' WHERE rental_id=?   ";
	
        RequestDispatcher rd = request.getRequestDispatcher("/./ReturnDiscriminant.jsp");
        rd.forward(request, response);
 
 }


}
