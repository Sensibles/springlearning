package com.example.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;


@Aspect
public class CdAspect {
	
	@Pointcut("execution(** com.example.demo.components.CdPlayer.playInsertedDisc(..))")
	public void pInsertedDisc() {}
	
	
	@Before("pInsertedDisc()")
	public void beforePutCd() {
		System.out.println("Wkładanie nowej płyty");
	}
//	
//	@After("playInsertedDisc()")
//	public void afterPutCd() {
//		System.out.println("Wyciąganie płyty");
//	}
//	
	// ALBO
	
//	@Around("pInsertedDisc()")
//	public void aroudPlayCd(ProceedingJoinPoint jp) {
//		System.out.println("Wkładanie nowej płyty");
//		try {
//			jp.proceed();
//			System.out.println("Wyciąganie płyty");
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			System.out.println("Błąd płyty");
//			e.printStackTrace();			
//		}
//		
//	}
	

}
