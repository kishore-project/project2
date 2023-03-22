<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page isELIgnored="false"%>
<%@page import="utility.database"%>
<!DOCTYPE html>
<html>
<head>
<title>Plan Updation Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Credit Login / Register Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="css7/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="css7/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
<link href="css7/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- web font -->
<link href="//fonts.googleapis.com/css?family=Oswald:400,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

<!-- //web font -->
</head>
<!-- <script>
function func(){
	/* document.getElementById("fid").value = Math.floor(Math.random() * 10000)+ 123; */
	document.getElementById("keys").value = Math.random().toString(36).substring(2, 15) + Math.random().toString(36).substring(2, 15);}
	/* document.getElementById("myDiv").style.backgroundImage = "url('images/bigdata1.jpg')"; */
	</script> -->
<body>

<div class="main-agileits">
<!--form-stars-here-->
		<div class="form-w3-agile">
			<h2 style='font-family:normal;'>PLAN </h2>
			<form action="CL_chooseplan" method="post">
				
		<%
		    String name=request.getParameter("name");
            String service=request.getParameter("service");
            String mplan=request.getParameter("mplan");
            String validity=request.getParameter("validity");
			String storage=request.getParameter("storage");
			String security=request.getParameter("security");
			String service1=null,mplan1=null,validity1=null,storage1=null,security1=null;
		    Statement st = null;
	         ResultSet rs = null;
	           
	            try{
					Connection con = database.getconnection();
				    st = con.createStatement();
					String qur = "select * from cl_chooseplan";
					rs = st.executeQuery(qur);
					while(rs.next()){
						
						service1=rs.getString(2);
						mplan1=rs.getString(3);
						validity1=rs.getString(4);
						storage1=rs.getString(5);
						security1=rs.getString(6);
						%>
						<%
						}
					}catch(Exception e)
						    {
							e.printStackTrace();
						   }
						  %>
				 <div class="form-sub-w3">
					<input type="text" name="name"  placeholder="Client Name"  required="" autocomplete="off" />
				<div class="icon-w3"> 
				</div>
				</div>
				<!-- <div class="form-sub-w3">
					<input type="text" name="fkey" placeholder="Keys" id="keys" required="">
				<div class="icon-w3">
					
				</div>
				</div> -->
				<div class="form-sub-w3">
					<input type="text" name="service" value="<%=service %>" placeholder=" Service" required="" readonly />
				<div class="icon-w3">
					
				</div>
				</div>
				<div class="form-sub-w3">
					<input type="text" name="mplan" value="<%=mplan %>" placeholder="monthly plan" required="" readonly/>
				<div class="icon-w3">
					
				</div>
				</div>
				<div class="form-sub-w3">
					<input type="text" name="validity" value="<%=validity %>" placeholder="validity" required="" readonly/>
				<div class="icon-w3">
					
				</div>
				</div>
				<div class="form-sub-w3">
					<input type="text" name="storage" value="<%=storage %>" placeholder="Storage" required="" readonly/>
				<div class="icon-w3">
					
				</div>
				</div>
				<div class="form-sub-w3">
					<input type="text" name="security" value="<%=security %>" placeholder="Security" required="" readonly/>
				<div class="icon-w3">
					
				</div>
				</div>
				
				<div class="submit-w3l">
					<input type="submit" value="CHOOSE">
					<br><br><center><a href="CL_homepg.html" class="button" style='background-color:yellow;font-size:20px;font-family:normal;border:none; padding: 7px 10px;'> HOME </a></center>
				</div>
			</form>
		</div>
<!--//form-ends-here-->
</div>

<!-- copyright -->
	<div class="copyright w3-agile">
		<!-- <p> © 2017 Credit Login / Register Form . All rights reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a></p> -->
	</div>
	<!-- //copyright --> 
	<script type="text/javascript" src="js7/jquery-2.1.4.min.js"></script>
	<!-- pop-up-box -->  
		<script src="js7/jquery.magnific-popup.js" type="text/javascript"></script>
	<!--//pop-up-box -->
	<script>
		$(document).ready(function() {
		$('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
			type: 'inline',
			fixedContentPos: false,
			fixedBgPos: true,
			overflowY: 'auto',
			closeBtnInside: true,
			preloader: false,
			midClick: true,
			removalDelay: 300,
			mainClass: 'my-mfp-zoom-in'
		});
																		
		});
	</script>
</body>
</html>