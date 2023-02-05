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

@Component
public class FuelRequestPage {
    @PostConstruct
    public void initLoginPage() {
        PageFactory.initElements(webDriver, this);
    }

    @Value("${app.urlFuelRequest}")
    private String url;


    @FindBy(how = How.NAME, using = "add")
    public WebElement lnkAdd;

    @Autowired
    private WebDriver webDriver;

    public void OpenAddPopUp() {
        webDriver.navigate().to(url);

        lnkAdd.click();
    }
}
