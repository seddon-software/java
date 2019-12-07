package geometry;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;	// not depreciated
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestPoint {

	private Point p;
	
	@Before
	public void setUp() throws Exception {
		p = new Point(3, 4);
	}

	@Test
	public void doesTheEqualityMethodWork() {
		Point q = new Point(3, 4);
		Boolean result = p.equals(q);
		assertThat(result, is(true));
	}
	
	@Test
	public void canIMoveMyPointAShortDistance() throws Exception {
		p.moveBy(1, 1);
		assertThat(p.distanceSquared(), is(equalTo(41)));
	}
	
	@Test
	public void canICompareEqualPoints() {
		Point q = new Point(3, 4);
		assertThat(p, is(equalTo(q)));
	}
	
	@Test
	public void canICompareDifferentPoints() {
		Point q = new Point(7, 8);
		assertThat(p, is(not(equalTo(q))));
	}

	@Test
	public void canIReflectAboutTheOrigin() {
		p.reflectAboutTheOrigin();
		assertThat(p, is(equalTo(new Point(-3, -4))));
	}
	
	// exceptions
	@Test(expected = TooFar.class)
	public void checkThatAnExceptionIsThrownIfWeMoveTooFarFromTheOrigin() throws Throwable {
	    p.moveBy(10, 10);
	    p.distanceSquared();  // this throws
	}

	// detailed exceptions (type and message)
	@Rule public ExpectedException thrown = ExpectedException.none();
	@Test
	public void anotherCheckThatAnExceptionIsThrownIfWeMoveTooFarFromTheOrigin() throws Throwable {
		thrown.expect(TooFar.class);
		thrown.expectMessage("from origin");
	    p.moveBy(10, 10);
	    p.distanceSquared();  // this throws
	}
}
