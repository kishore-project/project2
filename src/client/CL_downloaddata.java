package client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import utility.database;

/**
 * Servlet implementation class CL_downloaddata
 */
@WebServlet("/CL_downloaddata")
public class CL_downloaddata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("csv/text");
	    
		
		try {
			String qur = "select * from ad_upload";
			PreparedStatement ps = database.getconnection().prepareStatement(qur);
         
			
			ResultSet rs = ps.executeQuery();
			StringBuilder sb = new StringBuilder();
			while(rs.next()) 
			      {
				sb.append(rs.getString("id"));
				sb.append(",");
				sb.append(rs.getString("brand"));
				sb.append(",");
				sb.append(rs.getString("displaysize"));
				sb.append(",");
				sb.append(rs.getString("processorname"));
				sb.append(",");
				sb.append(rs.getString("hard_disk_cap"));
				sb.append(",");
				sb.append(rs.getString("RAM_size"));
				sb.append(",");
				sb.append(rs.getString("Model_name"));
				sb.append(",");
				sb.append(rs.getString("color"));
				sb.append(",");
				sb.append(rs.getString("security_num"));
				sb.append(",");
				sb.append(rs.getString("RAM_Type"));
				sb.append(",");
				sb.append(rs.getString("warranty"));
				sb.append(",");
				sb.append(rs.getString("Touchscreen"));
				sb.append(",");
				sb.append(rs.getString("graphic_processor"));
				sb.append(",");
				sb.append(rs.getString("suitable"));
				sb.append(",");
				sb.append(rs.getString("speaker"));
				sb.append(",");
				sb.append(rs.getString("screen_type"));
				sb.append(",");
				sb.append(rs.getString("power_supply"));
				sb.append(",");
				sb.append(rs.getString("Keyboard"));
				sb.append("\n");
				
				
			}
			processResponse(response, sb.toString().getBytes());
			
		   }catch(Exception e) 
		       {
			e.printStackTrace();
		}
	}
	
	     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	          {
		       doGet(request, response);
	     }
		  String HEADER_KEY = "content-Disposition";
		  String HEADER_VALUE = "attachment; filename=\"%s\"";
		  String HEADER_FILE_NAME= "filename.csv";
		
	
	      private void processResponse(HttpServletResponse response, byte[] barr) throws IOException {
		  response.setHeader(HEADER_KEY, String.format(HEADER_VALUE, HEADER_FILE_NAME));
		  IOUtils.copy(new ByteArrayInputStream (barr),response.getOutputStream());
		
	     }

		 
	}

