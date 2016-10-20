package core;

import api.android.Android;
import org.openqa.selenium.WebElement;

public class UiObject {

    private String locator;
    private Boolean isXpath(){
        return !locator.contains("UiSelector");
    }

    UiObject(String locator){
        this.locator = locator;
    }

    public UiObject tap(){
        if(isXpath()) Android.driver.findElementByXPath(locator).click();
        else Android.driver.findElementByAndroidUIAutomator(locator).click();
        return this;
    }

    public String getText(){
        WebElement element;
        element = Android.driver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("text");
    }
}
