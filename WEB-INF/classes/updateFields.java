import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class updateFields extends HttpServlet {
  
  //Process the HTTP Get request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    	response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("/project/login.html");
        }
        
    	// get PrintWriter object
    	PrintWriter out = response.getWriter();

        String roll=request.getParameter("roll");

        out.println("<html>");
        out.println("<head><title>Update Student</title></head>");
        out.println("<body bgcolor=\"#ffffff\">");
        RequestDispatcher rd = request.getRequestDispatcher("/header");
        rd.include(request, response);


        try{

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1/hostel";

        Connection con=DriverManager.getConnection(url, "root", "");

        Statement st=con.createStatement();

         
        String query = "select *from studentinfo where roll='"+roll+"'";
        ResultSet rs = st.executeQuery( query );

        if(rs.next())
        {
            String naam=rs.getString("studentName");
            String roll1=rs.getString("roll");
            String room=rs.getString("roomNumber");
            String address=rs.getString("address");
            String phone=rs.getString("phone");
            out.println("<script src='js1.js'></script>");
        	out.println("<form method='post' action='updateFromDatabase'>");
            out.println("Roll Number : <input type='text' name='roll' disabled value='"+roll1+"'><br>");
            out.println("Name : <input type='text' name='studentName' disabled value='"+naam+"'><br>");
            out.println("room number : <input type='text' onkeypress='return isNumber(event)' required name='roomNumber' value='"+room+"'><br>");
            out.println("Address : <input type='text' required name='address' value='"+address+"'><br>");
            out.println("Phone : <input type='text' onkeypress='return isNumber(event)'  maxlength='11' required name='phone' value='"+phone+"'><br>");
            out.println("<input type='hidden' name='roll1' value='"+roll1+"'>");
            out.println("<input type='hidden' name='studentName1' value='"+naam+"'>");
            out.println("<input type='submit' value='update Student'> </form>");
        }
    	else
        {
        	out.println("<h1>Record not found.</h1>"); 		
        }

            out.println("</body></html>");

            st.close();
            con.close();

        }
        catch(Exception e){

          out.println(e);
        }

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("/project/login.html");
        }
    }

}
