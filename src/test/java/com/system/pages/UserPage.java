package com.system.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import javax.annotation.PostConstruct;

@Component
public class UserPage {


    @PostConstruct
    public void initUserPage() {
        PageFactory.initElements(webDriver, this);
    }

    @Value("${app.url1}")
    private String url;

    @FindBy(how = How.NAME, name = "firstName")
    public WebElement txtFirstname;

    @FindBy(how = How.NAME, name = "lastName")
    public WebElement txtLastname;

    @FindBy(how = How.NAME, name = "email")
    public WebElement txtEmail;

    @FindBy(how = How.NAME, using = "add")
    public WebElement lnkAdd;

    @Autowired
    private WebDriver webDriver;

    public void user(String firstName, String lastName,String email) {

        lnkAdd.click();
        Assert.assertNotEquals(firstName,"");
        Assert.assertNotEquals(lastName,"");
        Assert.assertNotEquals(email,"");

        txtFirstname.sendKeys(firstName);
        txtLastname.sendKeys(lastName);
        txtEmail.sendKeys(email);

        clickUser();
    }

    public void clickUser() {

        System.out.println("Clicked");

    }
}
