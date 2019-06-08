import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class printAllChallans extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
    throws IOException,ServletException
    {
        res.setContentType("text/html");
        
        // get PrintWriter object
        HttpSession session = req.getSession(false);
        if (session == null) {
            res.sendRedirect("/project/login.html");
        }
        PrintWriter out = res.getWriter();
        boolean checkStudentCount=false;

        String roll1=req.getParameter("roll");
        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1/hostel";

            Connection con=DriverManager.getConnection(url,"root","");

            Statement st=con.createStatement();

            String query="select * from studentinfo";
            ResultSet rs = st.executeQuery( query );
            out.println("<html><head><title>Challan Form</title></head>");
            RequestDispatcher rd = req.getRequestDispatcher("/header");
            rd.include(req, res);
            out.println("<div style='margin-left:400px; margin-top:10px; width:200px;'><input type='submit' class='no-print' onclick='javascript:window.print()' value='Print'></div>");
            while(rs.next()){
                String rollNumber=rs.getString("roll");
                String nameOfStudent=rs.getString("studentName");
                out.println("<body style='width:1600px; background: white;'>"+
                    "<table style='border-width:0px; margin-left:10px; margin-top:10px; border-spacing: 8px;'>"+
                    "<tr>"+
                        "<td>"+
                "<table style='border-width:3px; border-style:solid; border-spacing: 0px; border-color: black'>"+
                    "<tr align=center>"+
                        "<td colspan=2>"+
                            "<font size=2><b>Punjab University college of information and technology</b>"+
                            "<br><br>"+
                            "<font size=3>Depositor's copy"+
                            "<br>"+
                            "Habib Bank Limited 1"+
                            "<br>"+
                            "Old Campus Branch Lahore"+
                            "<br>"+
                            "Tuition Fee Charges Regular Clases"+
                            "<br><br>"+
                            "</font>"+
                            "<font size=2>"+
                            "<br>"+
                            "<b>Credit: Punjab University College Old Campus A/C#1116-11</b></font>"+
                            "<br>"+
                            "<font size=3> <p align='left'><b>Name:</b> "+nameOfStudent+"</p>"+
                            "<p align='left'>"+
                            "<span>Deptt.: PUCIT</span>"+
                            "<span style='margin-left:170px'>Semester: 2nd</span></p>"+
                            "<p align='left'><span>Class: __________ </span>"+
                            "<span style='margin-left:85px'>Roll no.: "+rollNumber+"</span></p></font></tr>"+
                            "<tr><td colspan=2 align=center>Emp Son/Dau</td></tr>"+
                        "</td>"+
                        "<tr height=20px>"+
                            "<td style='border-width:1px; border-style:solid;' width=50px>"+
                                "Admission Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "300.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Tuition Fee "+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Breakage Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "2500.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Buss Pass charges"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "1650.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Computer Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "2500.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Library Security"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Library Service"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "300.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Mosque Fund"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "P.U Developement Fund"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "P.U Medical Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "P.U.S.T.C/P.U.W.S.T.C"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                             "Sports Development & Swimming Pool Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Sports Fund(PUTDSA)"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Student General Fund"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Electricity Charges"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "750.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "PU Internet Facility"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "&nbsp;"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Total Rs."+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "8000.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td colspan=2>"+
                            "<br><b>Rs. in words: Eight thousand only</b><br><br>"+
                            "<p>S.No_______ &nbsp;&nbsp;&nbsp;&nbsp;Officer&nbsp;&nbsp;&nbsp;&nbsp; CASHIER</p>"+
                            "</td>"+
                        "</tr>"+
                    "</tr>"+
                "</table>"+
        "</td>"+
        "<td>"+
            "<table style='border-width:3px; margin-left:10px; border-style:solid; border-spacing: 0px; border-color: black'>"+
                    "<tr align=center>"+
                        "<td colspan=2>"+
                            "<font size=2><b>Punjab University college of information and technology</b>"+
                            "<br><br>"+
                            "<font size=3>Department's copy"+
                            "<br>"+
                            "Habib Bank Limited 1"+
                            "<br>"+
                            "Old Campus Branch Lahore"+
                            "<br>"+
                            "Tuition Fee Charges Regular Clases"+
                            "<br><br>"+
                            "</font>"+
                            "<font size=2>"+
                            "<br>"+
                            "<b>Credit: Punjab University College Old Campus A/C#1116-11</b></font>"+
                            "<br>"+
                            "<font size=3> <p align='left'><b>Name:</b> "+nameOfStudent+"</p>"+
                           "<p align='left'>"+
                            "<span>Deptt.: PUCIT</span>"+
                            "<span style='margin-left:170px'>Semester: 2nd</span></p>"+
                            "<p align='left'><span>Class: __________ </span>"+
                            "<span style='margin-left:85px'>Roll no.: "+rollNumber+"</span></p></font></tr>"+
                            "<tr><td colspan=2 align=center>Emp Son/Dau</td></tr>"+
                        "</td>"+
                        "<tr height=20px>"+
                            "<td style='border-width:1px; border-style:solid;' width=50px>"+
                                "Admission Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "300.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Tuition Fee "+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Breakage Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "2500.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Buss Pass charges"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "1650.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Computer Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "2500.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Library Security"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Library Service"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "300.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Mosque Fund"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "P.U Developement Fund"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "P.U Medical Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "P.U.S.T.C/P.U.W.S.T.C"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                             "Sports Development & Swimming Pool Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Sports Fund(PUTDSA)"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Student General Fund"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Electricity Charges"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "750.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "PU Internet Facility"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "&nbsp;"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Total Rs."+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "8000.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td colspan=2>"+
                            "<br><b>Rs. in words: Eight thousand only</b><br><br>"+
                            "<p>S.No_______ &nbsp;&nbsp;&nbsp;&nbsp;Officer&nbsp;&nbsp;&nbsp;&nbsp; CASHIER</p>"+
                            "</td>"+
                        "</tr>"+
                    "</tr>"+
                "</table>"+
        "</td>"+
        "<td>"+
            "<table style='border-width:3px; margin-left:10px; border-style:solid; border-spacing: 0px; border-color: black'>"+
                    "<tr align=center>"+
                        "<td colspan=2>"+
                            "<font size=2><b>Punjab University college of information and technology</b>"+
                            "<br><br>"+
                            "<font size=3>Bank's copy"+
                            "<br>"+
                            "Habib Bank Limited 1"+
                            "<br>"+
                            "Old Campus Branch Lahore"+
                            "<br>"+
                            "Tuition Fee Charges Regular Clases"+
                            "<br><br>"+
                            "</font>"+
                            "<font size=2>"+
                            "<br>"+
                            "<b>Credit: Punjab University College Old Campus A/C#1116-11</b></font>"+
                            "<br>"+
                            "<font size=3> <p align='left'><b>Name:</b> "+nameOfStudent+"</p>"+
                            "<p align='left'>"+
                            "<span>Deptt.: PUCIT</span>"+
                            "<span style='margin-left:170px'>Semester: 2nd</span></p>"+
                            "<p align='left'><span>Class: __________ </span>"+
                            "<span style='margin-left:85px'>Roll no.: "+rollNumber+"</span></p></font></tr>"+
                            "<tr><td colspan=2 align=center>Emp Son/Dau</td></tr>"+
                        "</td>"+
                        "<tr height=20px>"+
                            "<td style='border-width:1px; border-style:solid;' width=50px>"+
                                "Admission Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "300.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Tuition Fee "+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Breakage Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "2500.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Buss Pass charges"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "1650.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Computer Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "2500.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Library Security"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Library Service"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "300.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Mosque Fund"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "P.U Developement Fund"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "P.U Medical Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "P.U.S.T.C/P.U.W.S.T.C"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                             "Sports Development & Swimming Pool Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Sports Fund(PUTDSA)"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Student General Fund"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Electricity Charges"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "750.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "PU Internet Facility"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "&nbsp;"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Total Rs."+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "8000.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td colspan=2>"+
                            "<br><b>Rs. in words: Eight thousand only</b><br><br>"+
                            "<p>S.No_______ &nbsp;&nbsp;&nbsp;&nbsp;Officer&nbsp;&nbsp;&nbsp;&nbsp; CASHIER</p>"+
                            "</td>"+
                        "</tr>"+
                    "</tr>"+
                "</table>"+
        "</td>"+
        "<td>"+
            "<table style='border-width:3px; margin-left:10px; border-style:solid; border-spacing: 0px; border-color: black'>"+
                    "<tr align=center>"+
                        "<td colspan=2>"+
                            "<font size=2><b>Punjab University college of information and technology</b>"+
                            "<br><br>"+
                            "<font size=3>Branch's copy"+
                            "<br>"+
                            "Habib Bank Limited 1"+
                            "<br>"+
                            "Old Campus Branch Lahore"+
                            "<br>"+
                            "Tuition Fee Charges Regular Clases"+
                            "<br><br>"+
                            "</font>"+
                            "<font size=2>"+
                            "<br>"+
                            "<b>Credit: Punjab University College Old Campus A/C#1116-11</b></font>"+
                            "<br>"+
                            "<font size=3> <p align='left'><b>Name:</b> "+nameOfStudent+"</p>"+
                            "<p align='left'>"+
                            "<span>Deptt.: PUCIT</span>"+
                            "<span style='margin-left:170px'>Semester: 2nd</span></p>"+
                            "<p align='left'><span>Class: __________ </span>"+
                            "<span style='margin-left:85px'>Roll no.: "+rollNumber+"</span></p></font></tr>"+
                            "<tr><td colspan=2 align=center>Emp Son/Dau</td></tr>"+
                        "</td>"+
                        "<tr height=20px>"+
                            "<td style='border-width:1px; border-style:solid;' width=50px>"+
                                "Admission Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "300.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Tuition Fee "+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Breakage Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "2500.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Buss Pass charges"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "1650.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Computer Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "2500.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Library Security"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Library Service"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "300.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Mosque Fund"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "P.U Developement Fund"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "P.U Medical Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "P.U.S.T.C/P.U.W.S.T.C"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                             "Sports Development & Swimming Pool Fee"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Sports Fund(PUTDSA)"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Student General Fund"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Electricity Charges"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "750.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "PU Internet Facility"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "&nbsp;"+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td style='border-width:1px; border-style:solid;'>"+
                                "Total Rs."+
                            "</td>"+
                            "<td style='border-width:1px; border-style:solid; ' align=center>"+
                            "8000.00"+
                            "</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td colspan=2>"+
                            "<br><b>Rs. in words: Eight thousand only</b><br><br>"+
                            "<p>S.No_______ &nbsp;&nbsp;&nbsp;&nbsp;Officer&nbsp;&nbsp;&nbsp;&nbsp; CASHIER</p>"+
                            "</td>"+
                        "</tr>"+
                    "</tr>"+
                "</table>"+
            "</td>"+
        "</tr>"+
        "</table><br><br><br><br><br><br><br><br>");
            checkStudentCount=true;
            }
        }
        catch(Exception e)
        {
            out.println(e);
        }
        if(checkStudentCount=false)
        {
            out.println("no record found");
        }
        out.println("</body></html>");
        out.close();
    }
}
