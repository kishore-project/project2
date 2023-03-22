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
 * Servlet implementation class CV_planupdation
 */
@WebServlet("/CV_planupdation")
public class CV_planupdation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String service=request.getParameter("service");
		String mplan=request.getParameter("mplan");
		String validity=request.getParameter("validity");
		String storage=request.getParameter("storage");
		String k=request.getParameter("k");
		String annual=request.getParameter("annual");
		
		try {
			
			
			String qur="insert into cv_planupdate values(?,?,?,?,?,?)";
									
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
			
			ps1.setString(1,service);			
			ps1.setString(2,mplan);
			ps1.setString(3,validity);
			ps1.setString(4,storage);
			ps1.setString(5,k);
			ps1.setString(6,annual);
            int i=ps1.executeUpdate();
            
			
            if(i>0) {
				out.print("<html><body><script>alert('Plan has been Updated Sucessfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CV_homepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('you not updated ')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CV_planupdation.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
