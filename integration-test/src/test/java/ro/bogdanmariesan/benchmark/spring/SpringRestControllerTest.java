package ro.bogdanmariesan.benchmark.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ro.bogdanmariesan.benchmark.BaseRestTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by bogdan.mariesan on 1/26/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringTestConfig.class})
@WebAppConfiguration
public class SpringRestControllerTest extends BaseRestTest {


    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext applicationContext;


    @Before
    public void onBefore() {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    public void whenIMakeAGetRequestOnTheSpringBenchmarkControllerItShouldBeAccessible() throws Exception {
        MvcResult restCallResult = mockMvc.perform(get("/benchmark")).andExpect(status().isOk()).andReturn();

        assertNotNull(restCallResult.getResponse());
        assertNotNull(restCallResult.getResponse().getContentAsString());
        assertTrue(restCallResult.getResponse().getContentAsString().contains("<genericResponse/>"));
    }

    @Test
    public void performanceSuiteOneUserOneRequest() throws Exception {
        benchmarkGetRequest(mockMvc);
    }

    @Test
    public void performanceSuiteFourUsersHalfMillionRequests() throws InterruptedException {
        benchmarkGetRequest(FOUR_USERS, HALF_MILLION_REQUESTS, mockMvc);
        System.out.println("Spring REST total execution time in milliseconds: " + totalExecutionTime.doubleValue());
        System.out.println("Spring REST average execution time in milliseconds: " + totalExecutionTime.doubleValue() / HALF_MILLION_REQUESTS);
    }


}