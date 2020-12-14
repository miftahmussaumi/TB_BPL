import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class mainProgram {
	//parameter JDBC untuk koneksi ke DB
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/tb_bpl";
	static final String USERNAME = "root";
	static final String PASSWORD = "";
	//menyiapkan objek
	static Connection conn;
	static Statement stmt;
	static ResultSet result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		try {
	        conn=(Connection) DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
	        if (conn!=null){
	            System.out.println("'''SELAMAT DATANG DI SUPERMARKET SI'''");
	        }
	        else {
	            System.out.println("Koneksi Gagal");
	        }
	        menu.utama();
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
	}

}
