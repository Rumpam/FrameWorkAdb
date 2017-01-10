package core.managers;

import api.android.Android;
import core.ADB;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class DriverManager {

    private static String deviceID;
    private static DriverService service;
    private static HashMap<String, URL> hosts;
    private static String unlockPackage = "io.appium.unlock";


    private static DesiredCapabilities getCaps(String deviceID){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceID);
        caps.setCapability("platformName", "Xiaomi3pro");
        caps.setCapability("app", "/Users/w/Downloads/yandexmarket-android_1247.apk");
        return caps;
    }

    private static URL host(String deviceID) throws IOException {
        if(hosts == null){
            hosts = new HashMap<String, URL>();
            hosts.put("08e8f94f011c4404", new URL("http://0.0.0.0:4723/wd/hub"));
        }return hosts.get(deviceID);
    }

    public static void createDriver() throws IOException {
        ArrayList<String> devices = getAvailableDevices();
        for (String device:devices){
            try {
                Android.driver = new AndroidDriver(host(device), getCaps(device));
                Android.adb = new ADB(device);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static ArrayList<String> getAvailableDevices() {
        ArrayList<String> availableDevices = new ArrayList<String>();
        ArrayList connectedDevices = ADB.getConnectedDevices();
        for (Object connectedDevice : connectedDevices) {
            String device = connectedDevice.toString();
        }
        return availableDevices;
    }

    public static void installerApp(){
        Android.adb.installApp(unlockPackage);
    }
}
