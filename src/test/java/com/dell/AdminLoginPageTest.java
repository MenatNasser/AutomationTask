package com.dell;

import com.dell.Pages.DashboardPage;
import com.dell.Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class AdminLoginPageTest {

    WebDriver driver;
    LoginPage loginPage;

    // This is to setup testing execution before each test case
    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

    }

    // First case: Successful login using correct credentials
    @Test
    public void successFullLoginWithCredentialsCase() {

        loginPage.emailField.sendKeys(loginPage.properties.getProperty("emailAdmin"));
        loginPage.passwordField.sendKeys(loginPage.properties.getProperty("passwordAdmin"));
        loginPage.rememebermeChk.click();
        loginPage.loginButton.click();

        //detecting login validation
        try {

            WebElement redirectionAlert = loginPage.redirectionMessage();
            assertTrue(redirectionAlert.isDisplayed());

        } catch (TimeoutException e) {
            System.out.println("TimeOut for alert-success " + e.getMessage());
            fail();
        }

        try {
            DashboardPage dashboardPage = loginPage.getDashboardPage();
            assertTrue(dashboardPage.logOutLink.isDisplayed());
            dashboardPage.logOutLink.click();

        } catch (TimeoutException e) {
            System.out.println("TimeOut for logout link" + e.getMessage());
            fail();
        }

    }

    //Second case : Wrong credentials entered
    @Test
    public void wrongCredentialsCase() {

        loginPage.emailField.sendKeys("me@test.com");
        loginPage.passwordField.sendKeys("mnoeee_1991");
        loginPage.loginButton.click();
        //Asserting on error message
        try {

            WebElement wrongCredErrorMsg = loginPage.getWrongCredErrorMsg();
            assertTrue(wrongCredErrorMsg.isDisplayed());
        } catch (TimeoutException e) {
            System.out.println("TimeOut");
            fail();
        }
    }

    //Third case: Verifying 'Forget password?' link
    @Test
    public void forgetPasswordCase() {
        //Checking existence of 'Forget password?' link
        try {
            loginPage.forgetPassworLnk.click();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("resetemail")));
            WebElement resetEmailField = driver.findElement(By.id("resetemail"));
            assertTrue(resetEmailField.isDisplayed());

        } catch (NoSuchElementException e) {
            System.out.println("Forget password not working " + e.getMessage());
            fail();
        }
    }

    //Fourth case: Invalid mail format
    @Test
    public void invalidEmailCase() {

        loginPage.emailField.sendKeys("metest.com");
        loginPage.passwordField.sendKeys(loginPage.properties.getProperty("passwordAdmin"));
        loginPage.loginButton.click();

        //Asserting on invalid mail error
        try {

            WebElement emailError = loginPage.getEmailFieldError();
            assertTrue(emailError.isDisplayed());

        } catch (TimeoutException e) {
            System.out.println("TimeOut");
            fail();
        }
    }

    // Fifth case: Special characters used in fields
    @Test
    public void invalidCase() {

        loginPage.emailField.sendKeys("!@#$%^%$");
        loginPage.passwordField.sendKeys("!@@");
        loginPage.loginButton.click();

        //Asserting for the errors
        try {

            WebElement emailError = loginPage.getEmailFieldError();
            assertTrue(emailError.isDisplayed());

        } catch (TimeoutException e) {
            System.out.println("TimeOut");
            fail();
        }
    }

    // This is to run after each case executed
    @After
    public void tearDown() throws Exception {
        loginPage.postStop();
    }
}
