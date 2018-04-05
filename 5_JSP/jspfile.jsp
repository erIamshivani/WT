<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"> 

<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 

<html> 
<head> 
<title>Connection with mysql database</title> 
</head> 
<body>
<h1>Connection status </h1>





<% 
	            
String uname=request.getParameter("uname"); 
//out.println(uname);
String pass=request.getParameter("pass");  
//out.println(pass);

	            


try {
/* Create string of connection url within specified format with machine name, 
port number and database name. Here machine name id localhost and 
database name is usermaster. */ 
String connectionURL = "jdbc:mysql://localhost:3306/stud"; 

// declare a connection by using Connection interface 
Connection connection = null; 

// Load JDBC driver "com.mysql.jdbc.Driver" 
Class.forName("com.mysql.jdbc.Driver").newInstance(); 

/* Create a connection by using getConnection() method that takes parameters of 
string type connection url, user name and password to connect to database. */ 
connection = DriverManager.getConnection(connectionURL, "root", "trupti");

// check weather connection is established or not by isClosed() method 
if(!connection.isClosed())
%>
<font size="+3" color="blue"></b>
<% 
out.println("Successfully connected to " + "MySQL server!");



String sql="select * from practical where username=?";
  PreparedStatement ps=connection.prepareStatement(sql);
  ps.setString(1,uname);
  ResultSet rs=ps.executeQuery();
  if(rs.next()){
	  
	  out.println("Already registered!!!!!");
	  
  }
  else{
  
  
 ps=connection.prepareStatement( "insert into practical values(?,?)");  
  
ps.setString(1,uname);  
ps.setString(2,pass);  

          
int i=ps.executeUpdate();
if(i>0)  
out.print("You are successfully registered...");  
  }
	
 out.println("</html></body>");
	    out.close();   
}
catch(Exception ex){
%>
</font>
<font size="+3" color="red"></b>
<%
//out.println("Unable to connect to database.");
}
%>
</font>
</body> 
</html>