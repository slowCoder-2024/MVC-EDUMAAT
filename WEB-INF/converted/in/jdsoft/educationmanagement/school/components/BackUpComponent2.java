/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mysql.jdbc.Connection
 *  com.mysql.jdbc.Statement
 *  org.springframework.stereotype.Component
 */
package in.jdsoft.educationmanagement.school.components;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component
public class BackUpComponent2 {
    private static ResultSet res;
    private static Connection con;
    private Statement st;
    private int BUFFER = 99999;

    public String getData(String host, String port, String user, String password, String db) {
        String Mysqlpath = this.getMysqlBinPath(user, password, db);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.print("yaha dekho");
        }
        try {
            con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, password);
            this.st = (Statement)con.createStatement(1004, 1008);
        }
        catch (Exception e) {
            System.out.print("I am here yaaar");
            e.printStackTrace();
        }
        Mysqlpath = Mysqlpath.replace('/', '\\');
        Mysqlpath = Mysqlpath.replace("\\", "\\\\");
        System.out.println(Mysqlpath);
        Process run = null;
        try {
            System.out.println(String.valueOf(Mysqlpath) + "mysqldump --host=" + host + " --port=" + port + " --user=" + user + " --password=" + password + " --compact --complete-insert --extended-insert " + "--skip-comments --skip-triggers " + db);
            run = Runtime.getRuntime().exec(String.valueOf(Mysqlpath) + "mysqldump --host=" + host + " --port=" + port + " --user=" + user + " --password=" + password + "  " + " --compact --databases --add-drop-table --complete-insert --extended-insert " + "--skip-comments --skip-triggers " + db);
        }
        catch (IOException iOException) {
            // empty catch block
        }
        InputStream in = run.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuffer temp = new StringBuffer();
        char[] cbuf = new char[this.BUFFER];
        try {
            int count;
            while ((count = br.read(cbuf, 0, this.BUFFER)) != -1) {
                temp.append(cbuf, 0, count);
            }
        }
        catch (IOException ex) {
            Logger.getLogger(BackUpComponent2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            br.close();
            in.close();
        }
        catch (IOException ex) {
            Logger.getLogger(BackUpComponent2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp.toString();
    }

    public String getMysqlBinPath(String user, String password, String db) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.print("yaha dekho");
        }
        try {
            con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, password);
            this.st = (Statement)con.createStatement(1004, 1008);
        }
        catch (Exception e) {
            System.out.print("I am here yaaar");
            e.printStackTrace();
        }
        String a = "";
        try {
            res = this.st.executeQuery("select @@basedir");
            while (res.next()) {
                a = res.getString(1);
            }
        }
        catch (Exception eee) {
            eee.printStackTrace();
        }
        a = String.valueOf(a) + "\\bin\\";
        System.err.println("Mysql path is :" + a);
        return a;
    }
}
