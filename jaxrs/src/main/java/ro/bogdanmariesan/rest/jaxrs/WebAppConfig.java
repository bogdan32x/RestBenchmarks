package ro.bogdanmariesan.rest.jaxrs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by bogdan.mariesan on 1/24/2015.
 */
@Configuration
@ComponentScan("ro.bogdanmariesan.rest.jaxrs.controller")
public class WebAppConfig {

    @Bean
    public MappingJackson2HttpMessageConverter jsonConverter() {
        return new MappingJackson2HttpMessageConverter();
    }
}
