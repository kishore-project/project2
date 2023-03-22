package owner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.database;

/**
 * Servlet implementation class OR_login
 */
@WebServlet("/OR_login")
public class OR_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		try {
			
			String qur="select * from or_register where email=? and pass=?";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
			ps1.setString(1,email);
			ps1.setString(2, pass);
			ResultSet rs= ps1.executeQuery();
			
			if(rs.next()) {
				out.print("<html><body><script>alert('Owner Login Sucessfully') </script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("OR_homepg.html");
				rd.include(request, response);
			}
			else {
				out.print("<html><body><script>alert('Incorrect email and password') </script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("OR_login.html");
				rd.include(request, response);
			}
		}catch(Exception E) {
			System.out.println(E);
		}
		
	}

}
