

//ServletContext



package demos.jee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class MyContext extends HttpServlet {

	public void service(HttpServletRequest req,
			HttpServletResponse res) throws IOException {

		System.out.println("SimpleServlet");
		String bgColor = "#FFFF01";
		String fgColor = "#00FFFF";
		PrintWriter out;

		// must set the content type first
		res.setContentType("text/html");

		this.log("xyz");

		// obtain a PrintWriter to insert HTML into
		out = res.getWriter();

		out.println("<HTML><HEAD><TITLE>Servlet Context</TITLE></HEAD>");
		out.println("<BODY BGCOLOR=\"" + bgColor + "\"");
		out.println(fgColor + "\">");
		out.println("<H2>");
		// servlet specific information
		out.println("<P>Servlet parameter = " + getInitParameter("NICKNAME"));
		out.println("<P>ServletName = " + getServletName());

		// webapp specific information
		ServletContext ctx = getServletContext();
		out.println("<P>WebApp parameter = " + ctx.getInitParameter("PASSWORD"));
		out.println("<P>ServerInfo = " + ctx.getServerInfo());
		out.println("</H2>");
		out.println("</BODY></HTML>");

		out.close();
	}
}
