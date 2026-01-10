package org.example.design.patterns.builder;

import java.util.HashMap;

public class HttpClient {
    private String url;
    private HashMap<String, String> header;
    private int timeout;
    private HttpClient() {

    }
    public static class Builder {
        private HttpClient httpClient = new HttpClient();

        public Builder url(String url) {
            httpClient.url = url;
            return this;
        }

        public Builder header(String key, String value) {
            if(httpClient.header == null){
                httpClient.header = new HashMap<>();
            }
            httpClient.header.put(key,value);
            return this;
        }

        public Builder timeout(int timeout) {
            httpClient.timeout = timeout;
            return this;
        }

        public HttpClient build() {
            return httpClient;
        }
    }
}
