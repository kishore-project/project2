package owner;

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
 * Servlet implementation class OR_query
 */
@WebServlet("/OR_query")
public class OR_query extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String sts=request.getParameter("status");
		
		try {
			String qur="update cl_query set status='"+sts+"' where name='"+name+"'";
			int r=database.getconnection().prepareStatement(qur).executeUpdate();
		
			
			if(sts.equals("rejected")) {
				
				out.print("<html><body><script>alert('Not Accept your query')</script></body></html>");
				RequestDispatcher rd= request.getRequestDispatcher("OR_homepg.html");
				rd.include(request, response);
				
			    
			
			}else {
				
				 out.print("<html><body><script>alert('Query has been Accepted')</script></body></html>");
			     RequestDispatcher rd = request.getRequestDispatcher("OR_homepg.html");
			     rd.include(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
