////////////////////////////////////////////////////////////
//
//    MyListener
//
////////////////////////////////////////////////////////////

package httpListeners;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MyApplicationListener 
	implements ServletContextListener {

	private static final Log log = 
		LogFactory.getLog(MyApplicationAttributeListener.class.getName());

	@Override
	public void contextInitialized(ServletContextEvent event) {
		@SuppressWarnings("unused")
		ServletContext ctx = event.getServletContext();
		log.info("--- Servlet context initialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		@SuppressWarnings("unused")
		ServletContext ctx = event.getServletContext();
		log.info("--- Servlet context destroyed");
	}
}