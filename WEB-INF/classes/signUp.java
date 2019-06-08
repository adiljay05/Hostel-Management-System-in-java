import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;


public class signUp extends HttpServlet {

  //Process the HTTP Get request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();

        String u_name=request.getParameter("name");
        String password=request.getParameter("pass");
        
        out.println("<html>");
        out.println("<head><title>Response</title></head>");
        out.println("<body bgcolor=\"#ffffff\">");


        try{
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1/hostel";

        Connection con=DriverManager.getConnection(url,"root","");

        Statement st=con.createStatement();

        
        String query="insert into users (username,password) values ('"+u_name+"','"+password+"')";
       
        int rs = st.executeUpdate( query );

        if(rs==1){

            out.println("sign up successfull");
            Thread.sleep(5);
            response.sendRedirect("/project/login.html");

        }
        else{
            out.println("could not complete sign up");
        }


        out.println("</body></html>");
        st.close();
        con.close();

        }
        catch(Exception e)
        {
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
