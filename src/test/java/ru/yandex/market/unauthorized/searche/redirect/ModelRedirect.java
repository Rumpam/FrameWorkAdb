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

public class ModelRedirect {
    @Test
    public void redirectToModel() throws IOException, InterruptedException {
        DriverManager.createDriver();
        DriverManager.installerApp();

        /*
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "BH900GDV4C");
        caps.setCapability("platformName", "Android-xiaomi");
        caps.setCapability("app", "C:\\Users\\mavlyashov\\Downloads\\yandexmarket-android_2_73.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        */

        driver.findElement(By.id("ru.yandex.market:id/btn_close")).click();

        WebElement element = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Поиск на Маркете\")");
        element.click();
        element.sendKeys("Samsung Galaxy S6 edge 32 gb");
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
        Thread.sleep(4000);

        driver.findElementByAndroidUIAutomator("UiSelector().text(\"Samsung Galaxy S6 Edge 32Gb\")").isDisplayed();
        driver.quit();
    }
}
