////////////////////////////////////////////////////////////
//
//    ReferenceQueues
//
////////////////////////////////////////////////////////////

package ReferenceQueues;

import java.lang.ref.*;

public class Test {

	public static void main(String[] args) {
		ReferenceQueue<MyObject> rq = new ReferenceQueue<MyObject>();

		try {
			MyObject m = new MyObject();
			SoftReference<MyObject> sr = new SoftReference<MyObject>(m, rq);
			SoftReference<?> dead = null;

			// remove strong reference
			m = null;
			// get it back
			m = sr.get();
			m.Hello();

			// remove strong reference again
			m = null;

			// MyObject is softly reachable
			// use up memory to force softly reachable objects to be collected
			int size = 4096;
			while (true) {
				Object memory = new byte[size];
				size = size * 4;

				// check reference queue to see if MyObject has been collected
				dead = (SoftReference<?>) rq.poll();
				if (dead == null)
					continue;

				// check if soft reference is on the queue
				if (dead == sr) {
					System.out.println("soft reference is on the queue");
				} else
					System.out.println("Another object has been cleared");

				// this will fail because object has been finalized
				m = (MyObject) dead.get();
				if (m == null) {
					System.out.println("MyObject has been collected by GC");
					break;
				}
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}
}

class MyObject {
	public void Hello() {
		System.out.println("hello from MyObject");
	}

	public void finalize() {
		System.out.println("MyObject finalized");
	}
}
