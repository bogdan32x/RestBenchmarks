package ro.bogdanmariesan.benchmark;

import org.springframework.test.web.servlet.MockMvc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by batman on 26.01.2015.
 */
public class BaseRestTest {

    protected static final int FOUR_USERS = 4;
    protected static final int HALF_MILLION_REQUESTS = 500000;
    protected static final AtomicLong totalExecutionTime = new AtomicLong(0);

    protected void benchmarkGetRequest(final MockMvc mockMvc) throws Exception {

        executeGetBenchmark(mockMvc);


        System.out.println("Total execution time: " + totalExecutionTime.doubleValue() / 1000 + " seconds");
    }

    private void executeGetBenchmark(final MockMvc mockMvc) throws Exception {
        long startTime = System.currentTimeMillis();
        mockMvc.perform(get("/benchmark")).andExpect(status().isOk()).andReturn();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        totalExecutionTime.addAndGet(duration);
    }

    protected void benchmarkGetRequest(final int numberOfUsers, final int numberOfRequests, final MockMvc mockMvc) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(numberOfRequests);
        final ExecutorService executorService = Executors.newFixedThreadPool(numberOfUsers);

        for (int i = 0; i < numberOfRequests; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        executeGetBenchmark(mockMvc);
                        latch.countDown();
                    } catch (final Exception e) {
                        System.out.println("Execution failed with cause: " + e.getMessage());
                    }
                }
            });
        }
        latch.await();
    }
}
