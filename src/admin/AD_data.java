package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

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
 * Servlet implementation class AD_data
 */
@WebServlet("/AD_data")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 10737418240L,     // 10 GB
maxRequestSize = 10737418240L   // 100 gb
)
public class AD_data extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String fileid= request.getParameter("fileid");
			String name= request.getParameter("name");
			String fkey= request.getParameter("fkey");
			/////
			Part part=request.getPart("file");
			
			String csvFilePath="D:/thirdproject/dataset/temp" + part.getSubmittedFileName();
		    part.write(csvFilePath);
			
			
			 try {
				 String qur= "LOAD DATA INFILE '"+csvFilePath+"'" + 
		   	 		      "INTO TABLE ad_upload FIELDS TERMINATED BY ','" + 
		   	 		      "OPTIONALLY ENCLOSED by '\"' LINES TERMINATED BY '\r\n' ignore 1 LINES";			
			   int i = utility.database.getconnection().prepareStatement(qur).executeUpdate();
			  			   
				  
			  if(i>0)
			  {	
			   out.print("<html><body><script>alert('File Uploaded Successfully ')</script></body></html>");
			   RequestDispatcher rd = request.getRequestDispatcher("AD_homepg.html");
			   rd.include(request,response);
	        }
		    else
		
			{
				
			    out.print("<html><body><script>alert(' not Upload')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("AD_upload.jsp");
				rd.include(request,response);
				
			 }
			  
				
			   String qur1="insert into ad_keys values(?,?,?) ";
			   PreparedStatement ps= database.getconnection().prepareStatement(qur1);
			   
			   ps.setString(1, fileid);
	           ps.setString(2, name);
	           ps.setString(3, fkey);
	          
	           int i1=ps.executeUpdate();
				
		  if(i1>0)
		  {	
		   out.print("<html><body><script>('Key Stored Successfully ')</script></body></html>");
		   RequestDispatcher rd = request.getRequestDispatcher("AD_homepg.html");
		   rd.include(request,response);
       }
	    else
	
		{
			
		    out.print("<html><body><script>(' not Stored')</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("AD_upload.jsp");
			rd.include(request,response);
			
		 }
			  
		} catch (Exception e) { 
	     
			System.out.println(e);
		}
	}

}
