package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * The @SpringBootApplication annotation is equivalent to using  @Configuration, @EnableAutoConfiguration and @ComponentScan with their default attributes: [...]
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.example.demo.aspects.CdAspect;
import com.example.demo.aspects.VinylAspect;
import com.example.demo.coditions.MagicExistsCondition;
import com.example.demo.components.CdPlayer;
import com.example.demo.components.DvdPlayer;
import com.example.demo.components.impl.ConditionalComponentImpl;
import com.example.demo.components.impl.DvdPlayerImpl;
import com.example.demo.components.impl.DvdPlayerProdImpl;
import com.example.demo.components.impl.ParamCdPlayerImpl;


@SpringBootApplication
@EnableAspectJAutoProxy
public class Test1Application {
	
	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(Test1Application.class, args);
	}
	
	@Bean
	@Profile("dev")
	public DvdPlayer getDvdPlayer() {
		return new DvdPlayerImpl();
	}
	
	@Bean
	@Profile("prod")
	public DvdPlayer getProdDvdPlayer() {
		return new DvdPlayerProdImpl();
	}
	
	@Bean
	@Conditional(MagicExistsCondition.class)
	public ConditionalComponentImpl getConditionalComp() {
		return new ConditionalComponentImpl();
	}
	
	@Bean
	@Qualifier("param")
	public CdPlayer getParamPlayer() {
		return new ParamCdPlayerImpl(env.getProperty("magic", "default val"));
	}
	
	@Bean
	public CdAspect getCdAspect() {
		return new CdAspect();
	}
	
	@Bean
	public VinylAspect getVinylAspect() {
		return new VinylAspect();
	}
}
