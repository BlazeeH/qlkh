
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDatabaseManager {
    private static Connection c;
    private static Statement s;
    private static PreparedStatement p;
    private static String host, port, dbName, dbUser, dbPassword;
    
    
    public static Connection connectDB()
    {
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:3306/school";
            String username = "root";
            String password = "";
            java.sql.Connection conn = DriverManager.getConnection(connectionUrl,username,password);
            return conn;
        }catch(Exception e){
            System.out.println("KẾT NỐI CSDL THẤT BẠI " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
 
    //run sql
    public static ResultSet doReadQuery(String sql) {
        ResultSet rs = null;
        try {
            var con = MyDatabaseManager.connectDB();
            PreparedStatement pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MyDatabaseManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    

    //test connection
    public static void main(String[] args) {
        MyDatabaseManager.connectDB();
        
    }
}
