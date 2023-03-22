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
 * Servlet implementation class CV_updatefile
 */
@WebServlet("/CV_updatefile")
public class CV_updatefile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String email=request.getParameter("email");		
		String file=request.getParameter("file");
		
		try {
			String qur="insert into cv_updatefile values(?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
			
			ps1.setString(1,id);
			ps1.setString(2,name);			
			ps1.setString(3,email);
			ps1.setString(4,file);
		
            int i=ps1.executeUpdate();
			
			if(i>0) {
				out.print("<html><body><script>alert('File has been Updated to Admin')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CV_homepg.html");
				rd.include(request,response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	
	}

}
