package cn.techtutorial.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?serverTimezone=Europe/Moscow&useSSL=false","root","7355608Ok!");
            System.out.print("connected");
        }
        return connection;
    }
}
