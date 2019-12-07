package strings;

public class Mutable {

	public static String useStringBuffer() {
		String first = "John";
		String last = "Smith";
		StringBuilder sb = new StringBuilder("My name is ");
		sb.append(first);
		sb.append(",");
		sb.append(last);
		return sb.toString();	
	}
	
	public static void main(String[] args) {
		String name = useStringBuffer();
		System.out.println(name);
	}

}
