////////////////////////////////////////////////////////////
//
//    HelloWorld
//
////////////////////////////////////////////////////////////

package demos.jee.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HelloWorld extends HttpServlet {

  public void service(HttpServletRequest req,
                     HttpServletResponse res) throws IOException {

    System.out.println("HelloWorld");
    String bgColor = "#AAAA00";
    PrintWriter out;

    // must set the content type first
    res.setContentType("text/html");

    // obtain a PrintWriter to insert HTML into
    out = res.getWriter();

    out.println("<HTML><HEAD><TITLE>This Is A Hello World Servlet</TITLE></HEAD>");
    out.println("<BODY BGCOLOR=\"" + bgColor + "\">");
    out.println("<H1>Hello World</H1>");
    out.println("</BODY></HTML>");

    out.close();
  }
}
