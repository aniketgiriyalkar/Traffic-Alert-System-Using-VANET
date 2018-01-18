<?php
$host = "mysql7.000webhost.com";
$user = "a2740283_contact";
$password = "naved12";
$db = "a2740283_login";

$con = mysqli_connect($host, $user, $password, $db);

if(!$con)
{
  die("ERROR" . mysqli_connect_error());
}


?>