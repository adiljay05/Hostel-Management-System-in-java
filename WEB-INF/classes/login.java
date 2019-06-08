import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;


public class login extends HttpServlet {

  //Process the HTTP Get request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();

        String u_name=request.getParameter("name");
        String password=request.getParameter("pass");
        
        out.println("<html>");
        out.println("<head><title>Response</title></head>");
        

        try{
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1/hostel";

        Connection con=DriverManager.getConnection(url,"root","");

        Statement st=con.createStatement();

        
        String query="Select * from users where username='"+u_name+"' and password='"+password+"'";
       
        ResultSet rs = st.executeQuery( query );

        if(rs.next()){

            HttpSession session = request.getSession();
            String naam=rs.getString("username");
            session.setAttribute(u_name, naam);
            RequestDispatcher rd = request.getRequestDispatcher("/success");
            rd.forward(request,response);
            //response.sendRedirect("mainServlet");

        }
        else{
            response.sendRedirect("errorServlet");      
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
