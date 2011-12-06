package net.maurerit.validation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import lombok.ExtensionMethod;

import org.junit.Test;

@ExtensionMethod({Validation.class, ListExtensions.class})
public class ListExtensionsTest {

	@Test
	public void shouldMatchItemsInAList ( ) {
		List<String> strings = new ArrayList<String>();
		
		strings.add("one");
		
		Validation.begin()
				  .containsOneOf("strings", strings, "one", "two")
				  .check();
	}

	@Test
	public void shouldNotMatchItemsInAList ( ) {
		List<String> strings = new ArrayList<String>();
		
		strings.add("three");
		
		try {
			Validation.begin()
					  .containsOneOf("strings", strings, "one", "two" )
					  .check();
			fail("Should have thrown ParameterException");
		}
		catch ( ParameterException e ) { /* Good test case */ }
	}
}
