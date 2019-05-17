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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DashBordPageTest {

    // This is to setup testing execution before each test case

    WebDriver driver;
    DashboardPage dashboardPage;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        //1
        LoginPage loginPage = new LoginPage(driver);
        //2
        loginPage.login(loginPage.properties.getProperty("emailAdmin"),loginPage.properties.getProperty("passwordAdmin"));
        //3
        dashboardPage = loginPage.getDashboardPage();

        // flow to aconnt
        /*
         driver = new ChromeDriver();
        //1
        LoginPage loginPage = new LoginPage(driver);
        //2
        loginPage.login();
        //3
        dashboardPage = loginPage.getDashboardPage();

        acountPgae =dashboardPage.getAcountPage();

        ....
         */
    }

    @Test
    public void addNewAdmin()
    {
        assertTrue(dashboardPage.accountList.isDisplayed());
        dashboardPage.accountList.click();
        dashboardPage.adminPage.click();
        assertTrue(dashboardPage.addAdminBtn.isDisplayed());
        dashboardPage.addAdminBtn.click();
        dashboardPage.firstName.sendKeys("Admin");
        dashboardPage.lasttName.sendKeys("Test");
        dashboardPage.email.sendKeys("mennafortesting@gmail.com");
        dashboardPage.password.sendKeys("Menna13");
        dashboardPage.mobile.sendKeys("1234567");
        dashboardPage.country.click();
        WebElement countrySelected= driver.findElement(By.cssSelector("#select2-drop > ul > li:nth-child(6)"));
        countrySelected.click();
        dashboardPage.address1.sendKeys("Address 1");
        dashboardPage.address2.sendKeys("Address 2");
        dashboardPage.submitBtn.click();
        assertTrue(dashboardPage.changesSavedNotification().isDisplayed());
    }

    @Test
    public void editNewAdmin()
    {
        assertTrue(dashboardPage.accountList.isDisplayed());
        dashboardPage.accountList.click();
        dashboardPage.adminPage.click();
        assertTrue(dashboardPage.addAdminBtn.isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='https://www.phptravels.net/mailto:mennafortesting@gmail.com']")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'mennafortesting@gmail.com')]")));
        assertTrue(dashboardPage.editAdmin.isDisplayed());
        dashboardPage.editAdmin.click();
        dashboardPage.addLocation.click();
        dashboardPage.editLocation.click();
        dashboardPage.submitBtn.click();
        assertTrue(dashboardPage.changesSavedNotification().isDisplayed());
    }

    @Test
    public void leaveFormEmpty ()
    {
        assertTrue(dashboardPage.accountList.isDisplayed());
        dashboardPage.accountList.click();
        dashboardPage.adminPage.click();
        assertTrue(dashboardPage.addAdminBtn.isDisplayed());
        dashboardPage.addAdminBtn.click();
        dashboardPage.submitBtn.click();
        try
        {
            assertTrue(dashboardPage.emptyFirstNameFieldError().isDisplayed());
            assertTrue(dashboardPage.emptyLastNameFieldError().isDisplayed());
            assertTrue(dashboardPage.emptyEmailFieldError().isDisplayed());
            assertTrue(dashboardPage.emptyPasswordFieldError().isDisplayed());
            assertTrue(dashboardPage.emptyCountryFieldError().isDisplayed());

        }
        catch (TimeoutException e)
        {
            System.out.println("TimeOut");
            fail();
        }
    }

    @Test
    public void repatedEmailUsed()
    {
        assertTrue(dashboardPage.accountList.isDisplayed());
        dashboardPage.accountList.click();
        dashboardPage.adminPage.click();
        assertTrue(dashboardPage.addAdminBtn.isDisplayed());
        dashboardPage.addAdminBtn.click();
        dashboardPage.firstName.sendKeys("Admin");
        dashboardPage.lasttName.sendKeys("Test");
        dashboardPage.email.sendKeys("mennafortesting@gmail.com");
        dashboardPage.password.sendKeys("Menna13");
        dashboardPage.mobile.sendKeys("1234567");
        dashboardPage.country.click();
        WebElement countrySelected= driver.findElement(By.cssSelector("#select2-drop > ul > li:nth-child(6)"));
        countrySelected.click();
        dashboardPage.address1.sendKeys("Address 1");
        dashboardPage.address2.sendKeys("Address 2");
        dashboardPage.addLocation.click();
        dashboardPage.editLocation.click();
        dashboardPage.submitBtn.click();
        try
        {
            assertTrue(dashboardPage.repeatedEmailError().isDisplayed());

        }
        catch (TimeoutException e)
        {
            System.out.println("TimeOut");
            fail();
        }

    }

    @Test
    public void shortPasswordUsed()
    {
        assertTrue(dashboardPage.accountList.isDisplayed());
        dashboardPage.accountList.click();
        dashboardPage.adminPage.click();
        assertTrue(dashboardPage.addAdminBtn.isDisplayed());
        dashboardPage.addAdminBtn.click();
        dashboardPage.firstName.sendKeys("Admin");
        dashboardPage.lasttName.sendKeys("Test");
        dashboardPage.email.sendKeys("mennafortesting@gmail.com");
        dashboardPage.password.sendKeys("Men");
        dashboardPage.mobile.sendKeys("1234567");
        dashboardPage.country.click();
        WebElement countrySelected= driver.findElement(By.cssSelector("#select2-drop > ul > li:nth-child(6)"));
        countrySelected.click();
        dashboardPage.address1.sendKeys("Address 1");
        dashboardPage.address2.sendKeys("Address 2");
        dashboardPage.addLocation.click();
        dashboardPage.editLocation.click();
        dashboardPage.submitBtn.click();
        try
        {
            assertTrue(dashboardPage.shortPasswordError().isDisplayed());

        }
        catch (TimeoutException e)
        {
            System.out.println("TimeOut");
            fail();
        }

    }

    @After
    public void tearDown() throws Exception
    {
       dashboardPage.postStop();
    }
}
