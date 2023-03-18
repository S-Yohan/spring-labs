package com.revature.L1_calculator.Components;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO: Modify this class so that it functions as a component within the Spring Framework.
 *
 * The current functionality of the ArtApplication requires the "Squarer" class to be retrieved from the ArtApplication
 * Context - which you can think of as the current pool of usable Spring Beans. In order for this class to be contained
 * within the ArtApplication Context, several things need to happen:

 * 1, the configuration of this class should be provided using the @Bean annotation in the Configuration class,
 * which in this case is ArtApplication.java.
 * 2, because this class is dependent on Multiplier, a Multiplier bean should be Autowired into this class. Look into
 * how the Multiplier can be autowired in (there are 3 different ways!)
 *
 * Refer to the other classes on how to accomplish these 3 things!
 */
public class Squarer {
    /**
     * TODO: Autowire this field
     */
    @Autowired
    Multiplier multiplier;

    /**
     * Leverage the Multiplier dependency to multiply a value with itself.
     * This will only work if Multiplier was successfully autowired into this class.
     * @param value some number
     * @return value^2
     */
    public double getSquare(double value){
        return multiplier.multiply(value, value);
    }
}
