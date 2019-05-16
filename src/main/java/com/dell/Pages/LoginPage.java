package com.dell.Pages;

import com.dell.Base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//This class to include all static elements on the Login page
public class LoginPage extends BaseTest {


    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(className = "checkbox")
    public WebElement rememebermeChk;

    @FindBy(css = "form.form-signin.form-horizontal.wow.fadeIn.animated.animated > button")
    public WebElement loginButton;

    @FindBy(id = "link-forgot")
    public WebElement forgetPassworLnk;


    public LoginPage(WebDriver webDriver) {
        //calling constructor of BaseTest
        super(webDriver);

        webDriver.get(properties.getProperty("adminLoginUrl"));

        try {
            //Initializes annotated by FindBy elements
            PageFactory.initElements(webDriver, this);

        } catch (NoSuchElementException e) {
            System.out.println("Elements not found" + e.getMessage());
        }
    }


    public WebElement getWrongCredErrorMsg() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("form.form-signin.form-horizontal.wow.fadeIn.animated.animated > div.resultlogin > div")));
        return driver.findElement(By.cssSelector("form.form-signin.form-horizontal.wow.fadeIn.animated.animated > div.resultlogin > div"));
    }

    public WebElement redirectionMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement redirectionSuccessAlert = driver.findElement(By.cssSelector("form.form-signin.form-horizontal.wow.fadeIn.animated.animated > div.resultlogin > div"));
        return driver.findElement(By.cssSelector("form.form-signin.form-horizontal.wow.fadeIn.animated.animated > div.resultlogin > div"));
    }

    public WebElement getEmailFieldError() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("form.form-signin.form-horizontal.wow.fadeIn.animated.animated > div.resultlogin > div")));
        return driver.findElement(By.cssSelector("form.form-signin.form-horizontal.wow.fadeIn.animated.animated > div.resultlogin > div"));
    }

    /**
     * Sucess login for manging the flow
     */
   public void login(){
        emailField.sendKeys(properties.getProperty("emailAdmin"));
        passwordField.sendKeys(properties.getProperty("passwordAdmin"));
        rememebermeChk.click();
        loginButton.click();
    }

    /**
     * Call this function after login success
     *
     * @return
     */
    public DashboardPage getDashboardPage() throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='https://www.phptravels.net/admin']")));
        return new DashboardPage(driver);

    }

}
