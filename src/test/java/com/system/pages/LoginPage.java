package com.system.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import org.testng.Assert;
import org.testng.annotations.Test;

@Component
public class LoginPage {


    @PostConstruct
    public void initLoginPage() {
        PageFactory.initElements(webDriver, this);
    }

    @Value("${app.url}")
    private String url;

    @FindBy(how = How.NAME, name = "username")
    public WebElement txtEmail;
    @FindBy(how = How.NAME, using = "password")
    public WebElement txtPassword;

    @FindBy(how = How.ID, using = "username-helper-text")
    public WebElement emailMsg;

    @FindBy(how = How.ID, using = "password-helper-text")
    public WebElement passwordMsg;

    @FindBy(how = How.NAME, using = "login")
    public WebElement lnkLogin;

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private FuelRequestPage fuelRequestPage;

    @Autowired
    private  UserPage userPage;


    public void login(String email, String password) {
        webDriver.navigate().to(url);

        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);


        clickLogin();
    }

    public void emptyLoginValidation(String email, String password){
        webDriver.navigate().to(url);
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);

        lnkLogin.click();

        System.out.println(emailMsg.getText());
        System.out.println(passwordMsg.getText());
    }

    public void invalidEmailLoginValidation(String email, String password){
        webDriver.navigate().to(url);

        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);

        lnkLogin.click();

        System.out.println(emailMsg.getText());
    }

    public void clickLogin() {

        System.out.println("Login Success!");
        lnkLogin.click();
        fuelRequestPage.OpenAddPopUp();
        userPage.user("Sreeginy","Giny", "giny@gmail.com");
    }

}
