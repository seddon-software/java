package sessions;

////////////////////////////////////////////////////////////
//
//    Sessions
//
////////////////////////////////////////////////////////////

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class MyServlet extends javax.servlet.http.HttpServlet {

	private int hits;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		HttpSession session = null;
		String sessionIds = null;
		String hits = null;
		PrintWriter out = null;
		out = response.getWriter();
		session = request.getSession();

		// check if session is new
		if (session.isNew()) {
			out.println("Starting NEW Session<br>");
		} else {
			out.println("Session established<br>");
		}

		// check if user invalidates session
		String newSession = request.getParameter("newSession");
		if (newSession != null) {
			session.invalidate();
			session = request.getSession();

			// save session information in the ServletContext object
			sessionIds = (String) getServletContext().getAttribute("SESSION_IDS");
			if (sessionIds == null) sessionIds = "";
			sessionIds += session.getId() + "<br>";
			getServletContext().setAttribute("SESSION_IDS", sessionIds);
		}

		// count hits in this session
		hits = (String) session.getAttribute("HITS");
		if (hits == null) {
			session.setAttribute("HITS", "0");
		}
		hits = (String) session.getAttribute("HITS");
		int iHits = Integer.parseInt(hits) + 1;
		session.setAttribute("HITS", new String("" + iHits));
		out.print("Hits this session = " + iHits + "<hr>");
		out.println("</H1><H2>");
		out.println("<P>Generated session ID: " + session.getId() + "<BR>");
		out.println("<P>Created time:         " + session.getCreationTime() + "<BR>");
		out.println("<hr>");

		// print out history of session ids
		sessionIds = (String) getServletContext().getAttribute("SESSION_IDS");
		out.print(sessionIds + "</H2>");
	}
}
