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

import java.util.ArrayList;
import java.util.List;

/**
 * Validation provides a convenient means for parameter checking. Class methods in the Validation class can be
 * used to verify that method parameters meet certain conditions and to raise exceptions if the conditions are not met.
 * <p/>
 * Typical usage:<br/>
 * &nbsp;&nbsp;Validation.begin().notNull(myParameter,"myParameterName").check();
 * <p/>
 * This verifies that myParameter is not null, throwing a
 * ParameterException if it is. Validation is intended specifically for checking method parameters.
 * 
 * @author Matthew L. Maurer maurer.it@gmail.com
 */
public final class Validation
{
	public static final Validation	INSTANCE	= new Validation();
	private List<ParameterException>	exceptions;

	private Validation ( ) {
		this.exceptions = new ArrayList<ParameterException>();
	}
	
	private Validation addException ( ParameterException exception ) {
		this.exceptions.add(exception);
		return this;
	}

	/**
	 * Begins the validation process by returning the singleton validation object.
	 * 
	 * @return
	 */
	public static Validation begin ( ) {
		return INSTANCE;
	}

	/**
	 * Throws RangeException if 'aDouble' is not greater than 'minimum'; otherwise, does nothing.
	 * 
	 * @param aDouble
	 * @param minimum
	 * @param parameterName
	 * @return
	 */
	public Validation greaterThan ( double aDouble, double minimum, String parameterName ) {
		if ( !( aDouble > minimum ) ) {
			return failedCheck(parameterName, aDouble, parameterName + " was not greater than: " + minimum + "!");
		}
		else {
			return this;
		}
	}

	/**
	 * Throws RangeException if 'anInt' is not greater than 'minimum'; otherwise, does nothing.
	 * 
	 * @param anInt
	 * @param minimum
	 * @param parameterName
	 * @return
	 */
	public Validation greaterThan ( int anInt, int minimum, String parameterName ) {
		if ( !( anInt > minimum ) ) {
			return failedCheck(parameterName, anInt, parameterName + " was not greater than: " + minimum + "!");
		}
		else {
			return this;
		}
	}

	/**
	 * Identical to isTrue, except the test is inverted.
	 * 
	 * @param generalTest
	 * @param message
	 * @return
	 */
	public Validation isFalse ( boolean generalTest, java.lang.String message, String parameterName ) {
		if ( generalTest ) {
			return failedCheck(parameterName, generalTest, message);
		}
		else {
			return this;
		}
	}

	/**
	 * Throws IllegalArgumentException if 'generalTest' is false; otherwise, does nothing.
	 * 
	 * @param generalTest
	 * @param message
	 * @return
	 */
	public Validation isTrue ( boolean generalTest, java.lang.String message, String parameterName ) {
		if ( !generalTest ) {
			return failedCheck(parameterName, generalTest, message);
		}
		else {
			return this;
		}
	}

	/**
	 * Throws RangeException if 'aDouble' is not less than 'maximum'; otherwise, does nothing.
	 * 
	 * @param aDouble
	 * @param maximum
	 * @param parameterName
	 * @return
	 */
	public Validation lessThan ( double aDouble, double maximum, String parameterName ) {
		if ( !( aDouble < maximum ) ) {
			return failedCheck(parameterName, aDouble, parameterName + " must be less than: " + maximum + "!");
		}
		else {
			return this;
		}
	}

	/**
	 * Throws RangeException if 'anInt' is not less than 'maximum'; otherwise, does nothing.
	 * 
	 * @param anInt
	 * @param maximum
	 * @param parameterName
	 * @return
	 */
	public Validation lessThan ( int anInt, int maximum, String parameterName ) {
		if ( !( anInt < maximum ) ) {
			return failedCheck(parameterName, anInt, parameterName + " must be less than: " + maximum + "!");
		}
		else {
			return this;
		}
	}

	/**
	 * Throws RangeException if 'aDouble' is greater than 'maximum'; otherwise, does nothing.
	 * 
	 * @param aDouble
	 * @param maximum
	 * @param parameterName
	 * @return
	 */
	public Validation noGreaterThan ( double aDouble, double maximum, String parameterName ) {
		if ( aDouble > maximum ) {
			return failedCheck(parameterName, aDouble, parameterName + " should be no greater than: " + maximum + "!");
		}
		else {
			return this;
		}
	}

	/**
	 * Throws RangeException if 'anInt' is greater than 'maximum'; otherwise, does nothing.
	 * 
	 * @param anInt
	 * @param maximum
	 * @param parameterName
	 * @return
	 */
	public Validation noGreaterThan ( int anInt, int maximum, String parameterName ) {
		if ( anInt > maximum ) {
			return failedCheck(parameterName, anInt, parameterName + " should be no greater than: " + maximum + "!");
		}
		else {
			return this;
		}
	}

	/**
	 * Throws RangeException if 'aDouble' is less than 'minimum'; otherwise, does nothing.
	 * 
	 * @param anInt
	 * @param minimum
	 * @param parameterName
	 * @return
	 */
	public Validation noLessThan ( int anInt, int minimum, String parameterName ) {
		if ( anInt < minimum ) {
			return failedCheck(parameterName, anInt, parameterName + " should be no less than: " + minimum + "!");
		}
		else {
			return this;
		}
	}

	/**
	 * Throws RangeException if 'anInt' is less than 'minimum'; otherwise, does nothing.
	 * 
	 * @param aDouble
	 * @param minimum
	 * @param parameterName
	 * @return
	 */
	public Validation noLessThan ( double aDouble, double minimum, String parameterName ) {
		if ( aDouble < minimum ) {
			return failedCheck(parameterName, aDouble, parameterName + " should be no less than: " + minimum + "!");
		}
		else {
			return this;
		}
	}

	/**
	 * Throws IllegalArgumentException if 'anObject' is null; otherwise, does nothing.
	 * 
	 * @param theObject
	 * @param parameterName
	 * @return
	 */
	public Validation notNull ( Object theObject, String parameterName ) {
		if ( theObject == null ) {
			return failedCheck(parameterName, theObject, parameterName + " can not be null!");
		}
		else {
			return this;
		}
	}

	/**
	 * Throws IllegalArgumentException if 'aString' is null or if 'aString' is an empty string; otherwise, does nothing.
	 * 
	 * @param aString
	 * @param parameterName
	 * @return
	 */
	public Validation notEmpty ( java.lang.String aString, String parameterName ) {
		if ( aString != null && !aString.isEmpty() ) {
			return failedCheck(parameterName, aString, parameterName + " can not be null or empty!");
		}
		else {
			return this;
		}
	}
	
	/**
	 * TODO: Implement Me
	 * <p/>
	 * Throws RangeException if 'aRange' is not completely between 'minimum' and 'maximum', inclusive; otherwise, does nothing.
	 * 
	 * @param aRange
	 * @param minimum
	 * @param maximum
	 * @param parameterName
	 * @return
	 */
	public Validation rangeWithinBounds(Range aRange, int minimum, int maximum, String parameterName) {
		return this;
	}
	
	/**
	 * TODO: Implement Me
	 * <p/>
	 * Throws RangeException if 'aRange' is not completely within a sequence that starts at 0 and has a length of 'count'; otherwise does nothing.
	 * 
	 * @param aRange
	 * @param count
	 * @param parameterName
	 * @return
	 */
	public Validation rangeWithinCount(Range aRange, int count, String parameterName) {
		return this;
	}
	
	/**
	 * TODO: Implement Me
	 * <p/>
	 * Checks a string and a range which is intended to indicate a substring.
	 * 
	 * @param aRange
	 * @param aString
	 * @param parameterName
	 * @return
	 */
	public Validation rangeWithinString(Range aRange, java.lang.String aString, String parameterName) {
		return this;
	}

	/**
	 * TODO: Implement Me
	 * <p/>
	 * Throws {@link RangeException} if 'anInt' is not within a sequence that starts at 0 and has a length of 'count';
	 * otherwise does nothing.
	 * 
	 * @param anInt
	 * @param count
	 * @param parameterName
	 * @return
	 */
	public Validation withinCount ( int anInt, int count, String parameterName ) {
		return this;
	}

	/**
	 * TODO: Implement Me
	 * <p/>
	 * Throws RangeException if 'aDouble' is less than 'minimum' or greater than 'maximum'; otherwise, does nothing.
	 * 
	 * @param aDouble
	 * @param minimum
	 * @param maximum
	 * @param parameterName
	 * @return
	 */
	public Validation withinRange ( double aDouble, double minimum, double maximum, String parameterName ) {
		return this;
	}

	/**
	 * TODO: Implement Me
	 * <p/>
	 * Throws RangeException if 'anInt' is less than 'minimum' or greater than 'maximum'; otherwise, does nothing.
	 * 
	 * @param anInt
	 * @param minimum
	 * @param maximum
	 * @param parameterName
	 * @return
	 */
	public Validation withinRange ( int anInt, int minimum, int maximum, String parameterName ) {
		return this;
	}

	/**
	 * TODO: Implement Me
	 * <p/>
	 * Throws RangeException if 'anInt' is not within 'aRange'; otherwise, does nothing.
	 * 
	 * @param anInt
	 * @param aRange
	 * @param parameterName
	 * @return
	 */
	public Validation withinRange ( int anInt, Range aRange, String parameterName ) {
		return this;
	}
	
	/**
	 * Causes the stored exceptions which were generated during validation to be thrown. This is one of either
	 * {@link ParameterException} or {@link MultiParameterException}.
	 * 
	 * @return
	 * @throws ParameterException
	 *             If only one call to any of the methods were called that caused a validation problem.
	 * @throws MultiParameterException
	 *             If 2 or more calls to any of the methods were called that caused validation problems.
	 */
	public Validation check ( ) throws ParameterException, MultiParameterException {
		if ( this.exceptions.isEmpty() ) {
			return this;
		}
		else {
			if ( this.exceptions.size() > 1 ) {
				throw new MultiParameterException(this.exceptions.toArray(new ParameterException[ 0 ]));
			}
			else {
				throw this.exceptions.get(0);
			}
		}
	}

	/**
	 * Private convenience method for either building a new validation object for further chaining or simply adding the
	 * new ParameterException to the list of already built up exceptions. Without this... this class would be way to big
	 * and unmanagable!
	 * 
	 * @param parameterName
	 * @param parameter
	 * @param failedMessage
	 * @return
	 */
	private Validation failedCheck ( String parameterName, Object parameter, String failedMessage ) {
		Validation validation = this;
		
		if ( this.exceptions.isEmpty() ) {
			validation = new Validation();
		}
		
		validation.addException(new ParameterException(parameterName, parameter, failedMessage));
		return validation;
	}
}
