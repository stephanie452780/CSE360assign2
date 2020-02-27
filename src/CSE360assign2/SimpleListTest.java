package CSE360assign2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSE360assign2.SimpleList;

class SimpleListTest {

	@Test
	void testAppend() {
		SimpleList test = new SimpleList();
		test.add(4);
		test.add(5);
		
		test.append(3);
		
		assertEquals("5 4 3",test.toString());
	}

	@Test
	void testFirst() {
		SimpleList test = new SimpleList();
		test.add(4);
		test.add(5);
		
		assertEquals(5,test.first());
	}

	@Test
	void testLast() {
		SimpleList test = new SimpleList();
		test.add(4);
		test.add(5);
		
		assertEquals(4,test.last());
	}

	@Test
	void testSize() {
		SimpleList test = new SimpleList();
		
		assertEquals(10,test.size());
	}

}
