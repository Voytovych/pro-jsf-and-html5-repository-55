/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.projsf2html5.chapter11.jsf;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Allan Lykke Christensen
 */
@Named(value = "javaScriptApiDemo")
@SessionScoped
public class JavaScriptApiDemo implements Serializable {

    private int clicks = 0;
    private String myName = "unknown";

    /**
     * Creates a new instance of JavaScriptApiDemo
     */
    public JavaScriptApiDemo() {
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public void increaseClick() {
        System.out.println("Increased");
        clicks++;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }
}
