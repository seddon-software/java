package pipelines;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class EfficiencyWithBuiltInTypes {

	public static void main(String[] args) {
		// this example is very inefficient, because of boxing and unboxing
		Optional<Integer> max1 = Arrays.asList(1, 2, 3, 4, 5).stream()
				.map(i -> i + 1)
				.max(Integer::compare);
		System.out.println(max1.get());
		
		// better to work directly with primitives
		OptionalInt max2 = IntStream.rangeClosed(1, 5)
				.map(i -> i + 1)
				.max();
		System.out.println(max2.getAsInt());
	}

}
