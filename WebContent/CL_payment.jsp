<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page isELIgnored="false"%>
<%@page import="utility.database"%>
<!DOCTYPE html>
<html>
<head>
<title> Payment</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Grocery Payment Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<!-- js -->
<script type="text/javascript" src="js8/creditly.js"></script>
<script src="js8/jquery.min.js"></script>
<script type="text/javascript">
    $(function() {
      var creditly = Creditly.initialize(
          '.creditly-wrapper .expiration-month-and-year',
          '.creditly-wrapper .credit-card-number',
          '.creditly-wrapper .security-code',
          '.creditly-wrapper .card-type');

      $(".creditly-card-form .submit").click(function(e) {
        e.preventDefault();
        var output = creditly.validate();
        if (output) {
          // Your validated credit card output
          console.log(output);
        }
      });
    });
</script>
<!-- //js -->
<link href="css8/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css8/creditly.css" type="text/css" media="all" />
<link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
</head>
<body>
	<div class="main">
		<center><h1 style='background-color:blue;width:250px;'> PAYMENT </h1></center>
		<div class="agileits_main_grid w3layouts_main w3_main_grid">
			<div class="agileits_main_grid_right agileits_w3layouts_grid_right">
				<!-- <h2>Spices</h2>
				<p>$99/-</p> -->
			</div>
			<div class="agileits_main_grid_left w3l_main w3ls_main_grid_left">
				<div class="agileits_main_grid_left1 agileits_main_grid_left1">
					<form action="CL_payment" method="post" class="creditly-card-form agileinfo_form">
					
						
					<%
					
					String name=request.getParameter("name");
					String plan=request.getParameter("plan");					
					String name1=null,plan1=null;
					Statement st1 = null;
					ResultSet rs=null;
					try{
						Connection con = database.getconnection();
						st1 = con.createStatement();
						String qur = "select * from cl_chooseplan";
						rs = st1.executeQuery(qur);
				        
						while(rs.next()){							
							name1=rs.getString(1);
							plan=rs.getString(3);
							
					%>
					<%
					}
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					%>	
					
						<section class="creditly-wrapper wthree, w3_agileits_wrapper">
							<div class="credit-card-wrapper">
								<div class="first-row form-group">
								<div class="controls">
										<label class="control-label">Client Name</label>
										<br><input type="text" name="name"  value="<%=name %>" required="" style='width:500px;height:40px;' autocomplete="off" readonly>
									</div>
									<div class="controls">
										<label class="control-label">Plan</label>
										<br><input type="text" name="plan" required=""  value="<%=plan %>" style='width:500px;height:40px;' autocomplete="off" readonly>
									</div>
									<div class="controls">
										<label class="control-label">Card Number</label>
                                  <input  type="text" name="cnumber" minlength="16" maxlength="16" required="" style='width:500px;height:40px;'>
									</div>
									<div class="controls">
										<label class="control-label">CVV</label>
										<input class="security-code form-control"Â·
													  inputmode="numeric"
													  type="text" name="security-code"
													  placeholder="&#149;&#149;&#149;" required="required">
									</div>
								</div>
								<div class="second-row form-group">
									<div class="controls">
										<label class="control-label">Name on Card</label>
										<input class="billing-address-name form-control" type="text" name="cdname" placeholder="Name" autocomplete="off" required="">
									</div>
									<div class="controls">
										<label class="control-label">Expiration</label>
										<input class="expiration-month-and-year form-control" type="text" name="expiration-month-and-year" placeholder="MM / YY" required="">
									</div>
								</div>
								<center><input type="submit" value="PAY NOW" name="paid" class="button" style='background-color:goldenrod;width:90px;height:50px;font-size:15px;'></center><br>
								<br><a href="CL_planstatus.jsp"  style='background-color:yellow;font-size:20px;font-family:normal;border:2px solid black;color:black;padding: 7px 12px;'> BACK </a>
							</div>
						</section>
						
					</form>
				</div>
			</div>
			<div class="clear"> </div>
		</div>
		<div class="agileits_copyright agile_copy">
			<!-- <p class="w3_agile_right">© 2016 Grocery Payment Widget. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p> -->
		</div>
	</div>
</body>
</html>