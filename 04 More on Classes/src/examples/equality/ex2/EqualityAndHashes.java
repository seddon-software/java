package examples.equality.ex2;

import java.util.HashSet;

public class EqualityAndHashes {

	public static void main(String[] args) {
		MyVector v1 = new MyVector(5, 7);
		MyVector v2 = new MyVector(5, 7);
		MyVector v3 = new MyVector(2, 8);
		HashSet<MyVector> collection = new HashSet<MyVector>();
		collection.add(v1);
		collection.add(v3);
		
		// this should print true because v1 is equal to v2
		System.out.println(v1.equals(v2));
		
		// this should print true because v1 is equal to v2
		System.out.println(collection.contains(v2));
	}

}
// the equals method now has the correct signiture ...
// ... but we also need to override hashcode method

class MyVector {

	public boolean equals(Object o) {
		System.out.println("equals called");
		MyVector rhs = (MyVector) o;
		if (x != rhs.x)	return false;
		if (y != rhs.y)	return false;
		return true;
	}

	private final int x;
    private final int y;

    public MyVector(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
