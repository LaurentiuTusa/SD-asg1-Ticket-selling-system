package Model;

import java.sql.*;

public class ConnectDB {
    public static Connection startCon(){

        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sd_asg1",
                    "root", "minecraft");
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        return connection;
    }
}
