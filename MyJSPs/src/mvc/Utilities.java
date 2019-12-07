package mvc;

public class Utilities {
	public static String displayAsXs(int pts) {
		
		StringBuffer buffer = new StringBuffer("");
		for(int i = 0; i < pts; i++) {
			buffer.append("X");
		}

		return buffer.toString();
	}

}
