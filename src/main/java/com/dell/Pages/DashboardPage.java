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
    @FindBy (className = "btn-primary")
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
    @FindBy(css="div:nth-child(1) > div > div.panel-body > ul > li:nth-child(5) > label")
    public WebElement addLocation;
    @FindBy(css = "div:nth-child(2) > div > div.panel-body > ul > li:nth-child(5) > label")
    public WebElement editLocation;




    public WebElement changesSavedNotification()
    {

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-pnotify-shadow")));
        return driver.findElement(By.className("ui-pnotify-shadow"));
    }
    public WebElement emptyEmailFieldError() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.alert.alert-danger > p:nth-child(2)")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'The Email field is required.')]")));
        return driver.findElement(By.xpath("//*[contains(text(),'The Email field is required.')]"));
    }
    public WebElement emptyPasswordFieldError() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'The Password field is required.')]")));
        return driver.findElement(By.xpath("//*[contains(text(),'The Password field is required.')]"));
    }
    public WebElement emptyCountryFieldError() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'The Country field is required.')]")));
        return driver.findElement(By.xpath("//*[contains(text(),'The Country field is required.')]"));
    }

    public WebElement emptyFirstNameFieldError() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'The First Name field is required.')]")));
        return driver.findElement(By.xpath("//*[contains(text(),'The First Name field is required.')]"));
    }
    public WebElement emptyLastNameFieldError() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'The Last Name field is required.')]")));
        return driver.findElement(By.xpath("//*[contains(text(),'The Last Name field is required.')]"));
    }
    public WebElement shortPasswordError()
    {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(" #content > div.alert.alert-danger > p")));
        return driver.findElement(By.cssSelector(" #content > div.alert.alert-danger > p)"));
    }

    public WebElement repeatedEmailError()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.alert.alert-danger > p)")));
        return driver.findElement(By.cssSelector("div.alert.alert-danger > p"));
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
