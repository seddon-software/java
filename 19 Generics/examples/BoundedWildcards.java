////////////////////////////////////////////////////////////
//
//	Test.java	
//
////////////////////////////////////////////////////////////

package examples;

import java.util.ArrayList;
import java.util.List;

//     Fruit
//       |
//   __________
//   |         |
// Apple    Banana
//   |         |
// Pippin   Cavendish

class Fruit {
	private String name;
	public Fruit(String name) {
		this.name = name;
	}
}

class Apple extends Fruit {
	public Apple(String name) {	super(name); }
}
class Pippin extends Apple {
	public Pippin(String name) { super(name); }
}
class Banana extends Fruit {
	public Banana(String name) { super(name); }
}
class Cavendish extends Banana { 
	public Cavendish(String name) { super(name); }
}


public class BoundedWildcards {

	public static void main(String[] args) {
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple("apple 0"));
		apples.add(new Apple("apple 1"));
		apples.add(new Apple("apple 2"));
		
		// List<Fruit> fruits = apples;
			// doesn't compile 
			// because references point to same list and we could add some other fruit
			// and extract it as an apple
		// fruits.add(new Cavendish("banana 3"));
		// Apple a = friuts.get(3)
		
		// can use bounded wildcards
		{
			List<? extends Fruit> extendedFruits = apples;
			// ? could be Fruit, Apple, Pippin, Banana or Cavendish
				// but extendedFruits and apples point at the same collection of apples
				// we can get fruits, but can't safely add or get anything else
			// extendedFruits.add(new Fruit("fruit A"));
			// extendedFruits.add(new Banana("banana B"));
			// extendedFruits.add(new Cavendish("cavendish C"));
			Fruit f = extendedFruits.get(0);
			// Apple a = extendedFruits.get(0);
			// Pippin a = extendedFruits.get(0);
		}
		
		{
			List<? super Apple> superFruits = apples;
			// ? could be Object, Fruit or Apple, but not Pippin, Banana or Cavendish
				// but superFruits and apples point at the same collection of apples
				// we can add apples and pippins, but can't safely add or get anything else
			// superFruits.add(new Fruit("fruit A"));
			superFruits.add(new Apple("apple B"));
			superFruits.add(new Pippin("pippin C"));
			// Fruit f = superFruits.get(0);
			// Apple a = superFruits.get(0);
			// Pippin p = superFruits.get(0);
		}
	}
}
