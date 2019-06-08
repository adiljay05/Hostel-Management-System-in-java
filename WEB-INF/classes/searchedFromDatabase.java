import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.sql.*;


public class searchedFromDatabase extends HttpServlet {

  //Process the HTTP Get request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("/project/login.html");
        }
        PrintWriter out = response.getWriter();

        String room1=request.getParameter("room");
        
        out.println("<html>");
        out.println("<head><title>Room "+room1+" Students</title></head>");
        out.println("<body bgcolor=\"#ffffff\">");
        RequestDispatcher rd = request.getRequestDispatcher("/header");
        rd.include(request, response);


        try{
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1/hostel";

        Connection con=DriverManager.getConnection(url,"root","");

        Statement st=con.createStatement();
        
        String query="Select * from studentinfo where roomNumber='"+room1+"'";
        out.println("<style>table {"+
              "border-collapse: collapse;"+
              "width: 100%;"+
            "}"+
            "th, td {"+
            "text-align: left;"+
            "padding: 8px;"+
            "}"+
            "tr:nth-child(even){background-color: #e0e0eb}"+
            "tr:nth-child(odd){background-color: #ffffff}"+
            "th {"+
            "  background-color: #4CAF50;"+
            "  color: white;"+
            "}</style></head>");
        out.println("<div align='center' style='font-size:36px; background-color:white;'><b>Student(s) in room "+room1+"</b></div><br><table border=1><tbody>");
        out.println("<tr><th width=150>Name</th><th width=150>Roll Number</th>"+
            "<th width=150>room Number</th><th width=200>address</th>"+
            "<th width=160>Phone</th></tr>");
        ResultSet rs = st.executeQuery( query );
        boolean check=false;
        while(rs.next()){
            String naam=rs.getString("studentName");
            String roll1=rs.getString("roll");
            String room=rs.getString("roomNumber");
            String address=rs.getString("address");
            String phone=rs.getString("phone");
            out.println("<tr><td align='center'>"+naam+"</td align='center'><td align='center'>"+roll1+"</td align='center'><td align='center'>"
                +room+"</td align='center'><td align='center'>"+address+"</td align='center'><td align='center'>"+phone+"</td align='center'></tr>");
            check=true;
        }
        if(check==false)
        {
            out.println("No Record Found");
        }
        else
        {
            out.println("</tbody></table>");
        }


    out.println("</body></html>");
               st.close();
               con.close();

        }catch(Exception e){

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
