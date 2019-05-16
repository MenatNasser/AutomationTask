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
        loginPage.login();
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

//    @Test
//    public void testMailInputExists() {
////        redirectButton.click();
//
//
//        WebElement accountList = driver.findElement(By.xpath("//a[@href='#ACCOUNTS']"));
//        System.out.print(accountList.getTagName());
//        System.out.println("Menna");
//        assertTrue(accountList.isEnabled());
//        accountList.click();
//        dashboardPage.adminPage.click();
//
//    }

    @Test
    public void addNewAdmin()
    {
        assertTrue(dashboardPage.accountList.isDisplayed());
        dashboardPage.accountList.click();
        dashboardPage.adminPage.click();
        assertTrue(dashboardPage.addAdminBtn.isDisplayed());
        dashboardPage.addAdminBtn.click();


    }

    @After
    public void tearDown() throws Exception
    {
//        loginPage.postStop();
    }
}
