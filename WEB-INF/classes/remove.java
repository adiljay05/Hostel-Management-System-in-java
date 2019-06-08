import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class remove extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
    throws IOException,ServletException
    {
        HttpSession session = req.getSession(false);
        if (session == null) {
            res.sendRedirect("/project/login.html");
        }
        
        PrintWriter out = res.getWriter();

        res.setContentType("text/html");
        out.println("<html><head><title>Remove student</title></head>");
        RequestDispatcher rd = req.getRequestDispatcher("/header");
        rd.include(req, res);
        out.println("<body><form method='post' action='removeFromDatabase'>");
        out.println("Roll Number : <input type='text' name='roll' required placeholder='student Roll Number'><br>");
        out.println("<input type='submit' value='Remove Student'> ");

        out.println("</form></body></html>");
        out.close();
    }
}
