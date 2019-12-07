package functionalInterfaces;
import java.util.function.BinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

public class Ex1_FunctionalInterfaces {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Maths m = new Maths();
		
		// BinaryOperator<T>  ~ T apply(T t, T u)
		BinaryOperator<Double> f1 = Maths::add;
		System.out.println( f1.apply(6.0, 13.0) );

		// Function<T,R> ~ R apply(T t)
		Function<Double, Double> f2 = Maths::square;
		System.out.println( f2.apply(6.0) );
		
		// DoubleUnaryOperator ~ double applyAsDouble(double)
		DoubleUnaryOperator f3 = Maths::cube;
		System.out.println( f3.applyAsDouble(3.0) );
		
	}

}


class Maths {
	public static Double add(Double x, Double y) {
		return x + y;
	}
	public static Double square(Double x) {
		return x * x;
	}
	public static double cube(double x) {
		return x * x * x;
	}
}