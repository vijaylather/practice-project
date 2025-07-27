package org.example.design.patterns.chainOfResponsibility;

public class ErrorProcessor extends Processor {

    ErrorProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }

    public void log(int logLevel, String message) {
        if(logLevel == Processor.ERROR) {
            System.out.println("ERROR : " + message);
        }
        else{
            super.log(logLevel, message);
        }
    }
}
