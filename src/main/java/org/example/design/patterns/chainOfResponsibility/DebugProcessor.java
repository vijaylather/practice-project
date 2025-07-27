package org.example.design.patterns.chainOfResponsibility;

public class DebugProcessor extends Processor {

    DebugProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }

    public void log(int logLevel, String message) {
        if (logLevel == Processor.DEBUG) {
            System.out.println("DEBUG : " + message);
        }
        else{
            super.log(logLevel, message);
        }
    }
}
