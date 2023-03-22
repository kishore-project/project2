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
 * Servlet implementation class CL_query
 */
@WebServlet("/CL_query")
public class CL_query extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String fid=request.getParameter("fid");
		String fname=request.getParameter("fname");
		String clid=request.getParameter("clid");
		String question=request.getParameter("question");
		String sts="requested";
		try {
			String qur="insert into cl_query values(?,?,?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
			
			ps1.setString(1,name);			
			ps1.setString(2,fid);
			ps1.setString(3,fname);
			ps1.setString(4,clid);
			ps1.setString(5,question);
			ps1.setString(6,sts);

			int i=ps1.executeUpdate();
			
			if(i>0) {
				out.print("<html><body><script>alert('Thank for your Response')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CL_homepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('your not fill')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CL_query.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
