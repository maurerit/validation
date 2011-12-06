package yet.another.javapackage;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import lombok.ExtensionMethod;

import net.maurerit.validation.ListExtensions;
import net.maurerit.validation.ParameterException;
import net.maurerit.validation.Validation;

import org.junit.Test;

@ExtensionMethod({Validation.class, ListExtensions.class})
public class ListExtensionsOutsidePackageTest {

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
			fail("Should not have found a match.");
		}
		catch ( ParameterException e ) { /* Good test case */ }
	}
}
