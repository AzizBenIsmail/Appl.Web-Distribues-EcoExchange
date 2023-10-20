package com.spring.boot;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Aspect
@Slf4j
@Component
public class LoggingAspect {
	
	  @Pointcut("execution(* com.spring.boot.services.*.*(..))")
	    public void loggingPointCut(){}

	
//	    @Around("loggingPointCut()")
//	    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
//	    long start = System.currentTimeMillis();
//	    Object obj = pjp.proceed();
//	    long elapsedTime = System.currentTimeMillis() - start;
//	    log.info("Method execution time: " + elapsedTime + " milliseconds.");
//	    return obj;
//	    }
	
	
	  	@After("execution(* com.exam.services.*.*(..))")
		public void logMethodEntry(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println("In method  :" +name );
		}
		
//		@Before("execution(* com.exam.services.*.*(..))")
//		public void logMethodEntry1(JoinPoint joinPoint) {
//		String name = joinPoint.getSignature().getName();
//		System.out.println("In method  :" +name );
//		}
	
	
	
	

}
