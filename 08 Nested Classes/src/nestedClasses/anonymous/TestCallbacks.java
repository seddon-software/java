package nestedClasses.anonymous;

import java.util.ArrayList;

public class TestCallbacks {

	public static void main(String[] args) {
		
		Button button1 = new Button();
		Button button2 = new Button();
		Button button3 = new Button();
		Button button4 = new Button();
		
		button1.addListener(
			    new Listener() {
			        public void callback() {
			        	System.out.println("callback on button 1");
			        }
			    }
			);
			
		button2.addListener(
			    new Listener() {
			        public void callback() {
			        	System.out.println("callback on button 2");
			        }
			    }
			);
			
		button3.addListener(
			    new Listener() {
			        public void callback() {
			        	System.out.println("callback on button 3");
			        }
			    }
			);
			
		button4.addListener(
			    new Listener() {
			        public void callback() {
			        	System.out.println("callback on button 4");
			        }
			    }
			);
			
		Framework framework = new Framework();
		framework.click(button2);
		framework.click(button4);
		framework.click(button3);
		framework.click(button1);
	}
}

interface Listener {
	void callback();
}

class Button {
	private Listener listener;
	
	public Listener getListener() {
		return listener;
	}

	public void setListener(Listener listener) {
		this.listener = listener;
	}

	public void addListener(Listener listener) {
		this.listener = listener;
	}
}

class Framework {
	
	public void click(Button button) {
		button.getListener().callback();
	}
}
