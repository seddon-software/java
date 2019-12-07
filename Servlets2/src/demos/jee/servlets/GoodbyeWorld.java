////////////////////////////////////////////////////////////
//
//    GoodbyeWorld
//
////////////////////////////////////////////////////////////

package demos.jee.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class GoodbyeWorld extends HttpServlet {

  public void service(HttpServletRequest req, HttpServletResponse res)
                         throws ServletException, IOException {
    System.out.println("GoodbyeWorld");
    String bgColor = "#0055FF";
    String fgColor = "#AAAA00";
    PrintWriter out;

    // must set the content type first
    res.setContentType("text/html");

    // obtain a PrintWriter to insert HTML into
    out = res.getWriter();

    out.println("<HTML><HEAD><TITLE>This Is A Simple Servlet</TITLE></HEAD>");
    out.println("<BODY BGCOLOR=\"" + bgColor + "\"");
    out.println("<CENTER> <H1>");
    out.println("<FONT FACE=\"ARIAL\" SIZE=8 COLOR=\"");
    out.println(fgColor + "\">");

    out.println("Goodbye World<HR>");

    out.println("</FONT>");
    out.println("</H1> </CENTER>");
    out.println("</BODY></HTML>");

    out.close();
  }
}

