package functionalInterfaces;
public class Ex4_DefiningYourOwnTypes {

	// annotation not mandatory
    @FunctionalInterface
    interface Function3 <A, B, C, R> { 
    //R is like Return, but doesn't have to be last in the list nor named R.
        public R doit (A a, B b, C c);
    }

    public static void main(String[] args) {
	    Function3 <String, Integer, Double, Double> multiAdder = (a, b, c) -> {
            return Double.parseDouble (a) + b + c;
        };
        System.out.println(multiAdder.doit("22.4", 2, 40.0));	    
	}
}
