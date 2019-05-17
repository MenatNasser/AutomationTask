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
    public WebElement logOutLink;
    @FindBy(xpath = "//a[@href='#ACCOUNTS']")
    public WebElement accountList;
    @FindBy(xpath = "//a[@href='https://www.phptravels.net/admin/accounts/admins/']")
    public WebElement adminPage;
    @FindBy(css = "div.panel.panel-default > form > button")
    public WebElement addAdminBtn;
    @FindBy(className = "fa-edit")
    public WebElement editAdmin;
    @FindBy(className = "btn-primary")
    public WebElement submitBtn;
    @FindBy(name = "fname")
    public WebElement firstName;
    @FindBy(name = "lname")
    public WebElement lasttName;
    @FindBy(name = "email")
    public WebElement email;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(name = "mobile")
    public WebElement mobile;
    @FindBy(id = "s2id_autogen1")
    public WebElement country;
    @FindBy(name = "address1")
    public WebElement address1;
    @FindBy(name = "address2")
    public WebElement address2;
    @FindBy(name = "status")
    public WebElement status;
    @FindBy(css = "div:nth-child(1) > div > div.panel-body > ul > li:nth-child(5) > label")
    public WebElement addLocation;
    @FindBy(css = "div:nth-child(2) > div > div.panel-body > ul > li:nth-child(5) > label")
    public WebElement editLocation;
    @FindBy(xpath = "//a[@href='#Locations']")
    public WebElement locationList;
    @FindBy(xpath = "//a[@href='https://www.phptravels.net/supplier/locations']")
    public WebElement locationPage;
    @FindBy(xpath = "//a[@href='https://www.phptravels.net/admin/locations/add']")
    public WebElement addLocationBtn;
    @FindBy(className = "select2-choice")
    public WebElement locationCountry;
    @FindBy(name = "city")
    public WebElement locationCity;
    @FindBy(name = "longitude")
    public WebElement locationLongt;
    @FindBy(name = "latitude")
    public WebElement locationLatit;
    @FindBy(name = "status")
    public WebElement locationStatus;
    @FindBy(name = "translated[ar][name]")
    public WebElement locationArName;
    @FindBy(className = "btn-primary")
    public WebElement submitLocationBtn;


    public WebElement changesSavedNotification() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-pnotify-title")));
        return driver.findElement(By.className("ui-pnotify-title"));
//        WebElement redirectionSuccessAlert = driver.findElement(By.cssSelector("form.form-signin.form-horizontal.wow.fadeIn.animated.animated > div.resultlogin > div"));
//        return driver.findElement(By.cssSelector("form.form-signin.form-horizontal.wow.fadeIn.animated.animated > div.resultlogin > div"));

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

    public WebElement shortPasswordError() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'The Password field must be at least 6 characters in length.')]")));
        return driver.findElement(By.xpath("//*[contains(text(),'The Password field must be at least 6 characters in length.')]"));
    }


    public WebElement repeatedEmailError() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'The Email field must contain a unique value.')]")));
        return driver.findElement(By.xpath("//*[contains(text(),'The Email field must contain a unique value.')]"));
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
