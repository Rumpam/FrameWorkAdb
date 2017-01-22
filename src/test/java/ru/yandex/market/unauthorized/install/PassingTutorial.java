package ru.yandex.market.unauthorized.install;

import api.android.Android;
import core.ADB;
import core.UiObject;
import core.UiSelector;
import core.managers.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static api.android.Android.driver;
import static core.managers.DriverManager.  installerApp;


public class PassingTutorial {

    @Test
    public void tutorial() throws IOException {
        DriverManager.createDriver();
        DriverManager.installerApp();

        UiObject tapNextTutorial1 = new UiSelector().text("Далее").makeUiObject();
        UiObject tapNextTutorial2 = new UiSelector().text("Далее").makeUiObject();
        UiObject tapNextTutorial3 = new UiSelector().text("Далее").makeUiObject();
        UiObject tapNextTutorial4 = new UiSelector().text("Всё ясно").makeUiObject();

        tapNextTutorial1.tap();
        tapNextTutorial2.tap();
        tapNextTutorial3.tap();
        tapNextTutorial4.tap();
        driver.quit();
    }
}
