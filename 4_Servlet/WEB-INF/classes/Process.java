// a pure processing servlet i.e. it doesn't produce any o/p
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Process extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		// connect to a DB
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/stud","root","trupti");
			String sql = "select * from practical where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,req.getParameter("uname"));
			ps.setString(2,req.getParameter("pass"));
			ResultSet rs = ps.executeQuery();
			PrintWriter out = res.getWriter();
			if (rs.next())
			{
				// valid user
				// create a session for user
				//HttpSession s = req.getSession(true);
				//s.setAttribute("un",rs.getString(1));
				//s.setAttribute("bal",rs.getDouble(3));
				//res.sendRedirect("Wel");					// Wel is url pattern for
				// loading welcome servlet
				out.print("Login successfull!!!!");  
			}
			else{
				
				out.print("Login unsucessfull!!!!");  
			}

			rs.close();
			ps.close();
			conn.close();
		} // end of try
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}










