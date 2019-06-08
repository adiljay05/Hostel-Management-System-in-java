import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class success extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
                 throws IOException,ServletException
    {
        HttpSession session = req.getSession(false);
        if (session == null) {
            res.sendRedirect("/project/login.html");
        }
        PrintWriter out = res.getWriter();

        res.setContentType("text/html");
        out.println("<html><head><title>Home</title></head>");
        out.println("<body>");
        RequestDispatcher rd = req.getRequestDispatcher("/header");
        rd.include(req, res);
        out.println("<div style='width:70%;heigt:60%;background-color:white;position:fixed;'></div>");
        
        
        out.println("</body></html>");
        out.close();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("/project/login.html");
        }
        PrintWriter out = response.getWriter();

        response.setContentType("text/html");
        out.println("<html><head><title>Home</title></head>");
        out.println("<body>");
        RequestDispatcher rd = request.getRequestDispatcher("/header");
        rd.include(request, response);
        out.println("<div style='width:70%;heigt:60%;background-color:white;position:fixed;'></div>");
        
        
        out.println("</body></html>");
        out.close();
    }
}
