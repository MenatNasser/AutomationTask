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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class DashBordPageTest {

    WebDriver driver;
    DashboardPage dashboardPage;

    // This is to setup testing execution before each test case
    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        Dimension d = new Dimension(1024,768);
        //Resize the current window to the given dimension
        driver.manage().window().setSize(d);
        //1 To use elements from Login page
        LoginPage loginPage = new LoginPage(driver);
        //2 To login to the system
        loginPage.login(loginPage.properties.getProperty("emailAdmin"), loginPage.properties.getProperty("passwordAdmin"));
        //3 To initiate object from dashboard
        dashboardPage = loginPage.getDashboardPage();
    }

    // First case: Adding new admin
    @Test
    public void addNewAdmin() {
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
        WebElement countrySelected = driver.findElement(By.cssSelector("#select2-drop > ul > li:nth-child(6)"));
        countrySelected.click();
        dashboardPage.address1.sendKeys("Address 1");
        dashboardPage.address2.sendKeys("Address 2");
        dashboardPage.submitBtn.click();
        assertTrue(dashboardPage.changesSavedNotification().isDisplayed());
    }

    // Second case: Editing permission to new admin
    @Test
    public void editNewAdmin() {
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

    // Third case: Leave new admin form empty
    @Test
    public void leaveFormEmpty() {
        assertTrue(dashboardPage.accountList.isDisplayed());
        dashboardPage.accountList.click();
        dashboardPage.adminPage.click();
        assertTrue(dashboardPage.addAdminBtn.isDisplayed());
        dashboardPage.addAdminBtn.click();
        dashboardPage.submitBtn.click();
        try {
            assertTrue(dashboardPage.emptyFirstNameFieldError().isDisplayed());
            assertTrue(dashboardPage.emptyLastNameFieldError().isDisplayed());
            assertTrue(dashboardPage.emptyEmailFieldError().isDisplayed());
            assertTrue(dashboardPage.emptyPasswordFieldError().isDisplayed());
            assertTrue(dashboardPage.emptyCountryFieldError().isDisplayed());

        } catch (TimeoutException e) {
            System.out.println("TimeOut");
            fail();
        }
    }

    // Fourth case: Using already used mail on the system
    @Test
    public void repeatedEmailUsed() {
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
        WebElement countrySelected = driver.findElement(By.cssSelector("#select2-drop > ul > li:nth-child(6)"));
        countrySelected.click();
        dashboardPage.address1.sendKeys("Address 1");
        dashboardPage.address2.sendKeys("Address 2");
        dashboardPage.addLocation.click();
        dashboardPage.editLocation.click();
        dashboardPage.submitBtn.click();
        try {
            assertTrue(dashboardPage.repeatedEmailError().isDisplayed());

        } catch (TimeoutException e) {
            System.out.println("TimeOut");
            fail();
        }
    }

    // Fifth case: Using already short password
    @Test
    public void shortPasswordUsed() {
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
        WebElement countrySelected = driver.findElement(By.cssSelector("#select2-drop > ul > li:nth-child(6)"));
        countrySelected.click();
        dashboardPage.address1.sendKeys("Address 1");
        dashboardPage.address2.sendKeys("Address 2");
        dashboardPage.addLocation.click();
        dashboardPage.editLocation.click();
        dashboardPage.submitBtn.click();
        try {
            assertTrue(dashboardPage.shortPasswordError().isDisplayed());

        } catch (TimeoutException e) {
            System.out.println("TimeOut");
            fail();
        }

    }

    // This is to run after each case executed
    @After
    public void tearDown() throws Exception {
        dashboardPage.postStop();
    }
}
