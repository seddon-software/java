package functionalInterfaces;
import java.util.function.BinaryOperator;

public class Ex5_PassingLambdasAsParameters {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// class A has a static method that takes a method parameter from class B
		double result;
		
		// parameter 1 is a static method
		result = Framework.f( (t, u) -> MyUtils.add(t, u), 7.0, 5.0 );
		result = Framework.f( MyUtils::subtract, 7.0, 5.0 );		// short form

		// parameter 1 is an instance method
		MyUtils b = new MyUtils();
		result = Framework.f( (t, u) -> b.multiply(t, u), 6.0, 2.0);
		result = Framework.f( b::divide, 6.0, 2.0 );	    // short form	
	}
}

class Framework {
	public static Double f(BinaryOperator<Double> fn, Double t, Double u) {		
		return fn.apply(t, u);
	}
}

class MyUtils {
	// static methods
	public static double add(double x, double y) { return x + y; }
	public static double subtract(double x, double y) { return x - y; }
	// instance methods
	public double multiply(double x, double y) { return x * y; }
	public double divide(double x, double y) { return x / y; }
}