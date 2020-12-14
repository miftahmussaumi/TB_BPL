import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
	//parameter JDBC untuk koneksi ke DB
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/tb_bpl";
	static final String USERNAME = "root";
	static final String PASSWORD = "";
	//menyiapkan objek
	static Connection conn;
	static Statement stmt;
	static ResultSet result;
	
	public static void conn() {
		try {
		       conn=(Connection) DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
