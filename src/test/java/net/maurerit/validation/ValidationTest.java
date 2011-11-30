package net.maurerit.validation;

import net.maurerit.validation.Validation;

import org.junit.Test;
import static org.junit.Assert.fail;

public class ValidationTest
{
	@Test
	public void shouldValidateFineNotNull ( ) {
		Validation.begin().notNull(new String(), "stringName").check();
	}
	
	@Test
	public void shouldNotValidateFineNotNull ( ) {
		try {
			Validation.begin().notNull(null, "nullString").check();
			fail("Should have thrown and IllegalArgumentException.");
		}
		catch ( IllegalArgumentException e ) { /* Good Test case */ }
	}
	
	@Test
	public void shouldValidateFineNotEmpty ( ) {
		Validation.begin().notEmpty("aString", "aString").check();
	}
	
	@Test
	public void shouldNotValidateFineNotEmpty ( ) {
		try {
			Validation.begin().notEmpty("", "aString");
		}
		catch ( IllegalArgumentException e ) { /* Good Test case */ }
	}
}
