
import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class serv extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
PrintWriter pw=response.getWriter();
	    pw.println("<html><body>");
	    pw.println("Welcome to servlet");
	            
String uname=request.getParameter("uname"); 
pw.println(uname);
String pass=request.getParameter("pass");  
pw.println(pass);

          
try{ 
pw.println("connection established successfully"); 
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/stud","root","trupti");  
  pw.println("connection established successfully");
  
  String sql="select * from practical where username=?";
  PreparedStatement ps=con.prepareStatement(sql);
  ps.setString(1,uname);
  ResultSet rs=ps.executeQuery();
  if(rs.next()){
	  
	  out.println("Already registered!!!!!");
	  
  }
  else{
  
  
 ps=con.prepareStatement( "insert into practical values(?,?)");  
  
ps.setString(1,uname);  
ps.setString(2,pass);  

          
int i=ps.executeUpdate();
if(i>0)  
out.print("You are successfully registered...");  
  }
	
  pw.println("</html></body>");
	    pw.close();      
          
}catch (Exception e2) 
{System.out.println(e2);}  
          
out.close(); 
}  
  
}  