package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import utility.database;

/**
 * Servlet implementation class CL_uploaddata
 */
@WebServlet("/CL_uploaddata")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 10737418240L,     // 10 GB
maxRequestSize = 10737418240L   // 100 gb
)
public class CL_uploaddata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("file");
		PrintWriter out=response.getWriter();
		String email = request.getParameter("email");
		String cname=request.getParameter("cname");
    	String name=request.getParameter("name");
    	String sts="pending";
    
    	
		Random r = new Random();
		int id = r.nextInt(100);
		
		Part part=request.getPart("file");
		
		String csvFilePath="F:/projec/thirdproject/thirdproject/datasest/dataset.csv" + part.getSubmittedFileName();
	    part.write(csvFilePath);
		
		try {
			
			String qur= "LOAD DATA INFILE '"+csvFilePath+"'" + 
	   	 		      "INTO TABLE cl_upload FIELDS TERMINATED BY ','" + 
	   	 		      "OPTIONALLY ENCLOSED by '\"' LINES TERMINATED BY '\r\n' ignore 1 LINES";			
		   int i = utility.database.getconnection().prepareStatement(qur).executeUpdate();
		   
			if(i>0) {
				out.print("<html><body><script>alert('File uploaded sucessfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CL_homepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('you not Upload')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CL_homepg.html");
				rd.include(request, response);
			}
			    
			    String qur1="insert into cl_file values(?,?,?,?,?)";
 			    String query="select * from cl_register where email=?";
			    
				
			    PreparedStatement ps1 = database.getconnection().prepareStatement(qur1);
				
			    PreparedStatement ps = database.getconnection().prepareStatement(query);
				ps.setString(1, email);
				ResultSet rs =ps.executeQuery(); 
				if(!rs.first() ) {
					
						out.print("<html><body><script>alert('Email will be wrong')</script></body></html>");
						RequestDispatcher rd = request.getRequestDispatcher("CL_homepg.html");
						rd.forward(request, response);
					 return ;
				}
				   
				  
				
				   ps1.setLong(1,id);
				   ps1.setString(2,cname);
				   ps1.setString(3,email);			
				   ps1.setString(4,name);
				   ps1.setString(5,sts);
				  
				   int i1=ps1.executeUpdate();
			   
			if(i1>0) {
				out.print("<html><body><script>alert(Update file name sucessfully)</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CL_homepg.html");
				rd.forward(request,response);
			}
			else {
				out.print("<html><body><script>alert(Not upload)</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("CL_homepg.html");
				rd.forward(request,response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
