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


/**
 * A MultiParameterException is thrown when multiple parameters are sent through a validation
 * chain before a call to {@link Validation#check()} is called.  This exception will format
 * the resulting message in a friendly manor so that its understandable why the parameters
 * failed their validations and what their values were (using their {@link Object#toString() toString()}
 * implementations).
 * 
 * @author Matthew L. Maurer maurer.it@gmail.com
 */
public class MultiParameterException extends IllegalArgumentException
{
	private static final long	serialVersionUID	= 8465430338970002096L;
	private String				message;

	public MultiParameterException ( ParameterException... parameterExceptions ) {
		StringBuilder sb = new StringBuilder();
		for ( int idx = 0; idx < parameterExceptions.length; idx++ ) {
			ParameterException ex = parameterExceptions[ idx ];
			
			sb.append(ex.getParameterName())
			  .append(" with value ")
			  .append(ex.getParameter())
			  .append(" failed a check with message: ")
			  .append(ex.getMessage());

			if ( idx != parameterExceptions.length - 1 ) {
				sb.append(System.getProperty("line.separator"));
			}
		}

		message = sb.toString();
	}
	
	@Override
	public String getMessage ( ) {
		return message;
	}
}
