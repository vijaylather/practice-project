package org.example.design.patterns.chainOfResponsibility;


public class Main {
    public static void main(String[] args) {
        Processor logProcessor = new InfoProcessor(new DebugProcessor( new ErrorProcessor(null)));
        logProcessor.log(Processor.INFO, "this is an info message");
        logProcessor.log(Processor.DEBUG, "this is an debug message");
        logProcessor.log(Processor.ERROR, "this is an error message");
    }
}
