Parameter Validation API
========================

An easy to use Method Parameter Validation API using a fluent style approach for easily validating
multiple parameters with as little code as possible.

Think of the following:

```java
Validation.begin()
          .notNull(parameter,"parameter name")
          .notEmpty(string,"string name")
          .check()
          // ^ will throw a ParameterException/MultiParameterException if previous
          // calls failed their check conditions.
```

This library relies on lombok-pg to easily extend the Validation class with more useful methods
without increasing the size of the code within Validation.java.  This approach offers the ability
for users of this library to further enhance the Validation class by implementing their own
validation methods using method extensions.