////////////////////////////////////////////////////////////
//
//    MyListener
//
////////////////////////////////////////////////////////////

package httpListeners;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MySessionListener 
	implements HttpSessionListener {

	private static final Log log = 
		LogFactory.getLog(MySessionListener.class.getName());

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		String id = event.getSession().getId();
		log.info("--- Session created with ID: " + id);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		String id = event.getSession().getId();
		log.info("--- Session destroyed with ID: " + id);
	}
}
