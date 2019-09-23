//package pl.sii.ums.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Description;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
//
//@EnableWebMvc
//@Configuration
//@ComponentScan("pl.sii.ums")
//public class UmsConfig {
//	
//	@Bean
//	@Description("Thymeleaf Template Resolver")
//	public ServletContextTemplateResolver templateResolver() {
//	    ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(null);
//	    templateResolver.setPrefix("classpath:/templates/");
//	    templateResolver.setSuffix(".html");
//	    templateResolver.setTemplateMode("HTML5");
//	 
//	    return templateResolver;
//	}
//	 
//	@Bean
//	@Description("Thymeleaf Template Engine")
//	public SpringTemplateEngine templateEngine() {
//	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//	    templateEngine.setTemplateResolver(templateResolver());
//	   // templateEngine.setTemplateEngineMessageSource(messageSource());
//	    return templateEngine;
//	}
//	
//	@Bean
//	public ThymeleafViewResolver thymeleafViewResolver() {
//	    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//	    resolver.setTemplateEngine(new SpringTemplateEngine());
//	    resolver.setCharacterEncoding("UTF-8");
//	    return resolver;
//	}
//}
