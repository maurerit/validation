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
 * An RangeException is an exception that is thrown when a value is outside of its acceptable range.
 *
 * @author Matthew L. Maurer maurer.it@gmail.com
 */
public class RangeException extends ParameterException
{
	private static final long	serialVersionUID	= 8859200447567002896L;
	
	public RangeException(String parameterName, Object parameter, String message) {
		super(parameterName, parameter, message);
	}
}
