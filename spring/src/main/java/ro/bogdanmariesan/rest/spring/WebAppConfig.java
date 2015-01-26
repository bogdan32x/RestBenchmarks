package ro.bogdanmariesan.rest.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by bogdan.mariesan on 1/24/2015.
 */
@Configuration
@EnableWebMvc
@ComponentScan("ro.bogdanmariesan.rest.spring.controller")
public class WebAppConfig {

    @Bean
    public MappingJackson2HttpMessageConverter jsonConverter() {
        return new MappingJackson2HttpMessageConverter();
    }
}
