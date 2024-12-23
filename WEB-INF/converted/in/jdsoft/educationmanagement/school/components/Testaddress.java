/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Component
 */
package in.jdsoft.educationmanagement.school.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import org.springframework.stereotype.Component;

@Component
public class Testaddress {
    public static String getMACAddress() {
        StringBuffer strMac = new StringBuffer();
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
            if (ni != null) {
                byte[] mac = ni.getHardwareAddress();
                if (mac != null) {
                    int i = 0;
                    while (i < mac.length) {
                        System.out.format("%02X%s", mac[i], i < mac.length - 1 ? "-" : "");
                        strMac.append(String.format("%02X%s", mac[i], i < mac.length - 1 ? "" : ""));
                        ++i;
                    }
                } else {
                    System.out.println("Address doesn't exist or is not accessible.");
                }
            } else {
                System.out.println("Network Interface for the specified address is not found.");
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return strMac.toString();
    }

    public static String getMotherboardSerial() {
        String result = "";
        try {
            String line;
            File file = File.createTempFile("GetMBSerial", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);
            String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\nSet colItems = objWMIService.ExecQuery _ \n   (\"Select * from Win32_ComputerSystemProduct\") \nFor Each objItem in colItems \n    Wscript.Echo objItem.IdentifyingNumber \nNext \n";
            fw.write(vbs);
            fw.close();
            Process gWMI = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(gWMI.getInputStream()));
            while ((line = input.readLine()) != null) {
                result = String.valueOf(result) + line;
                System.out.println(line);
            }
            input.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        result = result.trim();
        return result;
    }

    public static String getMotherBoardSerialNumber() {
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
        catch (Exception e) {
            e.printStackTrace();
        }
        return result.trim();
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

    public static String getMAC1Address() {
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
