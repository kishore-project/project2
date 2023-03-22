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

    <title>Table </title>
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
      <center><h4 class="text-center mb-4" style='background-color:lightskyblue;width:300px'>DECRYPT DATA </h4></center>
     <center><h4><a  href="CV_homepg.html"><button type="button" class="btn btn-outline-warning">HOME</a></h4></center>
          <div class="table-wrap" style="height:400px;overflow:auto;">
        <table class="table table-striped custom-table">
       
          <thead scope="col" style='background-color:lightskyblue;colo:white;'>
            <tr>
        
         
              <th scope="col">ID</th>
              <th scope="col">Brand</th>
              <th scope="col">DisplaySize</th>
              <th scope="col">ProcessorName</th>
              <th scope="col">Hard Disk</th>
              <th scope="col">RAM Size</th>
              <th scope="col">Model Number</th>
              <th scope="col">Color</th>
              <th scope="col">Security Number</th>
              <th scope="col">RAM Type</th>
              <th scope="col">Warranty</th>
              <th scope="col">Touch Screen</th>
              <th scope="col">Graphic Processor</th>
              <th scope="col">Suitable</th>
              <th scope="col">Speaker</th>
              <th scope="col">Screen Type</th>
              <th scope="col">Power Supply</th>
              <th scope="col">Keyboard</th>
                    
               
            </tr>
          </thead>
          <%
					    ResultSet rs1=null;
						  try{
							  String qry2 = "Select * from cv_dec"; 
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
      
<!-- <br><center><th><a href="OR_encryption"> <button style='background-color:lightskyblue;width:130px;height:50px;border:2px solid black;'>ENCRYPT</button></a></th></center> -->
</div>
    <script src="js5/jquery-3.3.1.min.js"></script>
    <script src="js5/popper.min.js"></script>
    <script src="js5/bootstrap.min.js"></script>
    <script src="js5/main.js"></script>
  </body>
</html>