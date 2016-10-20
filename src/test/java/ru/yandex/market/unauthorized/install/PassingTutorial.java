package ru.yandex.market.unauthorized.install;

import core.UiObject;
import core.UiSelector;
import core.managers.DriverManager;
import org.junit.Test;

import java.io.IOException;

import static api.android.Android.driver;


public class PassingTutorial {

    @Test
    public void tutorial() throws IOException {
        DriverManager.createDriver();
        DriverManager.installerApp();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        UiObject tapNextTutorial1 = new UiSelector().text("Далее").makeUiObject();
        UiObject tapNextTutorial2 = new UiSelector().text("Далее").makeUiObject();
        UiObject tapNextTutorial3 = new UiSelector().text("Далее").makeUiObject();
        UiObject tapNextTutorial4 = new UiSelector().text("Все ясно").makeUiObject();

        tapNextTutorial1.tap();
        tapNextTutorial2.tap();
        tapNextTutorial3.tap();
        tapNextTutorial4.tap();
        driver.quit();
    }
}
