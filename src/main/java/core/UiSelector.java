package core;

public class UiSelector {

    private String locator = "new UiSelector()";

    public UiSelector text(String value){
        locator += ".text(\""+value+"\")";
        return this;
    }

    public UiObject makeUiObject(){
        return new UiObject(locator);
    }

}
