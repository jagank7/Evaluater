package com.evaluator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.evaluator.dao.MongoClientWrapper;
import com.evaluator.dao.SolutionsDao;
import com.evaluator.dao.impl.SolutionsDaoImpl;
import com.evaluator.service.impl.SolutionsImpl;

/**
 * This class is responsible for application configuration and bean injection
 * 
 * @author Jagan
 * @version 1.0
 */
@Configuration
//@PropertySource(value = {"classpath:application.properties"})
public class AppConfig {

	@Value("${db.dev.mongo.host}")
	private String dbHost;

	@Value("${db.dev.mongo.port}")
	private int dbPort;

	@Value("${db.dev.mongo.connection.pool}")
	private int dbConnPool;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		// class is responsible to evaluate @Value and ${} placeholders in the code
		PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
		p.setIgnoreResourceNotFound(true);
		return p;
	}
	
	@Bean
	public MongoClientWrapper getMongoClientWrapper(){
		return new MongoClientWrapper(dbHost, dbPort, dbConnPool);
	}
	
	@Bean
	public SolutionsDaoImpl getSolutionDao(MongoClientWrapper mongoClient){
		return new SolutionsDaoImpl(mongoClient);
	}
	
	@Bean
	public SolutionsImpl getSolutions(SolutionsDao dao){
		return new SolutionsImpl(dao);
	}
	
	//@Bean
	//public EditorController getEditorController(Solutions solutions){
	//	return new EditorController(solutions);
	//}
}
