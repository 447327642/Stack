/* Download hamcrest-all-1.3.jar and add to build path */
/* Eclipse: add as external jar, making sure it's above Junit in build order */

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class MyStackTest {

    MyStack s;
    
	@Before
	public void setUp() throws Exception {
		s = new MyStack();
	}

	@Test
	public void stackIsEmptyOnConstruction() {
		assertTrue(s.isEmpty());
	}
	
	@Test
	public void stackHasSizeZeroOnConstruction() {
		assertThat(s.size(), is(equalTo(0)));
		;
	}

	@Test /* testing boundary value */
	public void after1PushesStackIsNonEmptyAndSizeIs1() {
		s.push(1);
		assertFalse(s.isEmpty());
		assertThat(s.size(), is(equalTo(1)));
	}
	
	@Test /* testing nominal value */
	public void after3PushesStackIsNonEmptyAndSizeIs3() {
		s.push(1);
		s.push(2);
		s.push(3);
		assertFalse(s.isEmpty());
		assertThat(s.size(), is(equalTo(3)));
	}
	
	@Test
	public void popAfterPushReturnsPushedValueAndRestoresStackSize() {
		int pushValue = 200;
		int oldSize = s.size();
		s.push(pushValue);
		assertThat(s.pop(), is(equalTo(pushValue)));
		assertThat(s.size(), is(equalTo(oldSize)));
	}
	
	@Test
	public void peekAfterPushReturnsPushedValueAndMaintainsStackSize() {
		int pushValue = 300;
		s.push(pushValue);
		int size = s.size();
		assertThat(s.peek(), is(equalTo(pushValue)));
		assertThat(s.size(), is(equalTo(size)));
	}
	
	@Test
	public void poppingAllValuesLeavesAnEmptyStack() {
		int size = 5;
		for (int v = 1; v <= size; v++) {
			s.push(v);
		}
		for (int v = 1; v <= size; v++) {
			s.pop();
		}
		assertTrue(s.isEmpty());
	}
	
	@Test (expected = NoSuchElementException.class)
	public void poppingFromEmptyStackThrowsException() {
		/* this will fail... naturally */
		s.pop();
	}
	
	@Test (expected = NoSuchElementException.class)
	public void peekingIntoEmptyStackThrowsException() {
		/* this will fail... naturally */
		s.peek();
	}
	
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void pushingTooManyElementsToStackThrowsException() {
		for (int v = 1; v <= s.maxSize() + 1; v++) {
			s.push(v);
		}
	}
	
	@Test 
	public void pushingTooManyElementsToStackThrowsExceptionSaferVersion() {
		int lastDrop = 10;
		for (int v = 1; v <= s.maxSize(); v++) {
			s.push(v);
		}
		try {
			s.push(lastDrop);
			fail(); // hmmm, this should never happen
		} catch (ArrayIndexOutOfBoundsException e) {
		 // success: do nothing	
		}
	}

}
