////////////////////////////////////////////////////////////
//
//    URL Rewriting
//
////////////////////////////////////////////////////////////

// this web application must be deployed on a virtual host called
// www.tardis.com

package demos.jee.servlets;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class URL_Rewriting extends javax.servlet.http.HttpServlet {
  public void service(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, java.io.IOException {

    String red = "#ff0000";
    String khaki = "#ccbb22";
    String url = "rewrite";
    HttpSession session = req.getSession(true);

    ServletOutputStream  out = res.getOutputStream();
    res.setContentType("text/html");
    out.println("<HTML><BODY TEXT=\"" + red + "\" BGCOLOR=\"" + khaki + "\"><H1>");

    if (session.isNew()) {
      out.println("New Session");
    } else {
      out.println("Existing Session");
    }
    out.println("</H1><H3><HR>Session ID: " + session.getId() + "<BR>");

  // Hyperlink to continue session
    out.print("<A HREF=");
    out.print(res.encodeURL(url));
    out.println("><P>Continue session</A>");

  // Hyperlink to start new session
    out.print("<A HREF=");
    out.print(url);
    out.println("><P>Start new session</A>");

    out.println("</H3></BODY></HTML>");
    out.close();

  }
}





