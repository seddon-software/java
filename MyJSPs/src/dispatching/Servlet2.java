package dispatching;
////////////////////////////////////////////////////////////
//
//    Servlet2
//
////////////////////////////////////////////////////////////


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Servlet2 extends HttpServlet {

  public void service(HttpServletRequest req,
                     HttpServletResponse res) throws IOException {

    PrintWriter out = res.getWriter();
    out.println("<h3> This is Servlet2</h3>");
    out.println("... I'm not going to call anyone ...");

  }
}
