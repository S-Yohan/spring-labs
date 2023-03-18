package com.revature.L1_calculator;

import com.revature.L1_calculator.Components.Adder;
import com.revature.L1_calculator.Components.Multiplier;
import com.revature.L1_calculator.Components.Squarer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * This class has been marked as a Configuration class. This means that Spring will use this class to define
 * exactly how the Spring Beans should be created. Beans are objects managed by the Spring Framework.
 * Typically, the main method is also written within the configuration class as well. See the main method and
 * @Bean annotated methods below.
 */
@Configuration
public class Application {

    /**
     * This main method will demonstrate how to start the Spring ArtApplication Context and how to pull beans
     * out of the Spring IOC (inversion-of-control) container.
     * There is no need to change anything within this class.
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Establish an ApplicationContext, which is the representation of the entire Spring IOC (inversion-of-control
         * container) - you can think of the ApplicationContext as the pool of Beans that your application can pull
         * from at any moment.
         *
         * The ApplicationContext extends an earlier implementation of the Spring IOC container called the BeanFactory.
         * The ApplicationContext generally has more functionality. Where the BeanFactory creates beans lazily, meaning
         * only when they are requested, the ApplicationContext creates beans eagerly, meaning on startup. This makes
         * it generally more powerful.
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        /**
         * Now let's pull some beans out of the Spring ArtApplication Context.
         */
        Adder adderBean = context.getBean(Adder.class);
        System.out.println("Got the adder bean. it says the result of 2+2="+adderBean.add(2,2));
        Multiplier multiplierBean = context.getBean(Multiplier.class);
        System.out.println("Got the multiplier bean. it says the result of 3*4="+multiplierBean.multiply(3,4));
        System.out.println("Now, if the squarer bean was properly set up, this should work ...");
        Squarer squarerBean = context.getBean(Squarer.class);
        System.out.println("Got the squarer bean. it says the result of 4^2="+squarerBean.getSquare(4));
    }

    /**
     * These 3 objects will be loaded as Beans within this class.
     */
    private Adder adder;
    private Multiplier multiplier;
    private Squarer squarer;

    /**
     * Using the @Bean annotation, we can write methods in the configuration class (class marked with @Configuration)
     * to specify exactly how Spring should instantiate a new bean. A method marked with @Bean should return the object
     * you intend for Spring to turn into a Bean. Now, whenever you retrieve an Object from the Spring Context,
     * Spring will use this method to provide it to you! Within these methods, any custom setup required to properly
     * set up the Bean can also be performed (such as setting fields.)
     *
     * A @Scope annotation has also been provided. Bean scopes change how the bean is created. Singleton is the
     * default, and it creates a single bean that is shared across the whole application, ie when a bean is requested
     * multiple times it returns the same Object. Prototype creates a new Object every time the bean is requested.
     * There are also several web-related scopes, like request, session, application, and websocket scopes.
     *
     * @return an Adder object, which will be used by Spring Framework as a Bean.
     */
    @Bean
    @Scope("singleton")
    public Adder getAdderBean(){
        return new Adder();
    }

    /**
     * @return an Adder object, which will be used by Spring Framework as a Bean.
     */
    @Bean
    @Scope("singleton")
    public Multiplier getMultiplierBean(){
        return new Multiplier();
    }
    /**
     * TODO: Write the @Bean configuration for Squarer here! Note that a Squarer relies on Multiplier as a dependency.
     */
    @Bean
    @Scope("singleton")
    public Squarer getSquarerBean() {return new Squarer();}
}
