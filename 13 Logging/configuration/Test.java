////////////////////////////////////////////////////////////
//
//	Test.java	
//
////////////////////////////////////////////////////////////

package configuration;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Test {

  public static void main(String[] args) {
    try {
      Logger mylogger = Logger.getLogger("mylogger");
      PropertyConfigurator.configure("configuration/logger.properties");
      
      mylogger.setLevel(Level.INFO);

      // This request is enabled, because WARN >= INFO.
      mylogger.warn("Low fuel level.");
      
      // This request is disabled, because DEBUG < INFO.
      mylogger.debug("Starting search for nearest gas station.");

    } catch(Exception e) {
      e.printStackTrace();
    }    
  }
}

