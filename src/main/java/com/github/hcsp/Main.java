package com.github.hcsp;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Main {
<<<<<<< HEAD
    public static void main(String[] args) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("https://sina.cn/");
            try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
                System.out.println(response1.getStatusLine());
                HttpEntity entity1 = response1.getEntity();
                System.out.print( EntityUtils.toString(entity1));
=======
    public static void main(String[] args) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://httpbin.org/get");
            // The underlying HTTP connection is still held by the response object
            // to allow the response content to be streamed directly from the network socket.
            // In order to ensure correct deallocation of system resources
            // the user MUST call CloseableHttpResponse#close() from a finally clause.
            // Please note that if response content is not fully consumed the underlying
            // connection cannot be safely re-used and will be shut down and discarded
            // by the connection manager.
            try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
                System.out.println(response1.getCode() + " " + response1.getReasonPhrase());
                HttpEntity entity1 = response1.getEntity();
                // do something useful with the response body
                // and ensure it is fully consumed
                EntityUtils.consume(entity1);
            } catch (IOException e) {
                e.printStackTrace();
>>>>>>> 692831fd5c487a90367f178821c83a34bef962c9
            }
        }
    }
}
