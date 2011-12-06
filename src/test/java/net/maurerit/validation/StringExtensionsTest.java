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

import static org.junit.Assert.fail;
import lombok.ExtensionMethod;

import org.junit.Test;

/**
 * @author MM66053
 *
 */
@ExtensionMethod({Validation.class, StringExtensions.class})
public class StringExtensionsTest {

	@Test
	public void shouldMatchOneOf ( ) {
		String test = "thisString";
		String[] strings = { "notThisString", "thisString" };
		
		Validation.begin()
				  .matchesOneOf("test", test, strings)
				  .check();
	}

	@Test
	public void shouldNotMatchOneOf ( ) {
		String test = "thisString";
		String[] strings = { "notThisString1", "notThisString2" };
		
		try {
			Validation.begin()
					  .matchesOneOf("test", test, strings)
					  .check();
			fail("Should not have found a match.");
		}
		catch ( ParameterException e ) { /* Good test case */ }
	}
}
