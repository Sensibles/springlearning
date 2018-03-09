package com.example.demo.aspects;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.*;

import com.example.demo.components.AdditionalAopInterface;
import com.example.demo.components.impl.AdditionalAopInterfaceImpl;

import ch.qos.logback.core.pattern.color.MagentaCompositeConverter;

@Aspect
public class VinylAspect {
	
	HashMap<Integer, Integer> countMap = new HashMap<>(); 
	
	@DeclareParents(value="com.example.demo.components.VinylDiscPlayer+",
			defaultImpl=AdditionalAopInterfaceImpl.class)
	public static AdditionalAopInterface addAop;
	
	@Pointcut("execution(** com.example.demo.components.VinylDiscPlayer.playVinylNo(int)) " + 
			" && args(trackNumber)")
	public void pVinylDisc(int trackNumber) {}
	
	@Before("pVinylDisc(trackNumber)")
	public void beforePlay(int trackNumber) {
		addAop.doSomething();
		countMap.put(trackNumber, (getTrackNumber(trackNumber)+1));
		
	}
	
	public int getTrackNumber(int trackNumber) {
		if(!countMap.containsKey(trackNumber)) 
			countMap.put(trackNumber, 0);			
		return countMap.get(trackNumber);
		
			
	}
	
	

}
