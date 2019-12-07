////////////////////////////////////////////////////////////
//
//    PowersHandler.java
//
////////////////////////////////////////////////////////////

package tagLibraries;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

@SuppressWarnings("serial")
public class PowersHandler extends BodyTagSupport {

	private int number;
	private String operation;

	public PowersHandler() { super(); }

	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			int data = 0;
			int n = number;
			if(operation.equals("square")) data = n * n;
			if(operation.equals("cube"  )) data = n * n * n;
			if(operation.equals("quad"  )) data = n * n * n * n;
			out.println(data);
		} catch(Exception e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}
