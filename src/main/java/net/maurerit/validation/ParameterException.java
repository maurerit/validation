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
 * Exception thrown if parameters do not meet their criteria during a {@link Validation validation}.
 * 
 * @author Matthew L. Maurer maurer.it@gmail.com
 */
public class ParameterException extends IllegalArgumentException
{
	private static final long	serialVersionUID	= -8444550669651828748L;

	private String				parameterName;
	private Object				parameter;

	public ParameterException ( String parameterName, Object parameter, String message ) {
		super("Parameter: " + parameterName + " with value: " + parameter + " failed a check with message: " + message);
		this.parameterName = parameterName;
		this.parameter = parameter;
	}

	public String getParameterName ( ) {
		return parameterName;
	}

	public Object getParameter ( ) {
		return parameter;
	}
}
