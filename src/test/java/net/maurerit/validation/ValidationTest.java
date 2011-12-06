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

import net.maurerit.validation.Validation;

import org.junit.Test;
import static org.junit.Assert.fail;

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
