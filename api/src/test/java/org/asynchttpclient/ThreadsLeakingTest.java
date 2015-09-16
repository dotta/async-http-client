package org.asynchttpclient;

import org.testng.annotations.Test;

public abstract class ThreadsLeakingTest extends AbstractBasicTest {

    protected static int NUMBER_OF_ITERATIONS = 200;
    
    @Test(groups = { "standalone", "default_provider" })
    public void testThreadsLeaking() throws Exception {
        // this test currently only fails with the netty4 provider with the following exception:
        // java.lang.OutOfMemoryError: unable to create new native thread
        int i = 0; 
        while (i < NUMBER_OF_ITERATIONS) {
            i++;
            try (AsyncHttpClient ahc = getAsyncHttpClient(
                    new AsyncHttpClientConfig.Builder().setMaxRequestRetry(0).build())) {
                // do nothing
            }
        }
    }
}
