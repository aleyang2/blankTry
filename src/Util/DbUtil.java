package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// build connection etc.
public class DbUtil {

    Connection con;
    //驱动程序名
    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    String url = "jdbc:mysql://127.0.0.1:3306/CorsTest";
    //MySQL配置时的用户名
    String user = "root";
    //MySQL配置时的密码
    String password = "Tearose1184?";

    public DbUtil () {

    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed())
            System.out.println("Succeeded connecting to the Database!");
        return con;
    }


}
