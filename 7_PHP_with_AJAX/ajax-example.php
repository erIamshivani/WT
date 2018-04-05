<?php
   error_reporting(E_ALL ^ E_DEPRECATED);//to hide the unwanted warnings
   $dbhost = "localhost";
   $dbuser = "root";
   $dbpass = "trupti";
   $dbname = "Person";
   
   //Connect to MySQL Server
   mysql_connect($dbhost, $dbuser, $dbpass);
   
   //Select Database
   mysql_select_db($dbname) or die(mysql_error());
   
   // Retrieve data from Query String
   $username = $_GET['username'];
  // $name = $_GET['name'];
 $password = $_GET['password'];
   
   // Escape User Input to help prevent SQL Injection
   $username = mysql_real_escape_string($username);
  // $name = mysql_real_escape_string($name);
   $password = mysql_real_escape_string($password);
   
   //build query
   $query = "SELECT * FROM users WHERE username = '$username'and password= '$password'";
   
   
   //Execute query
  $qry_result = mysql_query($query) or die(mysql_error());
  $rowss = mysql_num_rows($qry_result);//to count the number of rows returned by the query
   
   if($rowss<=0)
   {
	   echo "Incorrect Username or Password";
   }
   else{
	   
    echo "Successfully Logged in!!!!";
	
	echo  nl2br (" \n ");
	echo  nl2br (" \n ");
	
   //Build Result String
   $display_string = "<table>";
   $display_string .= "<tr>";
   $display_string .= "<th>RollNo.</th>";
   $display_string .= "<th>Username</th>";
   $display_string .= "<th>Name</th>";
   $display_string .= "<th>Password</th>";
   $display_string .= "</tr>";
   
   // Insert a new row in the table for each person returned
   while($row = mysql_fetch_array($qry_result))
	{
      $display_string .= "<tr>";
	  $display_string .= "<td>$row[id]</td>";
      $display_string .= "<td>$row[username]</td>";
      $display_string .= "<td>$row[name]</td>";
      $display_string .= "<td>$row[password]</td>";
     // $display_string .= "<td>$row[wpm]</td>";
      $display_string .= "</tr>";
	}
   //echo "Query: " . $query . "<br />";
   
   $display_string .= "</table>";
   echo $display_string;
   }
   
   
?>