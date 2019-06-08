import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class errorServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
                 throws IOException,ServletException
    {
    	HttpSession session = req.getSession(false);
        if (session == null) {
            res.sendRedirect("/project/login.html");
        }
		PrintWriter out = res.getWriter();

		res.setContentType("text/html");
		out.println("<html><head><title>New Servlet</title></head>");
		out.println("<body>No record found.</body></html>");
		out.close();
    }
}
