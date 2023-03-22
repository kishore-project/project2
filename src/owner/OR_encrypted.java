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
 * Servlet implementation class OR_encrypted
 */
@WebServlet("/OR_encrypted")
public class OR_encrypted extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rs1=null;
		String sec= request.getParameter("sec");
		
		try {
			 
			if(sec.equalsIgnoreCase("low"))
			       {
			        String qry2 = "select * from cl_upload";
			        rs1 = database.getconnection().createStatement().executeQuery(qry2);
		              while(rs1.next()) 
				       {
						 String qur2="insert into or_enc(id,brand,displaysize,processorname,hard_disk_cap,RAM_size,Model_name,color,security_num,RAM_Type,warranty,Touchscreen,graphic_processor,suitable,speaker,screen_type,power_supply,Keyboard) "
						 + "values(DES_encrypt(?, '"+1+"'),DES_encrypt(?, '"+2+"'),DES_encrypt(?, '"+3+"'),DES_encrypt(?, '"+4+"'),DES_encrypt(?, '"+5+"'),DES_encrypt(?, '"+6+"'),DES_encrypt(?, '"+7+"'),DES_encrypt(?, '"+8+"'),DES_encrypt(?, '"+9+"'),DES_encrypt(?, '"+10+"'),DES_encrypt(?, '"+11+"'),DES_encrypt(?, '"+12+"'),DES_encrypt(?, '"+13+"'),DES_encrypt(?, '"+14+"'),DES_encrypt(?, '"+15+"'),DES_encrypt(?, '"+16+"'),DES_encrypt(?, '"+17+"'),DES_encrypt(?, '"+18+"'))";
						 PreparedStatement ps2= database.getconnection().prepareStatement(qur2);
						 ps2.setString(1, rs1.getString(1));
				         ps2.setString(2, rs1.getString(2));
				         ps2.setString(3, rs1.getString(3));
				         ps2.setString(4, rs1.getString(4));
				         ps2.setString(5, rs1.getString(5));
				         ps2.setString(6, rs1.getString(6));
				         ps2.setString(7, rs1.getString(7));
				         ps2.setString(8, rs1.getString(8));
				         ps2.setString(9, rs1.getString(9));
				         ps2.setString(10, rs1.getString(10));
				         ps2.setString(11, rs1.getString(11));
				         ps2.setString(12, rs1.getString(12));
				         ps2.setString(13, rs1.getString(13));
				         ps2.setString(14, rs1.getString(14));
				         ps2.setString(15, rs1.getString(15));
				         ps2.setString(16, rs1.getString(16));
				         ps2.setString(17, rs1.getString(17));
				         ps2.setString(18, rs1.getString(18));
				         ps2.executeUpdate();
				        }
					  
					 PrintWriter out2 = response.getWriter();			
					 out2.print("<html><body><script>alert('Low Level Security Data Encrypted Successfully ')</script></body></html>");
					 RequestDispatcher rd2 = request.getRequestDispatcher("OR_homepg.html");
					 rd2.include(request,response);
                 
			 }	 
			 
			  
		    else if(sec.equalsIgnoreCase("medium")) 
		    {
		       String qry2 = "select * from cl_upload";
			   rs1 = database.getconnection().createStatement().executeQuery(qry2);		 
			     while(rs1.next()) 
			     {
		  		 String qur2="insert into or_enc(id,brand,displaysize,processorname,hard_disk_cap,RAM_size,Model_name,color,security_num,RAM_Type,warranty,Touchscreen,graphic_processor,suitable,speaker,screen_type,power_supply,Keyboard) "
				 + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			     PreparedStatement ps2= database.getconnection().prepareStatement(qur2);
				 ps2.setString(1, OR_blowfish.encrypt(rs1.getString(1), "1"));
		         ps2.setString(2, OR_blowfish.encrypt(rs1.getString(2),"2"));
		         ps2.setString(3, OR_blowfish.encrypt(rs1.getString(2),"3"));
		         ps2.setString(4, OR_blowfish.encrypt(rs1.getString(2),"4"));
		         ps2.setString(5, OR_blowfish.encrypt(rs1.getString(2),"5"));
		         ps2.setString(6, OR_blowfish.encrypt(rs1.getString(2),"6"));
		         ps2.setString(7, OR_blowfish.encrypt(rs1.getString(2),"7"));
		         ps2.setString(8, OR_blowfish.encrypt(rs1.getString(2),"8"));
		         ps2.setString(9, OR_blowfish.encrypt(rs1.getString(2),"9"));
		         ps2.setString(10, OR_blowfish.encrypt(rs1.getString(2),"10"));
		         ps2.setString(11, OR_blowfish.encrypt(rs1.getString(2),"11"));
		         ps2.setString(12, OR_blowfish.encrypt(rs1.getString(2),"12"));
		         ps2.setString(13, OR_blowfish.encrypt(rs1.getString(2),"13"));
		         ps2.setString(14, OR_blowfish.encrypt(rs1.getString(2),"14"));
		         ps2.setString(15, OR_blowfish.encrypt(rs1.getString(2),"15"));
		         ps2.setString(16, OR_blowfish.encrypt(rs1.getString(2),"16"));
		         ps2.setString(17, OR_blowfish.encrypt(rs1.getString(2),"17"));
		         ps2.setString(18, OR_blowfish.encrypt(rs1.getString(2),"18"));
		         ps2.executeUpdate();
		        }
			  
			    PrintWriter out2 = response.getWriter();			
			    out2.print("<html><body><script>alert('Medium Level Security Data Encrypted Successfully ')</script></body></html>");
			    RequestDispatcher rd2 = request.getRequestDispatcher("OR_homepg.html");
		        rd2.include(request,response);
       }	 
			 
		 else if(sec.equalsIgnoreCase("high")) 
			{
			 String qry2 = "select * from cl_upload";
		     rs1 = database.getconnection().createStatement().executeQuery(qry2);
			      while(rs1.next()) 
			       {
			         String qur="insert into or_enc(id,brand,displaysize,processorname,hard_disk_cap,RAM_size,Model_name,color,security_num,RAM_Type,warranty,Touchscreen,graphic_processor,suitable,speaker,screen_type,power_supply,Keyboard) "
			   		+ "values(aes_encrypt(?, '"+1+"'),aes_encrypt(?, '"+2+"'),aes_encrypt(?, '"+3+"'),aes_encrypt(?, '"+4+"'),aes_encrypt(?, '"+5+"'),aes_encrypt(?, '"+6+"'),aes_encrypt(?, '"+7+"'),aes_encrypt(?, '"+8+"'),aes_encrypt(?, '"+9+"'),aes_encrypt(?, '"+10+"'),aes_encrypt(?, '"+11+"'),aes_encrypt(?, '"+12+"'),aes_encrypt(?, '"+13+"'),aes_encrypt(?, '"+14+"'),aes_encrypt(?, '"+15+"'),aes_encrypt(?, '"+16+"'),aes_encrypt(?, '"+17+"'),aes_encrypt(?, '"+18+"'))";
			   
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
		     
			        PrintWriter out = response.getWriter();			
		            out.print("<html><body><script>alert('High Level Security Data Encrypted Successfully ')</script></body></html>");
		            RequestDispatcher rd = request.getRequestDispatcher("OR_homepg.html");
		            rd.include(request,response);
	        }
			
     }catch (Exception e) 
		     {
		      PrintWriter out = response.getWriter();
			  out.print("<html><body><script>alert(' not encrypted')</script></body></html>");
		      RequestDispatcher rd = request.getRequestDispatcher("OR_viewcldata.jsp");
			  rd.include(request,response);
			  System.out.println(e);
			 }
				  
	}

}
