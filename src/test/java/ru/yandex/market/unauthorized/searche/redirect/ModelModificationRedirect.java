package ru.yandex.market.unauthorized.searche.redirect;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class ModelModificationRedirect {

    @Test
    public void redirectToModel() throws IOException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "BH900GDV4C");
        caps.setCapability("platformName", "Android-xiaomi");
        caps.setCapability("app", "C:\\Users\\mavlyashov\\Downloads\\yandexmarket-android_2_73.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        Thread.sleep(5000);

        driver.findElement(By.id("ru.yandex.market:id/btn_close")).click();

        WebElement element = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Найдётся всё\")");
        element.click();
        element.sendKeys("Apple macbook pro 13 with retina display");
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
        Thread.sleep(3000);

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ПОПУЛЯРНЫЕ МОДИФИКАЦИИ\")").isDisplayed();
        driver.quit();
    }
}
