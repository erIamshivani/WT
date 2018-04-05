import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class  ServletJDBC extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("Initialize Connections");
		String username1=request.getParameter("uname");
			String passwprd1=request.getParameter("pass");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stud","root","trupti");
			Statement stmt =  conn.createStatement();
			pw.println("Connection established successfully..!!");
			ResultSet rs = stmt.executeQuery("Select * from practical");
			
			pw.println(username1);
			while(rs.next())
			{
				pw.println(rs.getString(1));
				if(username1.equals(rs.getString(1)));
				
				pw.println("successfull");
			/*	else
					pw.println("not registered");*/
			
				
			
			}
			
		}
		catch (Exception e)
		{
			pw.println("The error is:" +e.getMessage());
		}
	}
}
