package ru.yandex.market.unauthorized.searche.redirect;

import core.UiObject;
import core.UiSelector;
import core.managers.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import static api.android.Android.driver;

public class ModelModificationRedirect {

    @Test
    public void redirectToModel() throws IOException, InterruptedException {
        DriverManager.createDriver();
        DriverManager.installerApp();

        driver.findElement(By.id("ru.yandex.market:id/btn_close")).click();

        WebElement element = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Поиск на Маркете\")");
        element.click();
        element.sendKeys("Apple macbook pro 13 mid 2012");
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
        Thread.sleep(3000);

        //для начала нужно проскролить до элемента scrollTo()
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Список модификаций\")").isDisplayed();
        driver.quit();
    }
}
