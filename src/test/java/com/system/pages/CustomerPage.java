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
public class CustomerPage {

    @PostConstruct
    public void initCustomerPage() {
        PageFactory.initElements(webDriver, this);
    }

    @Value("${app.url}")
    private String url;

    @FindBy(how = How.NAME, name = "nicId")
    public WebElement txtNicid;

    @FindBy(how = How.NAME, name = "contactNo")
    public WebElement txtContactno;

    @FindBy(how = How.NAME, name = "vehicleNo")
    public WebElement txtVehicleno;

    @FindBy(how = How.NAME, name = "chassisNo")
    public WebElement txtChassisno;

    @FindBy(how = How.NAME, name = "fuelType")
    public WebElement txtFueltype;

    @FindBy(how = How.NAME, name = "vehicleType")
    public WebElement txtVehicletype;

    @FindBy(how = How.NAME, using = "add")
    public WebElement lnkAdd;

    @Autowired
    private WebDriver webDriver;

    public void customer(String nicId, String contactNo,String vehicleNo,String chassisNo,String fuelType,String vehicleType) {
        webDriver.navigate().to(url);

        Assert.assertNotEquals(nicId,"");
        Assert.assertNotEquals(contactNo,"");
        Assert.assertNotEquals(vehicleNo,"");
        Assert.assertNotEquals(chassisNo,"");
        Assert.assertNotEquals(fuelType,"");
        Assert.assertNotEquals(vehicleType,"");


        txtNicid.sendKeys(nicId);
        txtContactno.sendKeys(contactNo);
        txtVehicleno.sendKeys(vehicleNo);
        txtChassisno.sendKeys(chassisNo);
        txtFueltype.sendKeys(fuelType);
        txtVehicletype.sendKeys(vehicleType);

        clickCustomer();
    }

    public void clickCustomer() {

        System.out.println("Clicked");
        lnkAdd.click();
    }
}
