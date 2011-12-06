package net.maurerit;

import net.maurerit.validation.ListExtensionsTest;
import net.maurerit.validation.StringExtensionsTest;
import net.maurerit.validation.ValidationTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yet.another.javapackage.ListExtensionsOutsidePackageTest;

@RunWith(Suite.class)
@SuiteClasses({ ListExtensionsTest.class,
				ValidationTest.class,
				ListExtensionsOutsidePackageTest.class,
				StringExtensionsTest.class,
				ListExtensionsOutsidePackageTest.class})
public class AllTests {

}
