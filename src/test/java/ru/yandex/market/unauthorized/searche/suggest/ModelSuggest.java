package ru.yandex.market.unauthorized.searche.suggest;

import core.managers.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

import static api.android.Android.driver;

public class ModelSuggest {

    @Test
    public void sugestToModel() throws IOException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "76ef68f47cf3");
        caps.setCapability("platformName", "Android-xiaomi");
        caps.setCapability("app", "/Users/w/Downloads/yandexmarket-android_1153.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        Thread.sleep(5000);

        driver.findElement(By.id("ru.yandex.market:id/btn_close")).click();

        WebElement element = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Найдётся всё\")");
        element.click();
        element.sendKeys("Apple iphone 6s 64gb");
        driver.findElement(By.id("ru.yandex.market:id/text")).click();
        Thread.sleep(5000);

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Apple iPhone 6S 64Gb\")").isDisplayed();
        driver.quit();
    }
}
