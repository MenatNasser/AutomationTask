package com.dell.Pages;

import com.dell.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BaseTest {

//add all buttons required on dashboard

    @FindBy(xpath = "//a[@href='https://www.phptravels.net/admin/logout']")
    public WebElement logOutLink ;
    @FindBy(xpath = "//a[@href='#ACCOUNTS']")
    public WebElement accountList;
    @FindBy(xpath = "//a[@href='https://www.phptravels.net/admin/accounts/admins/']")
    public WebElement adminPage;
    @FindBy(css = "div.panel.panel-default > form > button")
    public WebElement addAdminBtn;
    @FindBy (className = "btn btn-primary")
    public WebElement submitBtn;
    @FindBy (name= "fname")
    public WebElement firstName;
    @FindBy(name = "lname")
    public WebElement lasttName;
    @FindBy(name = "email")
    public WebElement email;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(name = "mobile")
    public WebElement mobile;
    //    @FindBy(className = "select2-choice")
//    public WebElement country;
    @FindBy(id = "s2id_autogen1")
    public WebElement country;
    @FindBy(name = "address1")
    public WebElement address1;
    @FindBy(name = "address2")
    public WebElement address2;
    @FindBy(name = "status")
    public WebElement status;



    public WebElement emptyEmailFieldError() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.alert.alert-danger > p:nth-child(2)")));
        return driver.findElement(By.cssSelector("div.alert.alert-danger > p:nth-child(2)"));
    }
    public WebElement emptyPasswordFieldError() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.alert.alert-danger > p:nth-child(3)")));
        return driver.findElement(By.cssSelector("div.alert.alert-danger > p:nth-child(3)"));
    }
    public WebElement emptyCountryFieldError() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.alert.alert-danger > p:nth-child(4)")));
        return driver.findElement(By.cssSelector("div.alert.alert-danger > p:nth-child(4)"));
    }

    public WebElement emptyFirstNameFieldError() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.alert.alert-danger > p:nth-child(5)")));
        return driver.findElement(By.cssSelector("div.alert.alert-danger > p:nth-child(5))"));
    }
    public WebElement emptyLastNameFieldError() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.alert.alert-danger > p:nth-child(6)")));
        return driver.findElement(By.cssSelector("div.alert.alert-danger > p:nth-child(6))"));
    }


    public DashboardPage(WebDriver webDriver) {

        super(webDriver);
        try {
            //Initializes annotated by FindBy elements
            PageFactory.initElements(webDriver, this);
        } catch (
                NoSuchElementException e) {
            System.out.println("Elements not found" + e.getMessage());
        }
    }

    // AcountPgae getAcoountPage() // same as DashBorad page in login page
}
