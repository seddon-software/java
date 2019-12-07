package streams;

import java.util.stream.IntStream;

public class Demo3 {

	public static void main(String[] args) {
		// old
//		for (int i = 1; i < 4; i++)
//			System.out.print(i);
		// new
		IntStream.range(1, 10)
			.mapToObj(i -> new Integer(i).toString() + ", ")
			.map(i ->  i + ", ")
			.forEach(System.out::print);

//		IntStream.range(1, 10)
//		         .boxed()
//		         .filter(i -> {return (i > 5)?true:false;})
//				 .map(i -> Integer.toString(i + 10) + ", ")
//		         .forEach(System.out::print);

//		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
//			System.out.println("filter: " + s);
//			return true;
//		}).forEach(s -> System.out.println("forEach: " + s));
	}
}
