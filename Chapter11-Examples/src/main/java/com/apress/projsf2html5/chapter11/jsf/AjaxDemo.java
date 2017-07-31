package com.apress.projsf2html5.chapter11.jsf;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "ajaxDemo")
@SessionScoped
public class AjaxDemo implements Serializable {

    private String outputMessage = "";

    public String getOutputMessage() {
        return outputMessage;
    }

    public void setOutputMessage(String outputMessage) throws InterruptedException {
        // Simulate waiting time
        Thread.sleep(200);
        this.outputMessage = outputMessage;
    }
}
