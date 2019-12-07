////////////////////////////////////////////////////////////
//
//	TestLog4J.java	
//
////////////////////////////////////////////////////////////

package simple;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;


public class Test {
  public static void main(String[] args) {
    try {
      Logger mylogger = Logger.getLogger("mylogger");
      SimpleLayout mylayout = new SimpleLayout();
      FileAppender myappender = new FileAppender(mylayout, "logs/mylogger.log"); 
      mylogger.addAppender(myappender);
      
      
      mylogger.setLevel(Level.INFO);

      // This request is enabled, because WARN >= INFO.
      mylogger.warn("Low fuel level.");
      
      // This request is disabled, because DEBUG < INFO.
      mylogger.debug("Starting search for nearest gas station.");

    } catch(IOException e) {
      e.printStackTrace();
    }    
  }
}


