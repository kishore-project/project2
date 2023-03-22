package cloudvendor;

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
 * Servlet implementation class CV_updateplan
 */
@WebServlet("/CV_updateplan")
public class CV_updateplan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String fkey=request.getParameter("fkey");
		String service=request.getParameter("service");
		String plan=request.getParameter("plan");
		String validity=request.getParameter("validity");
		String storage=request.getParameter("storage");
		
      
		
		try {
			String qur="insert into cv_updateplan values(?,?,?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
		 
			ps1.setString(1,name);
			ps1.setString(2,fkey);
			ps1.setString(3,service);
			ps1.setString(4,plan);
			ps1.setString(5,validity);
			ps1.setString(6,storage);
			
	        int i = ps1.executeUpdate();
         
			
			if(i>0) {
				out.print("<html><body><script>alert('Plan has been Updated to Admin')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CV_homepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('you not update')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CV_viewplanrq.jsp");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
