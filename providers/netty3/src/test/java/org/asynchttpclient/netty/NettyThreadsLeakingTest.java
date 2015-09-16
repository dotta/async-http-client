package org.asynchttpclient.netty;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.AsyncHttpClientConfig;
import org.asynchttpclient.ThreadsLeakingTest;

public class NettyThreadsLeakingTest extends ThreadsLeakingTest {
    @Override
    public AsyncHttpClient getAsyncHttpClient(AsyncHttpClientConfig config) {
        return NettyProviderUtil.nettyProvider(config);
    }
}
