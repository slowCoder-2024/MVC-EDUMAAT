/*
 * Decompiled with CFR 0.152.
 */
package in.jdsoft.educationmanagement.school.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;

public class SystemDetails {
    public static String getSystemMotherBoard_SerialNumber() {
        try {
            String OSName = System.getProperty("os.name");
            if (OSName.contains("Windows")) {
                return SystemDetails.getWindowsMotherboard_SerialNumber();
            }
            return SystemDetails.GetLinuxMotherBoard_serialNumber();
        }
        catch (Exception E) {
            System.err.println("System MotherBoard Exp : " + E.getMessage());
            return null;
        }
    }

    private static String getWindowsMotherboard_SerialNumber() {
        String result = "";
        try {
            String line;
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);
            String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\nSet colItems = objWMIService.ExecQuery _ \n   (\"Select * from Win32_BaseBoard\") \nFor Each objItem in colItems \n    Wscript.Echo objItem.SerialNumber \n    exit for  ' do the first cpu only! \nNext \n";
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                result = String.valueOf(result) + line;
            }
            input.close();
        }
        catch (Exception E) {
            System.err.println("Windows MotherBoard Exp : " + E.getMessage());
        }
        return result.trim();
    }

    private static String GetLinuxMotherBoard_serialNumber() {
        String command = "dmidecode --string system-uuid";
        String sNum = null;
        try {
            Process SerNumProcess = Runtime.getRuntime().exec(command);
            BufferedReader sNumReader = new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
            sNum = sNumReader.readLine().trim();
            SerNumProcess.waitFor();
            sNumReader.close();
        }
        catch (Exception ex) {
            System.err.println("Linux Motherboard Exp : " + ex.getMessage());
            sNum = null;
        }
        return sNum;
    }

    public static String getHardDiskSerialNumber(String drive) {
        String result = "";
        try {
            String line;
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);
            String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\nSet colDrives = objFSO.Drives\nSet objDrive = colDrives.item(\"" + drive + "\")\n" + "Wscript.Echo objDrive.SerialNumber";
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                result = String.valueOf(result) + line;
            }
            input.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result.trim();
    }

    public static String getIPAddress() {
        String strIP = "127.0.0.1";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            strIP = ip.getHostAddress();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return strIP;
    }

    public static String getMACAddress() {
        String strMAC = "127.0.0.1";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < mac.length) {
                sb.append(String.format("%02X%s", mac[i], i < mac.length - 1 ? "-" : ""));
                ++i;
            }
            strMAC = sb.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return strMAC;
    }
}
