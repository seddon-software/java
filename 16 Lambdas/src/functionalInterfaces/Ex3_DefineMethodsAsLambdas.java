package functionalInterfaces;
import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;

public class Ex3_DefineMethodsAsLambdas {

	public static void main(String[] args) {
		Utils d = new Utils();
		
		DoubleUnaryOperator f4 = Utils::cube;
		System.out.println( f4.applyAsDouble(3.0) );

		double result = d.sine.applyAsDouble(6.0);
		System.out.println(result);
		
		boolean b = d.isPositive.test(35.8);
		System.out.println(b);
	}

}

class Utils {
	public static double cube(double x) {
		return x * x * x;
	}
	public DoubleUnaryOperator sine = (double x) -> Math.sin(x);
	public DoublePredicate isPositive = (x) -> x > 0; 
}