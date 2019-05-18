package com.dell;

import com.dell.Pages.DashboardPage;
import com.dell.Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class NewAdminScenariosTest {
    WebDriver driver;
    DashboardPage dashboardPage;
    LoginPage loginPage;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        //1
        loginPage = new LoginPage(driver);
        //2
        loginPage.login(loginPage.properties.getProperty("newAdminEmail"), loginPage.properties.getProperty("newAdminPassword"));
        //3
        dashboardPage = loginPage.getDashboardPage();
    }

    @Test
    public void loginWithNewAdmin() {

        try {
            DashboardPage dashboardPage = loginPage.getDashboardPage();
            assertTrue(dashboardPage.logOutLink.isDisplayed());
            dashboardPage.logOutLink.click();

        } catch (TimeoutException e) {
            System.out.println("TimeOut for logout link" + e.getMessage());
            fail();
        }
    }

    @Test
    public void addNewLocation() {
        assertTrue(dashboardPage.locationList.isDisplayed());
        dashboardPage.locationList.click();
        dashboardPage.locationPage.click();
        assertTrue(dashboardPage.addLocationBtn.isDisplayed());
        dashboardPage.addLocationBtn.click();
        dashboardPage.locationCountry.click();
        WebElement countrySelected = driver.findElement(By.cssSelector("#select2-drop > ul > li:nth-child(48)"));
        countrySelected.click();
        //dashboardPage.locationCity.sendKeys("Test");
        dashboardPage.locationLongt.sendKeys("31.24967");
        dashboardPage.locationLatit.sendKeys("30.06263");
        assertTrue(dashboardPage.locationCity.isEnabled());
        dashboardPage.locationArName.sendKeys("منة");
        //dashboardPage.submitLocationBtn.click();
        //assertTrue(dashboardPage.changesSavedNotification().isDisplayed());
    }

    @After
    public void tearDown() throws Exception {
        //dashboardPage.postStop();
    }

}
