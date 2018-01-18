<?php
include 'init.php'; 

  $Location=($_POST['Location']);

  $Comment=($_POST['Comment']);
  
  $Value=($_POST['Value']);
 
 
  $qry="INSERT INTO alert (`Location`,`Comment`,`Value`) VALUES('$Location','$Comment','$Value')";

  $res=mysqli_query($con,$qry);
  
  if(!$res){
  echo " <center> <h1> Something went wrong </h1> </center>";
}
else {
  echo "Incident is successfully added to database";
}

  ?>

  <center> <input type="button" onclick="parent.location='profile.php'" value=" VIEW POST " />  </center>

   <?php
?>
 

  