package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.database;

/**
 * Servlet implementation class AD_accregister
 */
@WebServlet("/AD_accregister")
public class AD_accregister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String sts=request.getParameter("status");
		
		try {
			String qur="update cl_register set status='"+sts+"' where name='"+name+"'";
			int r=database.getconnection().prepareStatement(qur).executeUpdate();
		
			
			if(sts.equals("rejected")) {
				
				out.print("<html><body><script>alert('Not Accept ')</script></body></html>");
				RequestDispatcher rd= request.getRequestDispatcher("AD_homepg.html");
				rd.include(request, response);
				
			    
			
			}else {
				
				 out.print("<html><body><script>alert('Client Register has been Accepted ')</script></body></html>");
			     RequestDispatcher rd = request.getRequestDispatcher("AD_homepg.html");
			     rd.include(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
