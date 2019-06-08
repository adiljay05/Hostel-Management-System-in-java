import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;


public class processServlet extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
    PrintWriter out = response.getWriter();

    String u_name=request.getParameter("name");
    
    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");


    try{
    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/store";

    Connection con=DriverManager.getConnection(url,"root","");

    Statement st=con.createStatement();
    
    String query="Select * from Items where itemname='"+u_name+"' ";
   
    ResultSet rs = st.executeQuery( query );
    String description1="discription1";
    String price1="price1";

    if(rs.next()){

        HttpSession session = request.getSession();
        String naam=rs.getString("itemname");
        String description=rs.getString("description");
        int price=rs.getInt("price");
        session.setAttribute(u_name, naam);
        session.setAttribute(description1, description);
        session.setAttribute(price1, price);
        RequestDispatcher rd = request.getRequestDispatcher("/mainServlet");
        rd.forward(request,response);

        //response.sendRedirect("mainServlet");

    }
    else{
        response.sendRedirect("errorServlet");      
    }


out.println("</body></html>");
           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}
