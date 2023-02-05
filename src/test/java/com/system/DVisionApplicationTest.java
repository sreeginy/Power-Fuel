package com.system;

import com.system.pages.CustomerPage;
import com.system.pages.LoginPage;
import com.system.pages.UserPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Scanner;

@SpringBootTest
public class DVisionApplicationTest {

    @Value("${app.url}")
    private String url;

    @Value("chrome,firefox,edge")
    private List<String> browsers;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private UserPage userPage;

    @Autowired
    private CustomerPage customerPage;

    @Test
    void emptyLogin(){
        loginPage.emptyLoginValidation("","");
    }

    @Test
    void invalidEmailLogin(){
        loginPage.invalidEmailLoginValidation("testemail","");
    }

    @Test
    void performLogin(){
        loginPage.login("abc@gmail.com","12345678");
        performUser();
    }

    @Test
    void performUser(){
        userPage.user("Sreeginy","Giny", "giny@gmail.com");
    }

    @Test
    void performCustomer(){
        customerPage.customer("983476532V","0773423567", "7678","234234234","Petrol","Motorcycles");
    }





}
