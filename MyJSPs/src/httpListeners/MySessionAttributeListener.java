////////////////////////////////////////////////////////////
//
//    MyListener
//
////////////////////////////////////////////////////////////

package httpListeners;


import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MySessionAttributeListener 
	implements HttpSessionAttributeListener {

	private static final Log log = 
		LogFactory.getLog(MySessionAttributeListener.class.getName());


	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
        log.info("--- Session Add: " + event.getName() + ", " + event.getValue());		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
        log.info("--- Session Remove: " + event.getName() + ", " + event.getValue());		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
        log.info("--- Session Replace: " + event.getName() + ", " + event.getValue());		
	}
}
