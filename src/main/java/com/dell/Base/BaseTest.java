package com.dell.Base;

import org.openqa.selenium.WebDriver;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// This Class to init the driver and load config properties
public abstract class BaseTest {

    public WebDriver driver;
    public Properties properties;

    public BaseTest(WebDriver driver) {
        this.driver = driver;
        init();
    }

    /**
     * Init the properties
     * load config file
     */
    public void init() {
        properties = new Properties();
        // try with resource //
        try (InputStream input = new FileInputStream("src/main/resources/Config.properties")) {
            // load a properties file
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * Run after each case
     */
    public void postStop() {
        driver.close();
        driver.quit();
    }

}

