

//SimpleServlet



package demos.jee.servlets;

import javax.servlet.http.*;
import java.io.*;

public class SimpleServlet extends HttpServlet {

	public void service(HttpServletRequest req,
			HttpServletResponse res) throws IOException {

		System.out.println("SimpleServlet");
		String bgColor = "#AA4444";
		String fgColor = "#AACCFF";
		PrintWriter out;

		// must set the content type first
		res.setContentType("text/html");

		// obtain a PrintWriter to insert HTML into
		out = res.getWriter();

		out.println("<HTML><HEAD><TITLE>This Is A Simple Servlet</TITLE></HEAD>");
		out.println("<BODY BGCOLOR=\"" + bgColor + "\"");
		out.println("<CENTER> <H1>");

		out.println("<form method='GET' action='/ServletDemos/hello'>");
		out.println("<input type='text' name='firstName' size='20' maxlength='80'>");
		out.println("<input type='text' name='lastName' size='20' maxlength='80'>");
		out.println("<input type='submit'>");
		out.println("</form>");


		out.println("<FONT FACE=\"ARIAL\" SIZE=8 COLOR=\"");
		out.println(fgColor + "\">");


		out.println("Simple Servlet<HR>");

		for (int i = 1; i <= 20; i++) {
			out.println("This is line " + i +"<BR>");
		}
		out.println("</FONT>");
		out.println("</H1> </CENTER>");
		out.println("</BODY></HTML>");

		out.close();
	}

	private static final long serialVersionUID = 1L;
}
