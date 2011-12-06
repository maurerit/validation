/**
 *  Copyright 2008 - 2011
 *            Matthew L. Maurer maurer.it@gmail.com
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *       http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package net.maurerit.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ValidationTest
{
	@Test
	public void shouldValidateFineNotNull ( ) {
		Validation.begin().notNull("", "stringName").check();
	}
	
	@Test
	public void shouldNotValidateFineNotNull ( ) {
		try {
			Validation.begin().notNull(null, "nullString").check();
			fail("Should have thrown and IllegalArgumentException.");
		}
		catch ( IllegalArgumentException e ) { /* Good test case */ }
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
		catch ( IllegalArgumentException e ) {
			assertEquals("Parameter: aString with value:  failed a check with message: aString can not be null or empty", e.getMessage());
		}
	}
	
	@Test
	public void shouldNotValidateFineThrowMultiParameterException ( ) {
		try {
			Validation.begin()
					  .notEmpty("", "aString")
					  .notEmpty("", "aString")
					  .check();
		}
		catch ( MultiParameterException e ) { /* Good test case */ }
	}
	
	@Test
	public void shouldBeGreaterThan10Dot1 ( ) {
		Validation.begin()
				  .greaterThan(10.2, 10.1, "aDouble")
				  .check();
	}
	
	@Test
	public void shouldNotBeGreaterThan10Dot1 ( ) {
		try {
			Validation.begin()
					  .greaterThan(10.1, 10.1, "aDouble")
					  .check();
			fail("Should have thrown ParameterException.");
		}
		catch ( IllegalArgumentException e ) { /* Good test case */ }
	}
	
	@Test
	public void shouldBeGreaterThan10 ( ) {
		Validation.begin()
				  .greaterThan(10, 9, "anInt")
				  .check();
	}
	
	@Test
	public void shouldNotBeGreaterThan10 ( ) {
		try {
			Validation.begin()
					  .greaterThan(10, 10, "anInt")
					  .check();
			fail("Should have thrown ParameterException.");
		}
		catch ( IllegalArgumentException e ) { /* Good test case */ }
	}
	
	@Test
	public void shouldBeFalse ( ) {
		Validation.begin()
				  .isFalse(false, "Value should be false", "Value")
				  .check();
	}
	
	@Test
	public void shouldNotBeFalse ( ) {
		try {
			Validation.begin()
					  .isFalse(true, "Value should be false", "Value")
					  .check();
			fail("Should have thrown ParameterException.");
		}
		catch ( IllegalArgumentException e ) { /* Good test case */ }
	}
	
	@Test
	public void shouldBeTrue ( ) {
		Validation.begin()
				  .isTrue(true, "Value should be true", "Value")
				  .check();
	}
	
	@Test
	public void shouldNotBeTrue ( ) {
		try {
			Validation.begin()
					  .isTrue(false, "Value should be true", "Value")
					  .check();
			fail("Should have thrown ParameterException.");
		}
		catch ( IllegalArgumentException e ) { /* Good test case */ }
	}
	
	@Test
	public void shouldBeLessThan10Dot3 ( ) {
		Validation.begin()
				  .lessThan(10.2, 10.3, "aDouble")
				  .check();
	}
	
	@Test
	public void shouldNotBeLessThan10Dot3 ( ) {
		try {
			Validation.begin()
					  .lessThan(10.3, 10.3, "aDouble")
					  .check();
			fail("Should have thrown ParameterException.");
		}
		catch ( IllegalArgumentException e ) { /* Good test case */ }
	}
	
	@Test
	public void shouldBeLessThan10 ( ) {
		Validation.begin()
				  .lessThan(9, 10, "anInt")
				  .check();
	}
	
	@Test
	public void shouldNotBeLessThan10 ( ) {
		try {
			Validation.begin()
					  .lessThan(10, 10, "anInt")
					  .check();
			fail("Should have thrown ParameterException.");
		}
		catch ( IllegalArgumentException e ) { /* Good test case */ }
	}
	
	@Test
	public void shouldBeNoGreaterThan10Dot3 ( ) {
		Validation.begin()
				  .noGreaterThan(10.2, 10.3, "aDouble")
				  .check();
	}
	
	@Test
	public void shouldNotBeNoGreaterThan10Dot3 ( ) {
		try {
			Validation.begin()
					  .noGreaterThan(10.4, 10.3, "aDouble")
					  .check();
			fail("Should have thrown ParameterException.");
		}
		catch ( IllegalArgumentException e ) { /* Good test case */ }
	}
	
	@Test
	public void shouldBeNoGreaterThan10 ( ) {
		Validation.begin()
				  .noGreaterThan(9, 10, "anInt")
				  .check();
	}
	
	@Test
	public void shouldNotBeNoGreaterThan10 ( ) {
		try {
			Validation.begin()
					  .noGreaterThan(11, 10, "anInt")
					  .check();
			fail("Should have thrown ParameterException.");
		}
		catch ( IllegalArgumentException e ) { /* Good test case */ }
	}
	
	@Test
	public void shouldBeNoLessThan10Dot1 ( ) {
		Validation.begin()
				  .noLessThan(10.2, 10.1, "aDouble")
				  .check();
	}
	
	@Test
	public void shouldNotNoLessThan10Dot1 ( ) {
		try {
			Validation.begin()
					  .noLessThan(10, 10.1, "aDouble")
					  .check();
			fail("Should have thrown ParameterException.");
		}
		catch ( IllegalArgumentException e ) { /* Good test case */ }
	}
	
	@Test
	public void shouldBeNoLessThan10 ( ) {
		Validation.begin()
				  .noLessThan(10, 9, "anInt")
				  .check();
	}
	
	@Test
	public void shouldNotBeNoLessThan10 ( ) {
		try {
			Validation.begin()
					  .noLessThan(9, 10, "anInt")
					  .check();
			fail("Should have thrown ParameterException.");
		}
		catch ( IllegalArgumentException e ) { /* Good test case */ }
	}
}
