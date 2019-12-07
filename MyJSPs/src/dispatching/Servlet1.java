package dispatching;
////////////////////////////////////////////////////////////
//
//    Servlet1
//
////////////////////////////////////////////////////////////


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Servlet1 extends HttpServlet {

  public void service(HttpServletRequest req,
                     HttpServletResponse res) throws IOException {

    PrintWriter out = res.getWriter();

    ServletContext ctx;
    RequestDispatcher rd;
    try {
      // call a JSP
      out.println("<h3> This is Servlet1</h3>");
      out.println("... attempting to call JSP1 ...");
      ctx = getServletContext();
      rd = ctx.getRequestDispatcher("/dispatching/JSPs/page1");
      rd.include(req, res);

      // call a Servlet
      out.println("<h3> This is Servlet1</h3>");
      out.println("... attempting to call Servlet2 ...");
      rd = ctx.getRequestDispatcher("/dispatching/servlets/page2");
      rd.include(req, res);
    } catch(ServletException e) {
      e.printStackTrace();
    }
  }
}
