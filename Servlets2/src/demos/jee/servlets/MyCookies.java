////////////////////////////////////////////////////////////
//
//    Cookies
//
////////////////////////////////////////////////////////////

package demos.jee.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class MyCookies extends javax.servlet.http.HttpServlet {

  public void service(HttpServletRequest req, HttpServletResponse res)
                         throws ServletException, IOException {
    ServletOutputStream out = res.getOutputStream();
    res.setContentType("text/html");
    out.println("<HTML><BODY>");

  // locate the cookie
    Cookie cookie = FindCookie(req, res);
    if(cookie == null) {
      cookie = new Cookie("myCookie", "");
    }

  // modify the cookie
    cookie.setValue(cookie.getValue() + "X");
    res.addCookie(cookie);

  // display the cookie
    out.println("Cookie Name  = " + cookie.getName() + "<P>");
    out.println("Cookie Value = " + cookie.getValue() + "<P>");

    out.println("</BODY></HTML>");
    out.close();
  }

  Cookie FindCookie(HttpServletRequest req, HttpServletResponse res)
                            throws IOException {
    Cookie cookie = null;
    Cookie[] cookies = req.getCookies();
    if(cookies == null) return null;
    
    for(int i = 0; i < cookies.length; i++) {
      if(cookies[i].getName().equals("myCookie")) cookie = cookies[i];
    }
    return cookie;
  }
}
