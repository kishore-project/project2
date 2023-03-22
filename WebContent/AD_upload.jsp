<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page isELIgnored="false"%>
<%@page import="utility.database"%>
<%@page import="owner.SHA256"%>
<%@ page import="java.util.Random" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>key</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Event Registration Form Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<!-- //custom-theme -->
<link href="css13/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript" src="js13/jquery-2.1.4.min.js"></script>
<!-- //js -->
<!-- font-awesome-icons -->
<!-- //font-awesome-icons -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
</head>
<script>
function func(){
	document.getElementById("fid").value = Math.floor(Math.random() * 10000)+ 123;
	document.getElementById("keys").value = Math.random().toString(36).substring(2, 15) + Math.random().toString(36).substring(2, 15);}
	/* document.getElementById("myDiv").style.backgroundImage = "url('images/bigdata1.jpg')"; */
	</script>
<body onload="func()">
<!-- banner -->
	<div class="center-container">
		<div class="main">
			<h1 class="w3layouts_head">Upload Data</h1>
				<div class="w3layouts_main_grid">
					<form action="AD_data" method="post" class="w3_form_post" enctype='multipart/form-data'>
						
						<%
		                 String name=request.getParameter("name");
						String name1=null;
					    Statement st = null;
				         ResultSet rs = null;
				           
				            try{
				            	Connection con = database.getconnection();
							    st = con.createStatement();
								String qur = "select * from cl_file";
								rs = st.executeQuery(qur);
								while(rs.next()){
									
									name1=rs.getString(4);
									
									%>
									<%
									}
								}catch(Exception e)
									    {
										e.printStackTrace();
									   }
									  %>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label style='background-color:green;width:150px;height:35px;font-size:25px;'>File ID </label>
								<br><input type="text" name="fileid" id="fid" placeholder="Your Name" required="" readonly>
							</span>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label style='background-color:green;width:150px;height:35px;font-size:25px;'>File Name </label>
								<br><input type="text" name="name" placeholder="File name" value=<%=name %> required="" autocomplete="off" readonly>
							</span>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label style='background-color:green;width:150px;height:35px;font-size:25px;'>File Key </label>
								<br><input type="text" name="fkey" placeholder="Keys" id="keys" required="" readonly>
								</span>
						</div>
						
						<br><label style='color:white;background-color:green;width:150px;height:40px;font-size:25px;'>UPLOAD FILE </label>
						<td><center><input type="file" id="fileselect" name="file" multiple="multiple" required=""/></center></td>
						<div class="w3_main_grid_right">
							<br><center><input type="submit" value="UPLOAD"></center>
							<br><a href="AD_viewdetails.jsp" style='background-color:yellow;font-size:20px;font-famil:normal;color:black;width:80px;padding: 7px 10px;'>BACK</a>
						</div>
						
						</div>
						<div class="clear"></div>
					</div>
					
				</form>
			</div>
		<!-- Calendar -->
			<link rel="stylesheet" href="css13/jquery-ui.css" />
				<script src="js13/jquery-ui.js"></script>
					<script>
						$(function() {
							$( "#datepicker" ).datepicker();
						});
					</script>
		<!-- //Calendar -->
			<div class="w3layouts_copy_right">
				<div class="container">
				
				</div>
			</div>
		</div>
	</div>
<!-- //footer -->
</body>
</html>