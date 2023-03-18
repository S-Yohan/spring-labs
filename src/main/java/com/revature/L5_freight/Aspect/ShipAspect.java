package com.revature.L5_freight.Aspect;

import com.revature.L4_art.ArtApplication;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Spring AOP (aspect-oriented-programming) is a Spring module that addresses the problem of repetitive code in our
 * application.
 *
 * When a similar pattern of code is used across multiple methods in the application, it is a cross-cutting concern:
 * for instance, logging all web requests to a logging file, ensuring that a User is logged in before certain actions
 * can be performed, or starting and committing database transactions are all cross-cutting concerns, because they are
 * all some pattern of code that is applied across multiple parts of the application. AOP allows us to separate
 * these cross-cutting concerns into their own method, which can then be re-applied to the relevant methods by Spring.
 *
 * Because of this, AOP helps with code reuse, DRY (don't-repeat-yourself) principle, and allows for faster development
 * when the cross-cutting-concern needs to be modified.
 *
 * For the purpose of completing any challenges within this project: do not change anything within this class!
 * It is already complete.
 */
@Aspect
@Component
public class ShipAspect {
    /**
     * This method contains Advice, which is code that is applied as a cross-cutting-concern at a JoinPoint. A
     * JoinPoint is the actual location in the code where Advice is applied. The @Before is an Advice annotation:
     * it defines where the Advice should be applied. In this case, the println statement is Advice
     * that is applied before any method in ShipService executes. The expression provided to the Before annotation
     * is a pointcut expression, which defines which methods the Advice is applied to. More on Advice annotations and
     * Pointcut expressions below.
     *
     * @param joinPoint Object representing the position in the code where the Advice has been applied.
     */
    @Before("execution(* com.revature.L5_freight.Service.ShipService.*(..))")
    public void logBeforeShipServiceMethods(JoinPoint joinPoint){
        System.out.println("test1");
        ArtApplication.log.info("aop: log before method execution: "+joinPoint);
    }
    /**
     * This method contains Advice, which is code that is applied as a cross-cutting-concern at a JoinPoint. A
     * JoinPoint is the actual location in the code where Advice is applied. The @After is an Advice annotation:
     * it defines where the Advice should be applied. In this case, the println statement is Advice
     * that is applied after any method in ShipService executes. The expression provided to the After annotation
     * is a pointcut expression, which defines which methods the Advice is applied to. More on Advice annotations and
     * Pointcut expressions below.
     *
     * @param joinPoint Object representing the position in the code where the Advice has been applied.
     */
    @After("execution(* com.revature.L5_freight.Service.ShipService.*(..))")
    public void logAfterShipServiceMethods(JoinPoint joinPoint){
        System.out.println("test2");
        ArtApplication.log.info("aop: log after method execution: "+joinPoint);
    }
    /**
     * This method contains Advice, which is code that is applied as a cross-cutting-concern at a JoinPoint. A
     * JoinPoint is the actual location in the code where Advice is applied. The @After is an Advice annotation:
     * it defines where the Advice should be applied. In this case, the println statement is Advice
     * that is applied after any method in ShipService executes. The expression provided to the After annotation
     * is a pointcut expression, which defines which methods the Advice is applied to. More on Advice annotations and
     * Pointcut expressions below.
     *
     * @param joinPoint Object representing the position in the code where the Advice has been applied.
     */
    @AfterThrowing("execution(* com.revature.L5_freight.Service.ShipService.*(..))")
    public void logAfterShipServiceException(JoinPoint joinPoint){
        ArtApplication.log.warn("aop: exception thrown: "+joinPoint);
    }
    /**
     * Advice:
     * Advice is code that is applied as a cross-cutting-concern. Advice annotations define where the code is applied
     * to the methods matching the Pointcut expressions. The Advice annotations that can be used:
     * @Before - before the execution of the method
     * @After - after the execution of the method
     * @AfterReturning - after the method returns (ie completed with no exceptions thrown)
     * @AfterThrowing - after the method throws an exception
     * @Around - combination of @Before and @Around
     */

    /**
     * Pointcut expressions:
     * A pattern-matching expression that defines the methods that the Advice should apply to, where * is a single
     * wild card (eg apply to any class, any method) and .. is any amount of wildcards (eg apply to a method
     * with any amount of parameters). Pointcut expressions can also be used for pattern matching, for instance,
     * they could be written to apply Advice to any method whose name begins with "get" or any method that contains
     * "Painting", etc.
     */
}
