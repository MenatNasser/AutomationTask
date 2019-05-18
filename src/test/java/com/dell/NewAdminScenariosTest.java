package com.dell;

import com.dell.Pages.DashboardPage;
import com.dell.Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
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
        Dimension d = new Dimension(1024,768);
        //Resize the current window to the given dimension
        driver.manage().window().setSize(d);
    }

    //First case: Authenticating new admin
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

    //Second case: Adding new location by new admin
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
        dashboardPage.submitLocationBtn.click();
        assertTrue(dashboardPage.changesSavedNotification().isDisplayed());
    }
/*
    //Third case: Editing new location by new admin
    @Test
    public void editNewLocation() {
        assertTrue(dashboardPage.accountList.isDisplayed());
        dashboardPage.locationList.click();
        dashboardPage.locationPage.click();
        assertTrue(dashboardPage.addLocationBtn.isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'Egypt')]")));
        assertTrue(dashboardPage.editLocationBtn.isDisplayed());
        dashboardPage.editLocationBtn.click();
        dashboardPage.locationRuName.sendKeys("Russia");
        dashboardPage.locationFaName.sendKeys("Farsi");
        dashboardPage.locationFrName.sendKeys("French");
        dashboardPage.locationTrName.sendKeys("Turkish");
        dashboardPage.locationEsName.sendKeys("Espanol");
        dashboardPage.submitBtn.click();
        assertTrue(dashboardPage.changesSavedNotification().isDisplayed());
    }

    //Fourth case: Editing new location by new admin
    @Test
    public void deleteNewLocation() {
        assertTrue(dashboardPage.accountList.isDisplayed());
        dashboardPage.locationList.click();
        dashboardPage.locationPage.click();
        assertTrue(dashboardPage.addLocationBtn.isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'Egypt')]")));
        assertTrue(dashboardPage.editLocationBtn.isDisplayed());
        dashboardPage.deleteLocationBtn.click();
        //Assert on delete message
        //assertTrue(deleteErrormessage.isDisplayed());
    }
*/
    @After
    public void tearDown() throws Exception {
        dashboardPage.postStop();
    }

}
