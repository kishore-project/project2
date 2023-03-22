package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.database;

/**
 * Servlet implementation class CL_payment
 */
@WebServlet("/CL_payment")
public class CL_payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String plan=request.getParameter("plan");
		String cnumber=request.getParameter("cnumber");
		String cdname=request.getParameter("cdname");
	
		
		try {
			
			String qur="insert into cl_payment values(?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
		
			ps1.setString(1,name);	
			ps1.setString(2,plan);
			ps1.setString(3,cnumber);
			ps1.setString(4,cdname);
			
            int i=ps1.executeUpdate();
			
			if(i>0) {
				out.print("<html><body><script>alert('Payment sucessfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CL_homepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('your not paid')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CL_payment.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
