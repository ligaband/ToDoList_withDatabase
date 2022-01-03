package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHandler {




        String connectionUrl = "jdbc:mysql://localhost:3306/todolist";
        String user = "";
        String pass = "";

       private static Connection connection;
        public DBHandler(){
            try {
                connection = DriverManager.getConnection(connectionUrl, user, pass);


                System.out.println("Connection to database successful");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error connecting to database");
            }


        }

    public static Connection getConnection() {
        return connection;
    }
}
