

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("RequestObject");
	    PrintWriter out = response.getWriter();
	    out.print("<p>getMethod:      " + request.getMethod());
	    out.print("<p>getAuthType:    " + request.getAuthType());
	    out.print("<p>getRequestURL:  " + request.getRequestURL());
	    out.print("<p>getProtocol:    " + request.getProtocol());
	    out.print("<p>getServletPath: " + request.getServletPath());
	    out.print("<p>getPathInfo:    " + request.getPathInfo());
	    out.print("<p>getLocalPort:   " + request.getLocalPort());
	    out.print("<p>getLocalAddr:   " + request.getLocalAddr());
	    out.print("<p>getQueryString: " + request.getQueryString());
	    out.print("<p>getServerName:  " + request.getServerName());
	    out.print("<p>getServerPort:  " + request.getServerPort());
	    out.print("<p>getRemoteAddr:  " + request.getRemoteAddr());
	    out.print("<p>getRemoteUser:  " + request.getRemoteUser());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
