package com.apress.projsf2html5.chapter11;

import com.apress.projsf2html5.chapter11.jsf.HelloYou;
import com.thoughtworks.selenium.DefaultSelenium;
import java.io.File;
import java.net.URL;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(Arquillian.class)
@RunAsClient
public class HelloYouTest {

    /** This will give us the contextPath where the web application was installed. */
    @ArquillianResource
    URL contextPath;
   
    /** This will give us access to a Drone that simulates a browser. */
    @Drone
    private DefaultSelenium browser;

    /**
     * The method annotated with Deployment outputs the web archive representing
     * the application.The archive must contain all the resource and classes
     * being tested.
     *
     * @return {@link WebArchive} containing the resources and classes
     * representing the Hello You application
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "hello-you.war")
                .addClasses(HelloYou.class)
                .addAsWebResource(new File("src/main/webapp/hello-you.xhtml"))
                .addAsWebResource(new File("src/main/webapp/contracts/basic/base.xhtml"), "contracts/basic/base.xhtml")
                .addAsWebResource(new File("src/main/webapp/contracts/basic/cssLayout.css"), "contracts/basic/cssLayout.css")
                .addAsWebResource(new File("src/main/webapp/contracts/basic/default.css"), "contracts/basic/default.css")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/web.xml"))
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    /**
     * Scenario: Entering my name.
     * Given that I enter my name ‘Clutch Powers’ on the page
     * When I press the Submit Button
     * Then I will be greeted ‘Hello Clutch Powers’ by the application
     */
    @Test
    public void helloyou_EnterName_GreetingFound() {
        String startUrl = contextPath.toString() + "faces/hello-you.xhtml";

        // Open the hello-you page
        browser.open(startUrl);

        // Type name in the input field
        browser.type("id=hello-form:input-name", "Clutch Powers");

        // Click the submit button
        browser.click("id=hello-form:submit");

        // Wait for the page to load (max 5 seconds)
        browser.waitForPageToLoad("5000");

        // Check that the "Hello <name>" element is displayed on screen
        assertTrue(browser.isVisible("id=hello-form:output-message"));

        // Chcek that the name entered is the one expected
        assertEquals("Welcome message missing",
                browser.getText("id=hello-form:output-message"),
                "Hello Clutch Powers");
    }
    
    /**
     * Scenario: I enter the page.
     * Given that I enter page 
     * When I do nothing
     * Then I there will be no greeting displayed
     */
    @Test
    public void helloyou_OpenPage_GreetingHidden() {
        String startUrl = contextPath.toString() + "faces/hello-you.xhtml";

        // Open the hello-you page
        browser.open(startUrl);

        // Check that the "Hello <name>" element is NOT displayed on the screen
        assertFalse(browser.isVisible("id=hello-form:output-message"));
    }
}
