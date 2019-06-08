import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SearchByRoomNumber extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
    throws IOException,ServletException
    {
        HttpSession session = req.getSession(false);
        if (session == null) {
            res.sendRedirect("/project/login.html");
        }
        PrintWriter out = res.getWriter();

        res.setContentType("text/html");
        out.println("<html><head><title>Search By Room Number</title></head>");
        RequestDispatcher rd = req.getRequestDispatcher("/header");
        rd.include(req, res);
        out.println("<form method='post' action='searchedFromDatabase'>");
        out.println("Room Number : <input type='text' required name='room' placeholder='Room Number'><br>");
        out.println("<input type='submit' value='Submit'> ");

        out.println("</form></body></html>");
        out.close();
    }
}
