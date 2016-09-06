package seedu.addressbook.utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import seedu.addressbook.common.Utils;

public class UtilsTest {

	/* 
	 * 
	 * Test isAnyNull function 
	 * 
	 * */
	@Test
	public void isAnyNull_oneInt() {
		// False since no Null
		assertFalse(Utils.isAnyNull(2));
	}
	
	@Test
	public void isAnyNull_fewInts() {
		// False since no Null
		assertFalse(Utils.isAnyNull(2, 3, 4));
	}
	
	@Test
	public void isAnyNull_objArray() {
		// False since no Null
		assertFalse(Utils.isAnyNull(new Object[] {2, 3, 4}));
	}
	
	@Test
	public void isAnyNull_oneString() {
		// False since no Null
		assertFalse(Utils.isAnyNull("String"));
	}
	
	@Test
	public void isAnyNull_fewStrings() {
		// False since no Null
		assertFalse(Utils.isAnyNull("String", "String2", "String3"));
	}

	@Test
	public void isAnyNull_nullPresent() {
		// True since 1 null
		assertTrue(Utils.isAnyNull(2, null));
	}
	
	@Test
	public void isAnyNull_nullInArr() {
		// True since 1 null
		assertTrue(Utils.isAnyNull(new Object[] { 2, 2, null }));
	}

	/* 
	 * 
	 * Test elementsAreUnique function 
	 * 
	 **/
	@Test
	public void elementsAreUnique_nulls() {
		// False since nulls are similar
		assertFalse(Utils.elementsAreUnique(setupCollection(null, null)));
	}
	
	@Test
	public void elementsAreUnique_oneItem() {
		// True since only a single item
		assertTrue(Utils.elementsAreUnique(setupCollection(1)));
	}
	
	@Test
	public void elementsAreUnique_sameInt() {
		// False since there are similar integers
		assertFalse(Utils.elementsAreUnique(setupCollection(1, 1)));
	}
	
	@Test
	public void elementsAreUnique_diffInt() {
		// True since integers are different
		assertTrue(Utils.elementsAreUnique(setupCollection(1, 2)));
	}
	
	@Test
	public void elementsAreUnique_sameBoolean() {
		// False since there are similar booleans
		assertFalse(Utils.elementsAreUnique(setupCollection(true, true)));
	}
	
	@Test
	public void elementsAreUnique_diffBoolean() {
		// True since booleans are different
		assertTrue(Utils.elementsAreUnique(setupCollection(true, false)));
	}
	
	@Test
	public void elementsAreUnique_samePersonObj() {
		// False since same object
		Person A = new Person("A");
		assertFalse(Utils.elementsAreUnique(setupCollection(A, A)));
	}
	
	@Test
	public void elementsAreUnique_diffPersonObj() {
		// True since different object
		Person A = new Person("A");
		Person B = new Person("B");
		assertTrue(Utils.elementsAreUnique(setupCollection(A, B)));
	}
	
	@Test
	public void elementsAreUnique_diffPersonObjSameName() {
		// True since different object
		Person A = new Person("A");
		Person B = new Person("A");
		assertTrue(Utils.elementsAreUnique(setupCollection(A, B)));
	}
	
	/* 
	 * 
	 * Created for testing purposes 
	 * 
	 * */
	public class Person {
		private String name;
		public Person(String name) { this.name = name; }
	}
	
	/* 
	 * 
	 * Utility function to set up the Collections easily
	 * 
	 **/
	public static Collection<Object> setupCollection(Object... objs) {
		Collection<Object> toReturn = new ArrayList<Object>();
		for (Object obj : objs) {
			toReturn.add(obj);
		}
		return toReturn;
	}
}
