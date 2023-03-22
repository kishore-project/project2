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
 * Servlet implementation class OR_sendcv
 */
@WebServlet("/OR_sendcv")
public class OR_sendcv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sts=request.getParameter("status");
		ResultSet rs1=null;
		 try {
			   String qur2="update cl_file set status='"+sts+"'";
			   int r=database.getconnection().prepareStatement(qur2).executeUpdate();
			   if(sts.equals("pending")) {
					
					out.print("<html><body><script>(Not Send Properly)</script></body></html>");
					RequestDispatcher rd= request.getRequestDispatcher("OR_homepg.html");
					rd.include(request, response);
					
				    
				
				}else {
					
					 out.print("<html><body><script>(Update cloud vendor)</script></body></html>");
				     RequestDispatcher rd = request.getRequestDispatcher("OR_homepg.html");
				     rd.include(request, response);
				}
			
			   String qur1="select * from or_enc";
			   PreparedStatement ps1= database.getconnection().prepareStatement(qur1);
			   rs1 = ps1.executeQuery();
			  while(rs1.next()) { 
			   String qur="insert into or_sendtocv values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				   PreparedStatement ps= database.getconnection().prepareStatement(qur);
				   
				   ps.setString(1, rs1.getString(1));
		           ps.setString(2, rs1.getString(2));
		           ps.setString(3, rs1.getString(3));
		           ps.setString(4, rs1.getString(4));
		           ps.setString(5, rs1.getString(5));
		           ps.setString(6, rs1.getString(6));
		           ps.setString(7, rs1.getString(7));
		           ps.setString(8, rs1.getString(8));
		           ps.setString(9, rs1.getString(9));
		           ps.setString(10, rs1.getString(10));
		           ps.setString(11, rs1.getString(11));
		           ps.setString(12, rs1.getString(12));
		           ps.setString(13, rs1.getString(13));
		           ps.setString(14, rs1.getString(14));
		           ps.setString(15, rs1.getString(15));
		           ps.setString(16, rs1.getString(16));
		           ps.setString(17, rs1.getString(17));
		           ps.setString(18, rs1.getString(18));
		          ps.executeUpdate();
			  }
			  		           		 		  
		 		   response.getWriter().print("<html><body><script>alert('Encrypted Data has been Send to Cloud Vendor')</script></body></html>");
		 		   RequestDispatcher rd = request.getRequestDispatcher("OR_homepg.html");
		 		   rd.include(request,response);
		       
		 		 
		 	
		 		
	} catch (Exception e) { 
     
		System.out.println(e);
	}
		
	}

}
