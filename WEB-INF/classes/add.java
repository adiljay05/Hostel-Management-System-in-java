import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class add extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
    throws IOException,ServletException
    {
        PrintWriter out2 = res.getWriter();

        res.setContentType("text/html");
        out2.println("<html><head><title>Add student</title>");
        //out2.println("<link rel='stylesheet' type='text/css' href='./style.css'/></head>");
        RequestDispatcher rd1 = req.getRequestDispatcher("/header");
        rd1.include(req, res);
        //out2.println("<div class='bg'></div>");
        out2.println("<script src='js1.js'></script>");
        out2.println("<div><form method='post' action='addtoDatabase'>");
        out2.println("<label>Roll Number :</label> <input type='text' name='roll' autofocus required placeholder='student Roll Number'><br>");
        out2.println("<label>Name :</label> <input type='text' name='studentName' onkeypress='return isAlphabet(event)' required placeholder='student name'><br>");
        out2.println("<label>room number :</label><input type='text' onkeypress='return isNumber(event)' name='roomNumber' required placeholder='Room Number'><br>");
        out2.println("<label>Address :</label> <input type='text' name='address' required placeholder='Address'><br>");
        out2.println("<label>Phone :</label><input type='text' onkeypress='return isNumber(event)' name='phone' required maxlength='11' placeholder='03001234567'><br>");
        out2.println("<input type='submit' id='button1' value='Add Student'> </div>");

        out2.println("</form></body></html>");
        out2.close();
    }
}