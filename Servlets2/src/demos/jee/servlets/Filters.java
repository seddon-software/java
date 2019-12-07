////////////////////////////////////////////////////////////
//
//    Filters
//
////////////////////////////////////////////////////////////

package demos.jee.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class Filters implements Filter {

  public void init(FilterConfig filterConfig) {
    System.out.println("init");
    String city = filterConfig.getInitParameter("city");
    System.out.println("  " + city);
  }

  public void destroy() {
    System.out.println("destroy");
  }

  public void doFilter(ServletRequest request,
                       ServletResponse response,
                       FilterChain chain) throws IOException, ServletException {
    System.out.println("doFilter");
    System.out.println("  BEFORE");

    PrintWriter out = response.getWriter();
    CharResponseWrapper wrapper = new CharResponseWrapper(response);

    chain.doFilter(request, wrapper);

    System.out.println(wrapper);
    out.print(wrapper);
    System.out.println("  AFTER");
  }
}

class CharResponseWrapper extends HttpServletResponseWrapper {

  private CharArrayWriter output;

  public String toString() {
    return output.toString();
  }

  public CharResponseWrapper(ServletResponse response) {
    super((HttpServletResponse) response);
    output = new CharArrayWriter();
  }

  public PrintWriter getWriter() {
    return new PrintWriter(output);
  }
}