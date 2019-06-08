import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class header extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
                 throws IOException,ServletException
    {
        
        PrintWriter out1 = res.getWriter();

        res.setContentType("text/html");
        out1.println("<html><head><title>Home</title></head>");
        out1.println("<body>");
        out1.println("<!DOCTYPE html>"+
                    "<html>"+
                    "<head>"+
                        "<link href='styling.css' rel='stylesheet' type='text/css'>"+
                        "<link href='style.css' rel='stylesheet' type='text/css'>"+
                        "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"+
                        "<style>"+
                    "ul {"+
                        "list-style-type: none;"+
                        "margin: 0;"+
                        "padding: 0;"+
                        "overflow: hidden;"+
                        "background-color: #333;"+
                    "}"+

                    "li {"+
                        "float: left;"+
                    "}"+

                    "li a {"+
                        "display: block;"+
                        "color: white;"+
                        "text-align: center;"+
                        "padding: 14px 16px;"+
                        "text-decoration: none;"+
                    "}"+

                    "li a:hover:not(.active) {"+
                        "background-color: #111;"+
                    "}"+

                    ".active {"+
                        "background-color: #4CAF50;"+
                    "}"+
                    "#Logout1"+
                    "{"+
                        "position: absolute;"+
                        "margin-left: 93%;"+
                        "background-color: red;"+
                        "align:right;"+
                    "}"+
                    "#welcome"+
                    "{"+
                        "position: absolute;"+
                        "margin-left: 75%;"+
                      
                        "align:right;"+
                    "}"+
                    "@media print"+
                    "{    "+
                        ".no-print, .no-print *"+
                        "{"+
                            "display: none !important;"+
                        "}"+
                    "}"+
                    "</style>"+
                    "</head>"+
                    "<body>"+
                    "<ul class='no-print' style='height: 80px;padding-top: 0px;padding-left: 20px;font-size: 26px;margin-bottom: -5px;'>"+
                        "<a href='./success'><li style='color: white;'><div><img src='./logo.png' width='50px' height='60px'>  </div><div style='margin-top: -38px; margin-left: 55px;'>Hostel Managment System</div></li></a>"+
                      
                    "</ul>"+
                    "<ul class='no-print'>"+
                        "<li><a class='active' href='./success'>Home</a></li>"+
                        "<li><a href='./add'>Add Student</a></li>"+
                        "<li><a href='./remove'>Remove Student</a></li>"+
                        "<li><a href='./update'>Update Student</a></li>"+
                        "<li><a href='./viewAllStudents'>View All Students</a></li>"+
                        "<li><a href='./SearchByRoomNumber'>View Students by room Number</a></li>"+
                        "<li><a href='./printChallanOfAStudent'>Print fee challan</a></li>"+
                        "<li><a href='./printAllChallans'>Print All Challans</a></li>"+

                        "<li id='Logout1'><a href='./logout'>Logout</a></li>"+
                    "</ul>");
        //out1.close();
    }
    public void doPost(HttpServletRequest req,HttpServletResponse res)
                 throws IOException,ServletException
    {
        
        PrintWriter out1 = res.getWriter();

        res.setContentType("text/html");
        out1.println("<html><head><title>Home</title></head>");
        out1.println("<body>");
        out1.println("<!DOCTYPE html>"+
                    "<html>"+
                    "<head>"+
                        "<link href='styling.css' rel='stylesheet' type='text/css'>"+
                        "<link href='style.css' rel='stylesheet' type='text/css'>"+
                        "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"+
                        "<style>"+
                    "ul {"+
                        "list-style-type: none;"+
                        "margin: 0;"+
                        "padding: 0;"+
                        "overflow: hidden;"+
                        "background-color: #333;"+
                    "}"+

                    "li {"+
                        "float: left;"+
                    "}"+

                    "li a {"+
                        "display: block;"+
                        "color: white;"+
                        "text-align: center;"+
                        "padding: 14px 16px;"+
                        "text-decoration: none;"+
                    "}"+

                    "li a:hover:not(.active) {"+
                        "background-color: #111;"+
                    "}"+

                    ".active {"+
                        "background-color: #4CAF50;"+
                    "}"+
                    "#Logout1"+
                    "{"+
                        "position: absolute;"+
                        "margin-left: 93%;"+
                        "background-color: red;"+
                        "align:right;"+
                    "}"+
                    "#welcome"+
                    "{"+
                        "position: absolute;"+
                        "margin-left: 75%;"+
                      
                        "align:right;"+
                    "}"+
                    "@media print"+
                    "{    "+
                        ".no-print, .no-print *"+
                        "{"+
                            "display: none !important;"+
                        "}"+
                    "}"+
                    "</style>"+
                    "</head>"+
                    "<body>"+
                    "<ul class='no-print' style='height: 80px;padding-top: 0px;padding-left: 20px;font-size: 26px;margin-bottom: -5px;'>"+
                        "<a href='./success'><li style='color: white;'><div><img src='./logo.png' width='50px' height='60px'>  </div><div style='margin-top: -38px; margin-left: 55px;'>Hostel Managment System</div></li></a>"+
                      
                    "</ul>"+
                    "<ul class='no-print'>"+
                        "<li><a class='active' href='./success'>Home</a></li>"+
                        "<li><a href='./add'>Add Student</a></li>"+
                        "<li><a href='./remove'>Remove Student</a></li>"+
                        "<li><a href='./update'>Update Student</a></li>"+
                        "<li><a href='./viewAllStudents'>View All Students</a></li>"+
                        "<li><a href='./SearchByRoomNumber'>View Students by room Number</a></li>"+
                        "<li><a href='./printChallanOfAStudent'>Print fee challan</a></li>"+
                        "<li><a href='./printAllChallans'>Print All Challans</a></li>"+

                        "<li id='Logout1'><a href='./logout'>Logout</a></li>"+
                    "</ul>");
        //out1.close();
    }
}
