import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;


public class mainServlet extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
    PrintWriter out = response.getWriter();

    //String u_name=request.getParameter("name");
    


    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");
    HttpSession session = request.getSession();

    try{
        out.println("<p>");
        out.println("<h3>The following data has been found in the session: </h3>");
        Enumeration attributeNames = session.getAttributeNames();
        String u_name="";
        
        while (attributeNames.hasMoreElements()) {
          String name = attributeNames.nextElement().toString();
           u_name = session.getAttribute(name).toString();
           // description1 = session.getAttribute(description1).toString();
           // price1= session.getAttribute(price1).toString();
           out.println(u_name +"<br>");
           //out.println(name);
        }



out.println("</p></body></html>");


    }catch(Exception e){
      out.println("hello");
      out.println(e);
    }

  }

  

}
