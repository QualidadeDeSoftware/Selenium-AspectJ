package br.com.uol.media.configuration;

import junit.framework.TestCase;

import org.junit.Ignore;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
 
@Ignore
public abstract class SeleniumTestCase extends TestCase {
 
	protected static Selenium selenium;
 
	@Override
	protected void setUp() throws Exception {
		super.setUp();
        selenium = new DefaultSelenium(
        		"localhost", 
        		4444, 
        		"*firefox", 
        		"http://www.radio.uol.com.br/");
        selenium.start();
        selenium.windowFocus();
        selenium.windowMaximize();
	}
 
    @Override
    protected void tearDown() throws Exception {
    	selenium.stop();
    	super.tearDown();
    }

}
