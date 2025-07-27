package org.example.design.patterns.chainOfResponsibility;

public class InfoProcessor extends Processor{

    InfoProcessor (Processor nextProcessor) {
        super(nextProcessor);
    }

    public void log (int logLevel, String message) {
        if (logLevel == Processor.INFO) {
            System.out.println("INFO : " + message);
        }
        else{
            super.log(logLevel, message);
        }
    }
}
