package servlet.returnBook;

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

import bean.RentalBean;

@WebServlet("/ReturnScreenServlet")
public class ReturnScreenServlet extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
	    String[] values = request.getParameterValues("return");
	    HttpSession session = request.getSession(false);
        @SuppressWarnings("unchecked")
        List<RentalBean> bean = (List<RentalBean>) session.getAttribute("rentalInfo");
	    boolean b=false;
        
        
        ArrayList<RentalBean> list = new  ArrayList<RentalBean>();
        if(bean != null)
        {
        	for(String value: values) 
        	{
	    	 b=true;
        		list.add(bean.get(Integer.parseInt(value)));
        	}
        }
        request.setAttribute("bool", b);
        request.setAttribute("rental", list);
        RequestDispatcher rd = request.getRequestDispatcher("/./ReturnDiscriminant.jsp");
        rd.forward(request, response);
 
 }


}
