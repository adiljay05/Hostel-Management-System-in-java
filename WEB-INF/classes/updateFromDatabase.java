import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class updateFromDatabase extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
                 throws IOException,ServletException
    {
    	HttpSession session = req.getSession(false);
        if (session == null) {
            res.sendRedirect("/project/login.html");
        }
	    PrintWriter out = res.getWriter();
	    String u_name=req.getParameter("studentName1");
    	String roll=req.getParameter("roll1");
    	String roomNumber=req.getParameter("roomNumber");
    	String address=req.getParameter("address");
    	String phone=req.getParameter("phone");
	    res.setContentType("text/html");
	    out.println("<html><head><title>Update Student</title></head><body>");
	    try{
	    	Class.forName("com.mysql.jdbc.Driver");

		    String url = "jdbc:mysql://127.0.0.1/hostel";

		    Connection con=DriverManager.getConnection(url,"root","");

		    Statement st=con.createStatement();

		    out.println("roll : "+roll);
		    String query="update studentinfo set roomNumber='"+roomNumber+"', address='"+address+"' ,phone='"+phone+"' where roll='"+roll+"' and studentName='"+u_name+"'";
		    RequestDispatcher rd1 = req.getRequestDispatcher("/header");
        	rd1.include(req, res);
		   
		    int rs = st.executeUpdate( query );
		    if(rs==1)
		    {	
		    	out.println("<div style='width:100%;height:15%;background-color:white;font-size:36px;' align=center>Data Updated Successfully</div>"); 		
			} 
			else
			{
				out.println("<h1>could not update the data</h1>");
			}
	    }
	    catch(Exception e)
	    {
	    	out.println(e);
	    }
	    
	    out.println("</body></html>");
	    out.close();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("/project/login.html");
        }
    }
}
