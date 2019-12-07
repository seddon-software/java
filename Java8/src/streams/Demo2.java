package streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class Demo2 {
	public static void main(String[] args) {
		// starting with a collection we convert to a stream
		Arrays.asList("a1", "a2", "a3")
		      .stream()
		      .findFirst()
			  .ifPresent(System.out::println);

		// or simply create a stream in the first place
		Stream.of("a1", "a2", "a3")
		      .findFirst()
		      .ifPresent(System.out::println);
	}
}
