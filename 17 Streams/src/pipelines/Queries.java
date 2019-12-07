package pipelines;

import java.time.Year;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Queries {

	public static void main(String[] args) {
		List<Book> library = createLibrary();

		System.out.println("\n---- build a stream of books and print");
		Stream<Book> computingBooks = library.stream()
				.filter(b -> b.getTopic() == Book.Topic.COMPUTING);
		computingBooks.forEach(b -> System.out.println(b.getTitle()));

		System.out.println("\n---- print titles immediately");
		library.stream()
			.filter(b -> b.getTopic() == Book.Topic.COMPUTING)
			.forEach(b -> System.out.println(b.getTitle()));

		System.out.println("\n---- get all Titles");
		library.stream().map(Book::getTitle).forEach(System.out::println);

		System.out.println("\n---- sort all Titles");
		library.stream().sorted(Comparator.comparing(Book::getTitle))
				.forEach(System.out::println);

		System.out.println("\n---- find oldest book");
		Book b = library.stream().min(Comparator.comparing(Book::getPubDate))
				.get();
		System.out.println(b.getTitle());

		System.out.println("\n---- when find fails");
		Optional<Book> b2 = library.stream()
				.filter(b3 -> b3.getTopic() == Book.Topic.HISTORY).findFirst();

		System.out.println("Optional: " + b2.isPresent());
	}

	private static List<Book> createLibrary() {
		Book nails = new Book("Fundamentals of Chinese Fingernail Image",
				Arrays.asList("Li", "Fu", "Li"), new int[] { 256 }, // page
																	// count
				2014, // publication date
				25.2, // height in cm
				Book.Topic.MEDICINE);
		Book dragon = new Book("Compilers: Principles, Techniques and Tools",
				Arrays.asList("Aho", "Lam", "Sethi", "Ullman"),
				new int[] { 1009 }, 2006, 23.6, Book.Topic.COMPUTING);
		Book voss = new Book("Voss", Arrays.asList("Patrick White"),
				new int[] { 478 }, 1957, 19.8, Book.Topic.FICTION);
		Book lotr = new Book("Lord of the Rings",
				Arrays.asList("J.R.R.Tolkien"), new int[] { 531, 416, 624 },
				1955, 23.0, Book.Topic.FICTION);
		List<Book> library = Arrays.asList(nails, dragon, voss, lotr);
		return library;
	}

}

class Book {
	public static enum Topic {
		HISTORY, COMPUTING, MEDICINE, FICTION
	}

	public Book(String title, List<String> authors, int[] pageCounts,
			int pubDate, double height, Topic topic) {
		this.title = title;
		this.authors = authors;
		this.pageCounts = pageCounts;
		this.pubDate = Year.of(pubDate);
		this.height = height;
		this.topic = topic;
	}

	public String getTitle() {
		return title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public int[] getPageCounts() {
		return pageCounts;
	}

	public Year getPubDate() {
		return pubDate;
	}

	public double getHeight() {
		return height;
	}

	public Topic getTopic() {
		return topic;
	}

	private String title;
	private List<String> authors;
	private int[] pageCounts;
	private Year pubDate;
	private double height;
	private Topic topic;
}
