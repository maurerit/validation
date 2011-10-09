package net.maurerit.validation;

import net.maurerit.validation.Validation;

import org.junit.Test;
import static org.junit.Assert.fail;

public class ValidationTest
{
	@Test
	public void shouldValidateFine ( ) {
		Validation.begin().notNull(new String(), "stringName").check();
	}
	
	@Test
	public void shouldNotValidateFine ( ) {
		try {
			Validation.begin().notNull(null, "nullString").check();
			fail("Should have thrown and IllegalArgumentException.");
		}
		catch ( IllegalArgumentException e ) { /* NO-OP: Good Test */ }
	}
}
