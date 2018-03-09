package com.example.demo;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import javax.validation.Valid;

import org.springframework.beans.factory.BeanExpressionException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.aspects.VinylAspect;
import com.example.demo.components.CdPlayer;
import com.example.demo.components.ConditionalComponent;
import com.example.demo.components.DvdPlayer;
import com.example.demo.components.VinylDiscPlayer;
import com.example.demo.components.impl.CdPlayerImpl;
import com.example.demo.components.impl.DvdPlayerImpl;
import com.example.demo.components.impl.ParamCdPlayerImpl;

@RestController
public class HelloController {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	@Qualifier("old")
	private CdPlayer oldCdPlayer;
	
	@Autowired
	@Qualifier("param")
	private CdPlayer paramCdPlayer;
	
	@Autowired
	@Qualifier("another_param")
	private CdPlayer anotherParamCdPlayer;
	
	@Autowired
	private VinylDiscPlayer vinylDiscPlayer;
	
	@Autowired VinylAspect vinylAspect;
	
//	@Autowired
//	@Qualifier("old")
//	private CdPlayer oldCdPlayer2;

	@RequestMapping("/hello")
	public String hello(@RequestParam int trackid) {
		
		String msg = "Empty";
		
//		CdPlayer cdPlayer = (CdPlayer) context.getBean(CdPlayerImpl.class);	//Albo klasa konkretnej implemetacji interface'u
//		DvdPlayer dvdPlayer = (DvdPlayer) context.getBean(DvdPlayer.class);	//Albo interface	
//		
//		try {
//		ConditionalComponent conditionalComp = (ConditionalComponent) context.getBean(ConditionalComponent.class);
//		if(conditionalComp != null)
//			msg = conditionalComp.say();
//		}catch (NoSuchBeanDefinitionException e) {
//			msg = e.getMessage();		
//		}
//		return msg;
		msg = vinylDiscPlayer.playVinylNo(trackid) + "Ilość odtworzeń: "+ vinylAspect.getTrackNumber(trackid); 
		return msg;
		//return anotherParamCdPlayer.playInsertedDisc();
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/postrequest/{sClass}", method=RequestMethod.POST) public ResponseEntity edit(@PathVariable("sClass") String sClass, @RequestBody @Valid String string, BindingResult result) { 
		if (result.hasErrors()) { 
			return new ResponseEntity(HttpStatus.BAD_REQUEST); 
			} 
		return new ResponseEntity(sClass+": "+string, new HttpHeaders(), HttpStatus.OK); 
	}
}
