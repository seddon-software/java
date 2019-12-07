////////////////////////////////////////////////////////////
//
//    MyListener
//
////////////////////////////////////////////////////////////

package httpListeners;


import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MyApplicationAttributeListener 
	implements ServletContextAttributeListener  {

	private static final Log log = 
		LogFactory.getLog(MyApplicationAttributeListener.class.getName());

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		log.info("--- Application Add: " + event.getName() + ", " + event.getValue());		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		log.info("--- Application Remove: " + event.getName() + ", " + event.getValue());		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		log.info("--- Application Replace: " + event.getName() + ", " + event.getValue());		
	}
}