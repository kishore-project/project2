package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import utility.database;

/**
 * Servlet implementation class CL_register
 */
@WebServlet("/CL_register")
public class CL_register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String cpass=request.getParameter("cpass");
		String num=request.getParameter("num");
		String org=request.getParameter("org");
		String pcode=request.getParameter("pcode");
		String add=request.getParameter("add");
		String sts="requested";
		try {
			String qur="insert into cl_register values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
			
			ps1.setString(1,name);			
			ps1.setString(2,email);
			ps1.setString(3,pass);
			ps1.setString(4,cpass);
			ps1.setString(5,num);
			ps1.setString(6,org);
			ps1.setString(7,pcode);
			ps1.setString(8,add);
			ps1.setString(9,sts);
			
			int i=ps1.executeUpdate();
			
			if(i>0) {
				out.print("<html><body><script>alert('Client Register sucessfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CL_login.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('your not registered')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CL_register.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
