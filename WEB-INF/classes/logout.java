import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class logout extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
                 throws IOException,ServletException
    {
        PrintWriter out = res.getWriter();

        res.setContentType("text/html");
        out.println("<html><head><title>Home</title></head>");
        out.println("<body>");
        HttpSession session = req.getSession();
        session.invalidate();
        res.sendRedirect("/project/login.html");
        out.println("logged out");
        out.println("</body></html>");
        out.close();
    }
}
