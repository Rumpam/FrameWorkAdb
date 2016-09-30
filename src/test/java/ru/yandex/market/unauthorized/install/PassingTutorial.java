package ru.yandex.market.unauthorized.install;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class PassingTutorial {

    @Test
    public void tutorial() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "BH900GDV4C");
        caps.setCapability("platformName", "Android-xiaomi");
        caps.setCapability("app", "C:\\Users\\mavlyashov\\Downloads\\yandexmarket-android_2_73.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Далее\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Далее\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Далее\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Всё ясно\")").click();
        driver.quit();
    }
}
