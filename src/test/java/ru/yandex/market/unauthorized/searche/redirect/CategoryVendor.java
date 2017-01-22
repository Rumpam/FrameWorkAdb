package ru.yandex.market.unauthorized.searche.redirect;

import core.managers.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

import static api.android.Android.driver;

public class CategoryVendor {

    @Test
    public void redirectToModelAndVendor() throws IOException, InterruptedException {
        DriverManager.createDriver();
        DriverManager.installerApp();

        driver.findElement(By.id("ru.yandex.market:id/btn_close")).click();

        WebElement element = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Поиск на Маркете\")");
        element.click();
        element.sendKeys("televizor Samsung");
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
        Thread.sleep(4000);

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Телевизоры\")").isDisplayed();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Все результаты\")").isDisplayed();
    }
}