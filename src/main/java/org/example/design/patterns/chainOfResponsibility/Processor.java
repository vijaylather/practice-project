package org.example.design.patterns.chainOfResponsibility;

public class Processor {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    private final Processor nextProcessor;

    Processor (Processor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void log(int logLevel, String message) {
        if (nextProcessor != null) {
            nextProcessor.log(logLevel, message);
        }
    }
}
