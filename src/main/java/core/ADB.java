package core;

import core.managers.ServerManager;

import java.util.ArrayList;

public class ADB {
    public ADB(String deviceID){ID = deviceID;}
    private String ID;


    public void installApp(String apkPath){
        command("adb -s "+ID+" install " + apkPath);
    }

    public static String command(String command){
        if(command.startsWith("adb")) command = command.replace("adb", ServerManager.getAndroidHome()+"/platform-tools/adb");
        else throw new RuntimeException("This method is designed to run ADB commands only!");
        String output = ServerManager.runCommand(command);
        return output.trim();
    }

    public static ArrayList getConnectedDevices(){
        ArrayList devices = new ArrayList();
        String output = command("adb devices");
        for(String line : output.split("\n")){
            line = line.trim();
            if(line.endsWith("device")) devices.add(line.replace("device", "").trim());
        }
        return devices;
    }
}
