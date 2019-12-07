

//Member Classes



package nestedClasses.nonStatic;

import java.util.Iterator;


public class Iterators {

	public static void main(String[] args) {

		MyList myList = new MyList();
		myList.add(2);
		myList.add(3);
		myList.add(5);
		myList.add(7);
		myList.add(11);
		myList.add(13);
		myList.add(17);
		myList.add(19);

		// Inner object cannot exist without an instance of outer class
		MyList.MyIterator iterator1 = myList.new MyIterator();
		while(iterator1.hasNext()) {
			System.out.print(iterator1.next() + ",");
		}
		System.out.println();

		// use a factory to hide creation of inner object
		Iterator<Integer> iterator2 = myList.iterator();
		while(iterator2.hasNext()) {
			System.out.print(iterator2.next() + ",");
		}
	}
}


class MyList {

	private int[] list = new int[8];
	private int last = 0;

	public void add(Integer i) {
		list[last++] = i;
	}

	public Iterator<Integer> iterator() {
		return this.new MyIterator();
	}
	
	public class MyIterator implements Iterator<Integer> {
		private int current;

		public MyIterator() {
			current = 0;
		}

		public Integer next() { 
			return list[current++];
		}

		public boolean hasNext() { 
			if(current < 8)
				return true;
			else
				return false;
		}
		
		public void remove() {}
	}
}

