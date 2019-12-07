package examples.equality.ex1;

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
// the equals method has the wrong signiture ...
// ... it never gets called by HashSet

class MyVector {

	public boolean equals(MyVector rhs) {
		System.out.println("equals called");
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
