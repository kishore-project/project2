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
 * Servlet implementation class CL_chooseplan
 */
@WebServlet("/CL_chooseplan")
public class CL_chooseplan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String service=request.getParameter("service");
		String mplan=request.getParameter("mplan");
		String validity=request.getParameter("validity");
		String storage=request.getParameter("storage");
		String security=request.getParameter("security");
		String sts="requested";
      
		
		try {
			String qur="insert into cl_chooseplan values(?,?,?,?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
		 
			ps1.setString(1,name);
			ps1.setString(2,service);
			ps1.setString(3,mplan);
			ps1.setString(4,validity);
			ps1.setString(5,storage);
			ps1.setString(6,security);
			ps1.setString(7,sts);
	        int i = ps1.executeUpdate();
         
			
			if(i>0) {
				out.print("<html><body><script>alert('You Chossen Security Plan "+security+"')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CL_homepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('you not Choose')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CL_viewplan.jsp");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
