package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	Connection conn=null;
	public static Connection ConDB(){
		 try {
			Class.forName("oracle.jdbc.OracleDriver");
			String dbURL2 = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "system";
            String password = "oracle";
            Connection con=DriverManager.getConnection(dbURL2,username,password);
            return con;          			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
//			e.printStackTrace();
		}
	}
	
}
