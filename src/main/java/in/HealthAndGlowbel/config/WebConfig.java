package in.HealthAndGlowbel.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author B Shashidhar
 *
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "in.HealthAndGlowbel.controller" })
public class WebConfig extends WebMvcConfigurationSupport   {

}