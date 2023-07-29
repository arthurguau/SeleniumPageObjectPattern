package com.funnygorilla.pageobjectpattern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * mvn clean test -Dwebdriver.chrome.driver="C:\\Opt\\Selenium\\chromedriver.exe"
 * @author guson
 */
public class loginTest {
	

    private LoginPage login;
    
    @BeforeEach
    void setup() {
        login = new LoginPage();  
    }

    @AfterEach
    void teardown() {
    	login.quit();
    }
    
    //------------------------------------------------------------- Page Objects
    @Test
    void testLoginSuccess() {
        login.with("user", "user");
        Assertions.assertTrue(login.successBoxPresent());
    }

    @Test
    void testLoginFailure() {
        login.with("bad-user", "bad-password");
        Assertions.assertFalse(login.successBoxPresent());  
    }

}
