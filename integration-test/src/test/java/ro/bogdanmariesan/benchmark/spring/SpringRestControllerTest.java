package ro.bogdanmariesan.benchmark.spring;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import ro.bogdanmariesan.rest.jaxrs.WebAppConfig;
import ro.bogdanmariesan.rest.spring.ApplicationConfig;

/**
 * Created by bogdan.mariesan on 1/26/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringTestConfig.class})
public class SpringRestControllerTest {


    private MockMvc mockMvc;

}
