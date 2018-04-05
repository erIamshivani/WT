<?xml version="1.0" encoding="UTF-8"?>
<html xsl:version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<head>
<title>Event Information</title>

<style>
li {
    float: right;
	
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #6bd4f4;
}


ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: black;
    position: fixed;
   
    width: 100%;

}

html, body {
           
            
        
            width: 100%;
            height: 100%;
            max-height: 100%;
           
            background-image: url('best.jpg');
            background-size:100% 100%;
           
        }
		
		tr{
		
		font-size:25px;
		}
		
</style>


</head>

<body style="font-family:Arial;font-size:25px;background-color:#EEEEEE">
<nav>
	<ul>
		
		<li><a href="register.html">Register</a></li>
		<li><a href="event_contact.html">Contact </a></li>
		<li><a href="event_1.html">Home</a></li>
		
		<li><a href="event_3.html">About us </a></li>

</ul>
</nav><br></br><br></br><br></br>



<center>
<h1  style="color:turquoise;font-size:50px;">Event Details</h1><br></br>
<table border="1">
<br></br>

    <tr bgcolor="#9acd32">
      <th style="text-align:left">Day</th>
      <th style="text-align:left">Event</th>
     <th style="text-align:left">Price</th> 
	 <th style="text-align:left">Time</th> 
	 <th style="text-align:left">Rules</th> 
	 <th style="text-align:left">Coordinator</th> 
    </tr>
    <xsl:for-each select="event_menu/event">
    <tr style="background-color:black;color:white">
       <td style="color:orange"><xsl:value-of select="day"/></td>
      <td ><xsl:value-of select="name"/></td>
      <td><xsl:value-of select="price"/></td>
	  <td><xsl:value-of select="time"/></td>
	  <td><xsl:value-of select="rules"/></td>
	  <td style="color:yellow"><xsl:value-of select="Coordinator"/></td>
    </tr>
    </xsl:for-each>
  </table>

</center>

</body>
</html>
