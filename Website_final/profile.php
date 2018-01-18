<?php
?>


<html>
<title>Traffic Alert System using VANET</title>
<head><b><u><center><font size="30"> Traffic Alert System using VANET</font></center></u></b>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<br><br>
<br><br>
<div class="container">
 <center><table class="table">
    <thead>
      <tr>
	  <th><a href="aboutUS.html"><b>About Us</b></a></th>
	  <th><a href="alert.html"><b>Alerts</b></a></th>
	  <th><b>Filter</b></th>
	  <th><a href="contact.html"><b>Contact Us</b></a></th>
	  <th><a href="Page1.html"><b>Logout</b></a></th>
	  </tr>
	  </thead>
	  </table>
	  </center>
<br><br>
<div class="container">
<?php
include 'init.php'; 

//$con=mysqli_connect("mysql6.000webhost.com","a7296785_varun","Pass123","a7296785_ss1");
if (mysqli_connect_errno()) 
{
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}


$result = mysqli_query($con,"SELECT * FROM alert");
    
	if (mysqli_num_rows($result)>0)
		{
		
		?>
		
	<table border="5" cellpadding="10px" style="width:100%"><tr><th>Location</th><th>Comment</th><th>Value</th></tr>
    
    <?php
        	while($row = $result->fetch_assoc())
        		{ 
        		?>
        		 <form>
        		 
        		
        		<tr>
        		
        		
        		
        		<td><input name="Location" type="text"  readonly="true" size="20" style="font-size: 12pt" value="<?php echo $row['Location'] ?>"></td>
				
				<td><input name="Comment" type="text"  readonly="true" size="20" style="font-size: 12pt" value="<?php echo $row['Comment'] ?>"></td>
				
				<td><input name="Value" type="text"  readonly="true" size="20" style="font-size: 12pt" value="<?php echo $row['Value'] ?>"></td>
        		
				
				
  
   </form>
   
   		
        		 <?php 

				
					 }
echo"</table>";
}
else
		echo'<html> <head> <title> ADD CONTACT </title> </head> <body bgcolor="Lavender"> <br><br> <img src="line.jpg" width="100%" height="2%" /> <br><br><br> <center>  <h1> NO CONTACTS FOUND</h1> </center> </body> </html>'; ?> <br><br>
		
	


</div>



</body>
</html>