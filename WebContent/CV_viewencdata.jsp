<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page isELIgnored="false"%>
<%@page import="utility.database"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css5/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css5/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="css5/style.css">

    <title>Cloud Vendor view Encrypted </title>
  </head>
  <style>
body {
background-image: url("images/cs1.jpg");
background-repeat: no-repeat, repeat;
background-size: 1350px 900px;

}
 
</style>
  <body>
  

  <div class="content">
    
    <div class="container">
      <!-- <h2 class="mb-5">Table #7</h2> -->

      <div class="table-responsive">
      <center><h4 class="text-center mb-4" style='background-color:lightskyblue;width:300px'>ENCRYPTED DATA </h4></center>
     <h4><a  href="CV_viewid.jsp"><button type="button" class="btn btn-outline-warning">BACK</button></a></h4>
     
          <div class="table-wrap" style="height:400px;overflow:auto;">
        <table class="table table-striped custom-table">
       
          <thead scope="col" style='background-color:lightskyblue;colo:white;'>
            <tr>
        
         
              <th scope="col">ID</th>
              <th scope="col">BRAND</th>
              <th scope="col">DISPLAYSIZE</th>
              <th scope="col">PROCESSORNAME</th>
              <th scope="col">HARD DISK</th>
              <th scope="col">RAM SIZE</th>
              <th scope="col">MODEL NUMBER</th>
              <th scope="col">COLOR</th>
              <th scope="col">SECURITY NUMBER</th>
              <th scope="col">RAM TYPE</th>
              <th scope="col">WARRANTY</th>
              <th scope="col">TOUCH SCREEN</th>
              <th scope="col">GRAPGHIC PROCESSOR</th>
              <th scope="col">SUITABLE</th>
              <th scope="col">SPEAKER</th>
              <th scope="col">SCREEN TYPE</th>
              <th scope="col">POWER SUPPLY</th>
              <th scope="col">KEYBOARD</th>
                    
               
            </tr>
          </thead>
          <%
					    ResultSet rs1;
						  try{
							  String qry2 = "Select * from or_enc"; 
						    	 rs1 = database.getconnection().createStatement().executeQuery(qry2);
						    	while(rs1.next())
						    	{
					    %>
                     <tbody style='background-color:white;'>
                         <tr>
                              <td><%=rs1.getString(1) %></td>
						      <td><%=rs1.getString(2) %></td>
						      <td><%=rs1.getString(3) %></td>
						      <td><%=rs1.getString(4) %></td> 
						      <td><%=rs1.getString(5) %></td>
						      <td><%=rs1.getString(6) %></td>
						      <td><%=rs1.getString(7) %></td>
						      <td><%=rs1.getString(8) %></td>
						      <td><%=rs1.getString(9) %></td>
						      <td><%=rs1.getString(10) %></td>
						      <td><%=rs1.getString(11) %></td>
						      <td><%=rs1.getString(12) %></td> 
						      <td><%=rs1.getString(13) %></td>
						      <td><%=rs1.getString(14) %></td>
						      <td><%=rs1.getString(15) %></td>
						      <td><%=rs1.getString(16) %></td>
						      <td><%=rs1.getString(17) %></td>
						      <td><%=rs1.getString(18) %></td>
						                                                                
                       </tr>

					       <%}
					   		} catch (SQLException e) {
					
					e.printStackTrace();
				}	%>
            
          </tbody>
        </table>
       </div> 
      </div>
         <%
		    String sec=request.getParameter("sec");
           String sec1=null;
	       Statement st = null;
           ResultSet rs = null;
         
          try{
				Connection con = database.getconnection();
			    st = con.createStatement();
				String qur = "select * from cl_chooseplan";
				rs = st.executeQuery(qur);
				while(rs.next()){
					
					sec1=rs.getString(5);
					%>
					<%
					}
				}catch(Exception e)
					    {
						e.printStackTrace();
					   }
					  %>
      <form action="CV_decrypted" method="get"> 
       <br><label style='background-color:green;color:white';>SECURITY</label>
        <input type="text" name="sec" value=<%=sec %> placeholder="security" required="required" automcomplete="off" readonly> 
                        
      <center><button style='background-color:yellow;width:100px;height:50px;border:2px solid black;padding: 7px 10px;'>DECRYPT</button></center>
     </form>
   </div>
     
     <!-- <form action="CV_blowfish" method="get">
     <br><center><label style='color:white;'>MEDIUM SECURITY BLOWFISH</label></center>
     <center><button style='background-color:yellow;width:100px;height:50px;border:2px solid black;padding: 7px 10px;'>DECRYPT</button></center> 
     </form>
     
     <form action="CV_aes" method="get">
      <br><center><label style='color:white;'>HIGH SECURITY AES</label></center>
     <center><button style='background-color:yellow;width:100px;height:50px;border:2px solid black;padding: 7px 10px;'>DECRYPT</button></center>   
      </form> -->
 
 
 </div>
    <script src="js5/jquery-3.3.1.min.js"></script>
    <script src="js5/popper.min.js"></script>
    <script src="js5/bootstrap.min.js"></script>
    <script src="js5/main.js"></script>
  </body>
   <style>
  .button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 20px;
}
</Style>
</html>