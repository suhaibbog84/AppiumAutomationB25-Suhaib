package com.cydeo.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTests {

    //launch appiumDriver
    AppiumDriver<MobileElement>driver;

    @Test
    public void calculatorAddTest() throws InterruptedException, MalformedURLException {

        try {

            //DesiredCapabilities
            DesiredCapabilities capabilities = new DesiredCapabilities();
            // caps.setCapability("deviceName", "Pixel 3");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3-Suhaib");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/etsy.apk");

            //set URL for the appium server
            URL url = new URL("http://0.0.0.0:4723/wd/hub");

            driver = new AndroidDriver<MobileElement>(url, capabilities);

            //System.out.println(driver.getTitle());
            System.out.println(driver.getDeviceTime());

            Assertions.assertEquals("android", driver.getPlatformName());

            Thread.sleep(4000);

            //close the app
            driver.closeApp();
        }catch (Exception e){

        }

    }
}
