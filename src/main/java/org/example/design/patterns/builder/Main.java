package org.example.design.patterns.builder;

public class Main {
    public static void main(String args[]) {
        HttpClient client = new HttpClient.Builder().url("some url").timeout(10).build();
    }
}
